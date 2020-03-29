package com.ys.pattern.flyweight.pool;

import java.sql.Connection;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/17 20:55
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection connection = pool.getConnection();
    }
}
