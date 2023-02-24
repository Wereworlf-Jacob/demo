package com.example.demo.design.pattern.A05singleton;

/**
 * 定义单例模式
 * @auth Jacob
 * @date 2020/8/31 17:11
 */
public class Singleton {

    private static Singleton uniqueInstance;

    public Singleton() {
    }

    /**
     * 默认懒加载创建单例对象，多线程下存在可能创建出两个单例对象的问题
     * @author Jacob
     * @date 2020/8/31 17:14
     * @return com.example.demo.design.pattern.singleton.Singleton
     */
    public static Singleton getInstanceDefaultLazy() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 同步锁的方式懒加载实例，虽然线程安全，但是每次消耗synchronized资源
     * @author Jacob
     * @date 2020/8/31 17:13
     * @return com.example.demo.design.pattern.singleton.Singleton
     */
    public static synchronized Singleton getInstanceSyncLazy() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 使用默认的饿汉加载方式，加载类信息的时候，就初始化一个单例对象，然后直接使用
     * @author Jacob
     * @date 2020/8/31 17:17
     * @return com.example.demo.design.pattern.singleton.Singleton
     */
//    private static Singleton uniqueInstance = new Singleton();
    public static Singleton getInstanceDefaultHungry() {
        return uniqueInstance;
    }

    /**
     * 使用双重检查加锁的方式懒加载单例对象，其中volatile 关键字用来保证
     * 在多线程情况下，对象对于线程的可见性，避免重复创建单例对象
     *
     * 当对象被初始化成Singleton实例时，多个线程正确地处理变量
     *
     * 此方法不适用于1.4及更早的java版本，因为JVM对于volatile的实现导致双重检查失效
     * @author Jacob
     * @date 2020/8/31 17:19
     * @return com.example.demo.design.pattern.singleton.Singleton
     */
//    private volatile static Singleton uniqueInstance = new Singleton();
    public static Singleton getInstanceDoubleLockLazy() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    //1.2 版本之前，垃圾回收器有个bug，会造成当单件在没有全局的引用时被当作垃圾清除，也就是一个单件只有单件类引用他本身。但是之后bug修复了。

    public static void main(String[] args) {

    }



}
