package designmodel.listener;

import java.util.Vector;

/**
 * create by ljs on 2020/8/6 8:43
 * description:
 *
 *  事件源
 *  是事件对象的入口，包括监听器的注册、撤销、通知
 *
 */
public class EventSource {

    // 监听者列表， 如果监听事件源的事件，注册监听器可以加入此列表
    private Vector<MonitorListener> listenerList = new Vector<>();

    // 注册监听器
    public void addListener(MonitorListener eventListener) {
        listenerList.add(eventListener);
    }

    // 删除监听者
    public void removeListener(MonitorListener eventListener) {
        int i = listenerList.indexOf(eventListener);
        if ( i >= 0 ) {
            listenerList.remove(eventListener);
        }
    }

    // 接受外部事件， 通知所有的监听者
    public void notifyListenerEvents(MyEvent event) {

        for (MonitorListener monitorListener: listenerList) {
            monitorListener.handleEvent(event);
        }

    }





}
