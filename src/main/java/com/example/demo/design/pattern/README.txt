23种设计模式：
Strategy 策略模式, Observer 观察者模式, Decorator, Abstract Factory,
Factory Method, Singleton, Command,
Adapter, Facade, Template Method, Iterator, Composite, State, Proxy

Bridge, Builder, Chain of Responsibility, Flyweight, Interpreter, Mediator, Memento, Prototype, Visitor.

四个OO基本概念：
抽象、封装、继承、多态

九个OO原则：
封装变化
多用组合，少用继承
针对接口编程，不针对实现编程
为交互对象之间的松耦合设计而努力

设计模式的思考：
如果设计一个超类，使用继承的话，那么当扩展行为时，容易让其他子类发生不希望的改变，如果只有接口呢，
那么会有大量的重复代码，因为子类可能存在同一种行为；那么此时应该，混合使用，子类肯定有的行为，使用
继承，部分子类有的设计成接口，比如Closeable等等；子类继承超类，再实现自己的接口。
靠：这样也会造成代码无法复用，因为可能大部分子类都有closeable方法，而且closeable的方式也可能多种多样
所以也不合适。

那么我们应该把变化的行为分离出来，然后有固定的类去实现这些行为，那么就可以继续使用继承的方式了，但是
有两种不同变化的行为，我怎么让对象同时具有这两种行为呢？