package com.gupaoedu.vip.pattern.builder.sql;

import javax.management.Query;
import java.util.Arrays;

/**
 * Created by Tom.
 *
 * 下面我们再来看一个实战案例，这个案例参考了开源框架JPA的SQL构造模式。是否记得我们在构
 * 造SQL查询条件的时候，需要根据不同的条件来拼接SQL字符串。如果查询条件复杂的时候，我们SQL
 * 拼接的过程也会变得非常复杂，从而给我们的代码维护带来非常大的困难。因此，我们用建造者类
 * QueryRuleSqlBuilder 将复杂的构造 SQL 过程进行封装，用 QueryRule 对象专门保存 SQL 查询时的
 * 条件，最后根据查询条件，自动生成SQL语句。
 */
public class Test {
    public static void main(String[] args) {
        // TODO
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("age");
        queryRule.andEqual("addr","Changsha");
        queryRule.andLike("name","Tom");
        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);

        System.out.println(builder.builder("t_member"));

        System.out.println("Params: " + Arrays.toString(builder.getValues()));


    }
}
