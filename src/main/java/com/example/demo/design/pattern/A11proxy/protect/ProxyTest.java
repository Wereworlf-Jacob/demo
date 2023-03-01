package com.example.demo.design.pattern.A11proxy.protect;

import java.lang.reflect.Proxy;

/**
 * @auth Jacob
 * @date 2023/2/28 15:03
 */
public class ProxyTest {
    PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }
    PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean));
    }
    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        PersonBean joe = new PersonBeanImpl("乔", "男");
        PersonBean li = new PersonBeanImpl("李", "女");
        /**
         * 拥有者可以访问getter和settter但是不能设置评分
         * */
        PersonBean ownerProxy = proxyTest.getOwnerProxy(joe);
        System.out.println("姓名是：" + ownerProxy.getName());
        ownerProxy.setInterests("保龄球，去吧");
        System.out.println("拥有者代理设置了兴趣：" + ownerProxy.getInterests());
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("拥有者不能设置评分");
        }
        System.out.println("评分是：" + ownerProxy.getHotOrNotRating());

        /**
         * 非拥有者可以访问getter和设置评分，不能访问setter
         */
        PersonBean nonOwnerProxy = proxyTest.getNonOwnerProxy(li);
        System.out.println("姓名是：" + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("保龄球，去吧");
        } catch (Exception e) {
            System.out.println("非拥有者不能设置兴趣");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("非拥有者设置了评分");
        System.out.println("评分是：" + nonOwnerProxy.getHotOrNotRating());
    }
}
