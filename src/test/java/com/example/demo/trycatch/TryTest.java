package com.example.demo.trycatch;

/**
 * @ClassName TryTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/15 17:12
 **/
public class TryTest {

    public static void main(String[] args) {
        try(MyConnection connection = new MyConnection();
            MyStatement statement = connection.preparedStatement();
            MyResultSet rs = statement.executeQuery();
        ){
            statement.setParams();
            rs.getString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * new Myconection!
         * connection get preparedStatement
         * new MyStatement
         * statement executeQuery
         * new MyResultSet!
         * statement setParams
         * myResultSet get Result string
         * myResultSet closed!
         * myStatement closed!
         * I'm closed
         * 经过测试发现，该方法自上而下执行，无法在executeQuery之前执行setParam参数，关闭时，会从参数自下而上关闭
         */
    }

}
