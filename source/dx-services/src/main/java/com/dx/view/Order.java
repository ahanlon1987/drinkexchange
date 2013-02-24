package com.dx.view;

import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;

public class Order  {

    private static final long serialVersionUID = 1L;

    public Order() {
        super();
    }

    public Order(JSONObject orderModel) throws JSONException {

        if(orderModel != null) {
            this.id = (Double) orderModel.get("id");
            this.amount =  (Double) orderModel.get("amount");
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

    private Double amount;


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

    public Double getAmount() {
        return amount;
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

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * ***********************************************************************
     * <p/>
     * METHODS.
     * <p/>
     * ***********************************************************************
     */
}
