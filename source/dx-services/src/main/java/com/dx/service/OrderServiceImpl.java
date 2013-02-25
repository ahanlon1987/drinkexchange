package com.dx.service;

import com.dx.data.OrderDAO;
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
    private OrderDAO orderDAO;


    public List<Order> findAll() throws Exception {

        List<Order> orders = new ArrayList<Order>();
        List<JSONObject> allOrders = this.getOrderDAO().findAll();

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

        JSONObject orderModel = this.getOrderDAO().findById(id);
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


    public OrderDAO getOrderDAO() throws Exception {
         if(orderDAO == null) {
             throw new Exception("orderDAO must not be null.");
         }
         return orderDAO;
     }

     public void setOrderDAO(OrderDAO orderDAO) {
         this.orderDAO= orderDAO;
     }

}
