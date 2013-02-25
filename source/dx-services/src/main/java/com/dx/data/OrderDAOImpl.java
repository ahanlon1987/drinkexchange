package com.dx.data;

import com.mongodb.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {


    public List<JSONObject> findAll() throws UnknownHostException, JSONException {

        MongoClient mongoClinet = new MongoClient("localhost", 27017);
        DB db = mongoClinet.getDB("test");

        DBCollection coll = db.getCollection("orders");
        DBCursor cursor = coll.find();

        List<JSONObject> collectionObjects = new ArrayList<JSONObject>();

        try {
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
                JSONObject nextDoc = new JSONObject(obj.toString());
                collectionObjects.add(nextDoc);
            }
        } finally {
            cursor.close();
        }

        return collectionObjects;
    }

    public JSONObject findById(Long id) throws UnknownHostException, JSONException {

        MongoClient mongoClinet = new MongoClient("localhost", 27017);
        DB db = mongoClinet.getDB("test");
        DBCollection coll = db.getCollection("orders");

        BasicDBObject query = new BasicDBObject("id", id);
        DBCursor cursor = coll.find(query);
        JSONObject jsonObject = null;

        try {
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
                jsonObject = new JSONObject(obj.toString());
            }
        } finally {
            cursor.close();
        }

        return jsonObject;
    }

}
