package com.example.demo.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyMapperProxy
 * @Description 这是一个代理对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 17:06
 **/
public class MyMapperProxy implements InvocationHandler {

    /**
     * 我们的Mapper映射代理，应该持有一个对象来执行Mapper的方法
     * 本来呢，我们应该是持有mapper对应的class对象来执行的，
     * 但是我们在分析configuration的时候，说过了我们的mapper是interface，只有行为类型
     * 而没有具体行为内容，但是mapper最终是执行crud操作的，而我们的SqlSession就是执行crud操作的
     * 所以我们的代理类，应该持有一个MysqlSession，来执行crud操作
     */
    private MySqlSession mySqlSession;

    /**
     * 同样我们有对象关系之后，那么就通过构造方法来建立他们之间的关系
     * @param mySqlSession
     */
    public MyMapperProxy(MySqlSession mySqlSession) {
        this.mySqlSession = mySqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 在mapper的行为内容中，是由MySqlSession来进行动作
         *
         * 注意，我们在SqlSession selectOne的时候，分析了
         * 我们在调用selectOne之前，是拿到了sql和参数信息的，而在invoke方法中明显看到
         * 是没有相关信息的。
         *
         * 那么我们看Mybatis源码，mybatis是怎么获取的呢，是在invoke的时候，通过MapperMethod对象
         * 根据args信息，以及configuration在解析mapper以及xml是获取的信息，然后通过两者对比解析，获得的Param对象参数
         *
         * 我们这里，省略解析步骤，那么从哪里开始模拟呢？从configuration里面拿到xml信息之后，然后在这里，进行方法匹配，
         * 然后调用到session的方法
         *
         */
        //1、首先我们应该先获得Xml信息 就是MyConfiguration.UserInfoMapper.namespace) 因为是静态类静态量，所以直接取信息就行
        //接下来是根据参数来找到sql和param
        //1、我们要根据namespace来找到，我们对应的mapper xml信息 因为我们模拟有一个类，所以就不走查找了，用判断来模拟查找过程
        //   true代表找到了，false代表没有找到
        if (method.getDeclaringClass().getName().equals(MyConfiguration.UserInfoMapper.namespace)) {
            //获取到namespace之后，那么就可以从xml信息中获取到sql信息
            String sql = MyConfiguration.UserInfoMapper.mapperMap.get(method.getName());
            return mySqlSession.selectOne(sql, String.valueOf(args[0])); //然后就能执行查询方法，进行查询操作了。
        }
        return method.invoke(this, args); //否则就由代理类来执行方法
    }
}
