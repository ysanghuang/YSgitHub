package com.ys.pattern.template.jdbc.dao;

import com.ys.pattern.template.jdbc.entity.Member;
import com.ys.pattern.template.jdbc.framework.JdbcTemplate;
import com.ys.pattern.template.jdbc.framework.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/14 12:36
 * @Version: 1.0
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> queryAll(Object[] values) throws SQLException {
        String sql = "select * from member";
        List result = super.executeQuery(sql, new RowMapper<Member>() {
            public Member rowMap(ResultSet resultSet) throws SQLException {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setNickname(resultSet.getString("nickname"));
                member.setAddr(resultSet.getString("addr"));
                member.setAge(resultSet.getInt("age"));
                return member;
            }
        },values);
        return result;
    }
}
