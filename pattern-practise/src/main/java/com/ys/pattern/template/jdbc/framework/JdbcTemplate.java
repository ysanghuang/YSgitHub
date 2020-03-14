package com.ys.pattern.template.jdbc.framework;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/14 12:04
 * @Version: 1.0
 */
public abstract class JdbcTemplate{
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public final List<?> executeQuery(String sql, RowMapper rowMapper,Object[] values) throws SQLException{
            // 1、获取连接
            Connection connection = getConnection();

            // 2、创建语句集
            PreparedStatement ps = connection.prepareStatement(sql);

            // 3、执行语句集
            ResultSet resultSet = executeQuery(ps,values);

            // 4、处理结果集
            List<?> result = new ArrayList();
            result = praseResultSet(resultSet,rowMapper);

            // 5、关闭结果集、关闭语句集、关闭连接
            resultSet.close();
            ps.close();
            connection.close();

            return result;
    }

    private List<?> praseResultSet(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        List<Object> result = new ArrayList();
        while (resultSet.next()){
            result.add(rowMapper.rowMap(resultSet));
        }
        return result;
    }

    private Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    private ResultSet executeQuery(PreparedStatement ps,Object[] values) throws SQLException{
        for(int i=0;i<values.length;i++){
            ps.setObject(i,values[i]);
        }
        return ps.executeQuery();
    }
}
