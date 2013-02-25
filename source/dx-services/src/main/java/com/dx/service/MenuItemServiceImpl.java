package com.dx.service;

import com.dx.data.MenuItemDAO;
import com.dx.util.WrapperUtil;
import com.dx.view.MenuItem;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("MenuItemService")
public class MenuItemServiceImpl implements MenuItemService {

    private static final Logger log = LoggerFactory.getLogger(MenuItemServiceImpl.class);

    @Autowired
    private MenuItemDAO menuItemDAO;


    public List<MenuItem> findAll() throws Exception {

        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        List<JSONObject> allMenuItems = this.getMenuItemDAO().findAll();

        if(allMenuItems != null) {
            System.out.println("allMenuItems is not null, found: " + allMenuItems.size() + " menuItems.");

            for(JSONObject currMenuItem : allMenuItems){
                menuItems.add(new MenuItem(currMenuItem));
            }
        } else {
            System.out.println("allOrders is null.");
        }

        return menuItems;
    }

    public MenuItem findById(Long id) throws Exception {

        if(WrapperUtil.isBlank(id)){
            throw new Exception("id cannot be null");
        }

        JSONObject menuItemModel = this.getMenuItemDAO().findById(id);
        if(menuItemModel != null) {
            System.out.println("MenuItem with id: " + id + ", was found, returning.");
        } else {
            System.out.println("Unable to find menuItems with id: " + id);
        }

        return new MenuItem(menuItemModel);
    }


    public MenuItemDAO getMenuItemDAO() throws Exception {
            if(menuItemDAO == null) {
                throw new Exception("MenuItemDAO must not be null.");
            }
            return menuItemDAO;
        }

        public void setMenuItemDAO(MenuItemDAO menuItemDAO) {
            this.menuItemDAO = menuItemDAO;
        }
}
