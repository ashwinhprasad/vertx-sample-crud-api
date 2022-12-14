package org.rest.api.utils;

import io.vertx.core.json.JsonObject;
import org.rest.api.dao.apiDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class apiDBUtils {

    public static JsonObject getAPIData() {
        JsonObject response = new JsonObject();
        ResultSet rs = null;
        ArrayList<JsonObject> objs = new ArrayList<>();
        try {
            rs = apiDao.retrieveQuery("SELECT * FROM testapi",new ArrayList<>());
            while (rs.next()) {
                JsonObject obj = new JsonObject();
                obj.put("api name", (rs.getString(1)));
                obj.put("url", (rs.getString(2)));
                objs.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.put("apis",objs);
        return response;
    }


    public static void addAPIData(JsonObject api) {
        ArrayList<String> params = new ArrayList<>();
        params.add(api.getString("apiname"));
        params.add(api.getString("url"));
        try {
            apiDao.executeQuery("insert into testapi values (? , ?)", params);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteAPIData(String apiName) {
        ArrayList<String> params = new ArrayList<>();
        params.add(apiName);
        try {
            apiDao.executeQuery("DELETE FROM testapi WHERE apiname = ?", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JsonObject getAPISet(String apiName) {
        JsonObject response = new JsonObject();
        ResultSet rs = null;
        ArrayList<String> param = new ArrayList<>();
        param.add(apiName);
        ArrayList<JsonObject> objs = new ArrayList<>();
        try {
            rs = apiDao.retrieveQuery("SELECT * FROM testapi where apiname = ?",param);
            while (rs.next()) {
                JsonObject obj = new JsonObject();
                obj.put("api name", (rs.getString(1)));
                obj.put("url", (rs.getString(2)));
                objs.add(obj);
            }
            response.put("response",objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

}
