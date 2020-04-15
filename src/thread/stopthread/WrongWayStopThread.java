package thread.stopthread;

/**
 *  经典错误中断线程的方式：
 *     1） stop; 这是会释放所有的锁。 立刻中断线程，会导致一些线程只完成一部分，不能保证数据的完整性。
 *     2） suspend, resume 。 将线程挂起，但是没有释放锁，容易造成死锁。
 *     3） volatile 设置boolean 中断标识。
 *          有些情况可以；一些情况不可以。
 *          while（！flag） 内有一个长时间阻塞的，没有到判断条件中，是不能中断的。
 */

public class WrongWayStopThread {
}
