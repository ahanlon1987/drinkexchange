package com.dx.service;


import com.dx.view.Order;

import java.util.List;

public interface OrderService {

   public List<Order> findAll() throws Exception;

   public Order findById(Long id) throws Exception;

   public Order create(Order order);

}
