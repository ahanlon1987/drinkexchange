package com.dx.web;

import com.dx.exception.ControllerException;
import com.dx.service.MenuItemService;
import com.dx.util.Constants;
import com.dx.util.WrapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MenuItemController extends AbstractController {

    private static final String REQ_URL_VAR_START = "/{";
    private static final String REQ_URL_VAR_END = "}";
    private static final String MENU_ITEM_URL = "/menuItems";

    private static Logger log = LoggerFactory.getLogger(MenuItemController.class);

    @Autowired
    private MenuItemService menuItemService;


    @ResponseBody
    @RequestMapping(value = MENU_ITEM_URL, method = RequestMethod.GET)
    public String findAllOrders(  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        log.warn("findAllMenuItems: ");
        return writeResponse(this.getMenuItemService().findAll());
    }

    @ResponseBody
    @RequestMapping(value = MENU_ITEM_URL + REQ_URL_VAR_START + Constants.ORDER_ID + REQ_URL_VAR_END , method = RequestMethod.GET)
    public String findOrdersById(  @PathVariable(Constants.MENU_ITEM_ID) Long menuItemId,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        log.warn("findOrderById: ");
        if(WrapperUtil.isBlank(menuItemId)){
            throw new ControllerException("menuItemId must not be blank.");
        }

        return writeResponse(this.getMenuItemService().findById(menuItemId));
    }


    public MenuItemService getMenuItemService() {
        return menuItemService;
    }

    public void setMenuItemService(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

}
