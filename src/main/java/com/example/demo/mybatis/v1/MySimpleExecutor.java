package com.example.demo.mybatis.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName MySimpleExecutor
 * @Description 模拟mybatis，的简易查询器
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 17:16
 **/
public class MySimpleExecutor implements MyExecutor {

    /**
     * 当我们定义好MyExecutor行为规则之后，那么我们就需要有一个class，来定义一个拥有这些行为的具体对象
     * @param statement sql
     * @param parameter 参数
     * @return
     */
    @Override
    public Object query(String statement, String parameter) {
        //在这里，我们使用JDBC去进行数据查询
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserInfo userInfo = null;
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://114.116.53.133:1521/htfsweb_saas2", "root", "123456");
            PreparedStatement ps = connection.prepareStatement(String.format(statement, parameter));
            ResultSet rs = ps.executeQuery()
        ){
            while (rs.next()) {
                userInfo = new UserInfo();
                userInfo.setId(rs.getString(1));
                userInfo.setUsername(rs.getString(3));
                userInfo.setTrueName(rs.getString(5));
                userInfo.setPhone(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

}
