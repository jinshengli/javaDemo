package designmodel.listener.observer;



/**
 * create by ljs on 2020/8/6 17:25
 * description: 定义主题。 （事件源 + 事件）
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();

}
