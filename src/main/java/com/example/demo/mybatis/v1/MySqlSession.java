package com.example.demo.mybatis.v1;

/**
 * @ClassName MySqlSession
 * @Description 模拟mybatis的sqlSession
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 15:12
 **/
public class MySqlSession {

    /**
     * 通过对Mybatis源码的阅读，可以获得对象关系模型
     * configuration <----  sqlSession -----> Executor
     * configuration负责从各个配置文件获得配置信息，
     * 而Executor负责调度Jdbc从数据库中获取数据
     * 那么可以梳理得
     * SqlSession应该持有一个configuration和Executor
     * 作为核心，sqlSession相当于一个manager角色
     * 通过sqlSession来调度获取配置和查询操作
     */

    private MyConfiguration configuration;

    private MyExecutor executor;

    public MyConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * 既然SqlSession应该持有二者，那么这两者之间就应该有一个关联关系
     * 那么就应该类似IOC容器似的管理，通过构造方法，将二者注入进来
     * @param configuration
     * @param executor
     */
    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 从SqlSession中呢，可以获得一个Mapper对象，然后再通过Mapper对象来执行固定的方法
     * 所以此处模拟一个获取Mapper的方法
     * @param type 传过来的MapperClass信息
     * @param <T> 从SqlSession中应该能获取各种类型的Mapper，所以此处应该是一个泛型
     * @return
     */
    public <T> T getMapper(Class<T> type){
        /**
         * 我们通过对代码的了解，可以知道我们是通过配置信息
         * 从Configuration中获取到的mapper，所以这个时候，就交给configuration去获取mapper
         * 我们这个里面只负责将拿到的数据返回就可以了。
         */
        return configuration.getMapper(type, this);
    }

    /**
     * 获取到Mapper之后呢，我们就可以调用Mapper的select方法了，而Mapper的方法呢，最终调用
     * 到的就是SqlSession的select方法，所以此处应该有一个select方法，此处只先写一个selectOne
     * 而sqlSession的sql，又是交由Executor来执行CURD操作的，所以调用Executor的query方法
     *
     * 注意，这个selectOne和Mapper中的selectPrimaryKey是不一样的，在调用selectOne的时候
     * 我们明显是拿到了sql语句和参数，然后再调用该方法，然后调用executor的。所以这里的selectOne
     * 仅仅表示，我要查询数据，而不是传一个key直接返回一个Object。这是不可能的。
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement, String parameter){
        return executor.query(statement, parameter);
    }

}
