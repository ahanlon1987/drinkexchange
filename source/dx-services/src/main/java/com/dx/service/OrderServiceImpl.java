package com.dx.service;

import com.dx.data.ReadDAO;
import com.dx.util.WrapperUtil;
import com.dx.view.Order;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ReadDAO readDAO;


    public List<Order> findAll() throws Exception {

        List<Order> orders = new ArrayList<Order>();
        List<JSONObject> allOrders = this.getReadDAO().findAll();

        if(allOrders != null) {
            System.out.println("allOrders is not null, found: " + allOrders.size() + " orders.");

            for(JSONObject orderModel : allOrders){
                orders.add(new Order(orderModel));
            }
        } else {
            System.out.println("allOrders is null.");
        }

        return orders;
    }

    public Order findById(Long id) throws Exception {

        if(WrapperUtil.isBlank(id)){
            throw new Exception("id cannot be null");
        }

        JSONObject orderModel = this.getReadDAO().findById(id);
        if(orderModel != null) {
            System.out.println("Order with id: " + id + ", was found, returning.");
        } else {
            System.out.println("Unable to find order with id: " + id);
        }

        return new Order(orderModel);
    }

    public Order create(Order order) {

        //TODO
        return null;
    }



    public ReadDAO getReadDAO() throws Exception {
        if(readDAO == null) {
            throw new Exception("ReadDAO must not be null.");
        }
        return readDAO;
    }

    public void setReadDAO(ReadDAO readDAO) {
        this.readDAO = readDAO;
    }
}
