package com.ys.pattern.template.jdbc.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/14 12:09
 * @Version: 1.0
 */
public interface RowMapper<T> {
    T rowMap(ResultSet resultSet) throws SQLException;
}
