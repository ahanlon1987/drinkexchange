package com.dx.web;

import com.dx.exception.ControllerException;
import com.dx.service.OrderService;
import com.dx.util.Constants;
import com.dx.util.WrapperUtil;
import com.dx.view.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OrderController extends AbstractController {

    private static final String REQ_URL_VAR_START = "/{";
    private static final String REQ_URL_VAR_END = "}";
    private static final String ORDERS_REQ_URL = "/orders";

    private static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @RequestMapping(value = ORDERS_REQ_URL, method = RequestMethod.GET)
    public String findAllOrders(  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        log.warn("findAllOrders: ");
        return writeResponse(this.getOrderService().findAll());
    }

    @ResponseBody
    @RequestMapping(value = ORDERS_REQ_URL + REQ_URL_VAR_START + Constants.ORDER_ID + REQ_URL_VAR_END , method = RequestMethod.GET)
    public String findOrdersById(  @PathVariable(Constants.ORDER_ID) Long orderId,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        log.warn("findOrderById: ");
        if(WrapperUtil.isBlank(orderId)){
            throw new ControllerException("orderId must not be blank.");
        }

        return writeResponse(this.getOrderService().findById(orderId));
    }

    @ResponseBody
    @RequestMapping(value = ORDERS_REQ_URL , method = RequestMethod.POST)
    public String createByOrg(@RequestBody Order order,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {

        log.warn("createOrder start");
        if(order == null ) {
            throw new ControllerException("Order and organizationId must not be null.");
        }

        return writeResponse(getOrderService().create(order));
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

}
