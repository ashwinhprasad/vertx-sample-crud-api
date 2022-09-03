package org.rest.api.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import org.rest.api.creds.dbCreds;

public class masterDao {
    static String url;
    static String username;
    static String password;
    static Connection con;

    private masterDao() {}

    public static void connectToDatabase(String url,String dbName,String username,String password) {
        url = url;
        url += dbName;
        username = username;
        password = password;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection Established Succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
       return con;
    }

}
