package designmodel.listener;



import java.util.EventListener;

/**
 * create by ljs on 2020/8/6 8:38
 * description:  事件监听者接口
 */
public interface MonitorListener extends EventListener {

    public void handleEvent(MyEvent event);


}
