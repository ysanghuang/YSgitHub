package com.ys.pattern.flyweight.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/17 20:18
 * @Version: 1.0
 */
public class ConnectionPool {
    private String url = "jdbc:mysql://localhost:3306/fiction";
    private String username = "root";
    private String password = "123456";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int maxSize = 100;

    private Vector<Connection> pool;

    public ConnectionPool() {
        pool = new Vector<Connection>(maxSize);
        try {
            Class.forName(driverClassName);
            for(int i=0;i<pool.size();i++){
                Connection connection = DriverManager.getConnection(url,username,password);
                pool.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        if (pool.size() <= 0){
            return null;
        }
        Connection connection = pool.get(0);
        pool.remove(connection);
        return connection;
    }

    public synchronized void release(Connection connection){
        pool.add(connection);
    }
}
