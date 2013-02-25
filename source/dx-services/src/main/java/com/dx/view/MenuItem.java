package com.dx.view;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuItem {

    private static final long serialVersionUID = 1L;

    public MenuItem() {
        super();
    }

    public MenuItem(JSONObject menuItemModel) throws JSONException {

        if(menuItemModel != null) {
            this.id = (Double) menuItemModel.get("id");
            this.price = (Double) menuItemModel.get("price");
            this.percentChange = (Double) menuItemModel.get("percentChange");
            this.displayName = (String) menuItemModel.get("displayName");
        }
    }

    /**
     * ***********************************************************************
     * <p/>
     * MEMBER VARIABLES
     * <p/>
     * ***********************************************************************
     */
    private Double id;

    private Double price;

    private Double percentChange;

    private String displayName;



    /**
     * ***********************************************************************
     * <p/>
     * GETTERS
     * <p/>
     * ***********************************************************************
     */
    public Double getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * ***********************************************************************
     * <p/>
     * SETTERS.
     * <p/>
     * ***********************************************************************
     */
    public void setId(Double id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * ***********************************************************************
     * <p/>
     * METHODS.
     * <p/>
     * ***********************************************************************
     */
}
