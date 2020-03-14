package com.ys.pattern.template.jdbc;

import com.ys.pattern.template.jdbc.dao.MemberDao;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/14 12:49
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        //TODO
        DataSource dataSource;
        MemberDao dao = new MemberDao(null);
        dao.queryAll(null);
    }
}
