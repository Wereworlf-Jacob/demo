package com.example.demo.lamda;

/**
 * @ClassName IConvert
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/5/20 17:00
 **/
@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}
