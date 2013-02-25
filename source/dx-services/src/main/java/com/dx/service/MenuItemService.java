package com.dx.service;


import com.dx.view.MenuItem;

import java.util.List;

public interface MenuItemService {

   public List<MenuItem> findAll() throws Exception;

   public MenuItem findById(Long id) throws Exception;


}
