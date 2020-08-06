package designmodel.listener;

import java.util.EventObject;

/**
 * create by ljs on 2020/8/6 8:40
 * description: 事件对象 MyEvent
 */
public class MyEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEvent(Object source) {
        super(source);
    }


    public void doEvent() {
        System.out.println("通知一个事件source" + this.getSource());
    }

}
