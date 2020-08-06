
##### 监听者模式

数据源

事件

监听者





#### 观察者模式

观察者模式定义了对象之间的一对多依赖，这样依赖，
当一个对象改变状态时，它的所有依赖着都会收到通知
并自动更新。


主题和观察者定义了一对多的关系。观察者依赖于此主题，
只要主题状态一有改变，观察者就会被通知。根据通知的风格，
观察者可能因此新值而更新。


1）定义一个主题接口

interface -- Subject

registerObserver()
removeObServer()
notifyObServer()


对象使用此接口注册成为观察者，或者把
自己从观察者中删除。


每个主题可以有许多观察者。



2) 定义观察者接口

Interface---> ObServer
update()

所有潜在的观察者必须实现观察老接口，这个接口只有update()一个方法，
这个接口只有update()一个方法，当主题状态改变时它被调用。



3）定义一个具体实现主题

ConcreteSubject

registerObServer() {..}
removeObServer() {...}
notifyObServer() {...}


getState()
setState()


4) 观察者具体类



-----

松耦合的威力：

当两个对象之间松耦合，它们依然可以交互，但不清楚彼此的细节。

观察者模式提供了一种对象设计，让主题和观察者之间松耦合。

















