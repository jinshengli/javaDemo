package thread.threadexception;

import java.util.logging.Logger;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    Logger logger = Logger.getAnonymousLogger();

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        logger.info("异常：" + t.getName() + "被我捕获了");

        System.out.println(e.getMessage() + ":" + t.getName());

    }
}
