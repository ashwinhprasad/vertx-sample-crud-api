package org.rest.api.dao;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class apiDao {

    static Connection con = masterDao.getConnection();

    public static ResultSet getAPIsDao(String query) throws SQLException {
        JsonObject response = new JsonObject();
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        return rs;
    }


}
