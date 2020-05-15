package com.example.demo.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyConfiguration
 * @Description 模拟mybatis的configuration
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 15:12
 **/
public class MyConfiguration {

    /**
     * 我们在使用的过程中调用的是SqlSession的getMapper
     * 但是实际上，我们的SqlSession作为管理者，收到这个行为后，将这个行为转达给configuration来执行
     * 所以实际发生这个行为的是我们的configuration
     * @param type 是一个MapperInterface
     * @param <T> 返回的可以是任意一个类型的Mapper信息
     * @return
     */
    public <T> T getMapper(Class<T> type, MySqlSession mySqlSession) { //因为在代理对象执行mapper的方法时，需要通过SqlSession来执行，所以需要追加参数MySqlSession
        /**
         * 通过我们对源码的了解
         * 此处，我们只有一个MapperInterface，然后需要返回一个type类型的实例，来执行CRUD方法
         * 所以我们需要用到代理模式，来帮我们生成一个实例
         * 如此我们就需要有一个代理对象，来帮我们执行MapperInterface的方法
         * 因为我们Mapper是一个interface，没有class，所以理论上来讲，执行mapper的方法，就是执行代理的方法
         * 而我们的mapper从类信息上看，是没有具体的行为的，而他的行为在哪呢？
         * 就在xml里面，我们要执行xml里面的sql，所以由Configuration解析xml之后，再由我们的MapperProxy来调用Executor的方法来执行sql
         * 所以我们需要有一个MyMapperProxy
         */
        return (T) Proxy.newProxyInstance(mySqlSession.getClass().getClassLoader(),
                new Class[]{type},
                new MyMapperProxy(mySqlSession));

    }

    /**
     * 在这里模拟一个已经获取到XML信息的一个过程
     * xml在加载的过程中解析后，由configuration对象持有，所以在这个地方就模拟已经有了一个configuration
     * //在这里，我们写一个，假设我们已经解析到一个UserInfoMapper
     */
    static class UserInfoMapper{
        //首先，我们解析xml，第一个获取到的就是namespace
        public static final String namespace = "com.example.demo.mybatis.v1.UserInfoMapper";
        //其次，我们有一个容器，来对应方法和sql的关系
        public static final Map<String, String> mapperMap = new HashMap<String, String>();
        static {
            //我们通过静态代码块，将方法，sql的对应关系放进去
            mapperMap.put("selectByPrimaryKey", "select * from user_info where Id = '%s'");
        }
    }

}
