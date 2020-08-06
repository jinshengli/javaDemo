package designmodel.listener.observer;

/**
 * create by ljs on 2020/8/6 17:28
 * description: 观察者接口;
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);

}
