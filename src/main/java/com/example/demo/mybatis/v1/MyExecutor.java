package com.example.demo.mybatis.v1;

import java.util.List;

/**
 * @ClassName MyExecutor
 * @Description 模拟Executor
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/14 15:13
 **/
public interface MyExecutor {

    /**
     * 我们的Executor应该有crud操作，我们这里只写一个qury来模拟，而且query是只有一个返回值
     * 而我们的Query操作，需要的参数是什么，简单的来讲是sql和parameter
     * @param statement sql
     * @param parameter 参数
     * @param <T>
     * @return
     */
    <T> T query(String statement, String parameter);

}
