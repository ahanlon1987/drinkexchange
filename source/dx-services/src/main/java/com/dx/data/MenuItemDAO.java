package com.dx.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.List;

public interface MenuItemDAO {

    public List<JSONObject> findAll() throws UnknownHostException, JSONException;

    public JSONObject findById(Long id) throws UnknownHostException, JSONException;

}
