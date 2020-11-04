23种设计模式：
Strategy 策略模式, Observer 观察者模式, Decorator 装饰器模式, Abstract Factory 抽象工厂模式,
Factory Method 工厂方法, Singleton 单例模式, Command 命令模式,
Adapter 适配器模式, Facade 外观模式, Template Method, Iterator, Composite, State, Proxy

Bridge, Builder, Chain of Responsibility, Flyweight, Interpreter, Mediator, Memento, Prototype, Visitor.

四个OO基本概念：
抽象、封装、继承、多态

九个OO原则：
封装变化
多用组合，少用继承
针对接口编程，不针对实现编程
为交互对象之间的松耦合设计而努力

类应该对扩展开发，对修改关闭
依赖抽象，不依赖具体类

只和朋友交谈（最小知识原则）

好莱坞原则：别调用我们，我们会调用你

设计模式的思考：
如果设计一个超类，使用继承的话，那么当扩展行为时，容易让其他子类发生不希望的改变，如果只有接口呢，
那么会有大量的重复代码，因为子类可能存在同一种行为；那么此时应该，混合使用，子类肯定有的行为，使用
继承，部分子类有的设计成接口，比如Closeable等等；子类继承超类，再实现自己的接口。
靠：这样也会造成代码无法复用，因为可能大部分子类都有closeable方法，而且closeable的方式也可能多种多样
所以也不合适。

那么我们应该把变化的行为分离出来，然后有固定的类去实现这些行为，那么就可以继续使用继承的方式了，但是
有两种不同变化的行为，我怎么让对象同时具有这两种行为呢？

最小知识原则：
    我们只调用和我们自己有关的对象的方法，尽量避免去调用返回值对象的方法，因为我们不是很需要知道这个对象
    也就是，我们尽量在类中少import其他的类
    和自己有关的部分：比如
    public class Car {
        //发动机
        Engine engine; //这是一个类的组件，我们能调用它的方法
        public Car() {
            //初始化发动机
        }
        public void start(Key key) { //被方法当作参数传进来的对象
            Doors doors = new Doors(); //被创建的对象
            boolean authorize = key.turns();
            if (authorize) {
                engine.start();
                updateDashboardDisplay();
                doors.lock();
            }
        }
        public void updateDashboardDisplay() { //该对象本身的方法
            //更新显示
        }
    }
        该对象本身 updateDashboardDisplay()
        被当作方法的参数而传递进来的对象 Key
        此方法所创建或实例化的任何对象 Doors
        对象的任何组件 Engine

好莱坞原则：
    我们允许低层组件将自己挂钩到系统上，但是高层组件会决定什么时候和怎样使用这些底层组件。
    高层组件对待低层组件：别调用我们，我们会调用你