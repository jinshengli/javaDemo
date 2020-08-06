package designmodel.listener;



/**
 * create by ljs on 2020/8/6 8:53
 * description:
 */
public class MonitorTestDrive {

    public static void main(String[] args) {

        EventSource eventSource = new EventSource();
        eventSource.addListener(new MonitorListener() {
            @Override
            public void handleEvent(MyEvent event) {
                event.doEvent();
                if(event.getSource().equals("openWindows")) {
                    System.out.println("doOpen");
                }
                if(event.getSource().equals("closeWindows")){
                    System.out.println("doClose");
                }
            }
        });
        eventSource.notifyListenerEvents(new MyEvent("openWindows"));
    }

}
