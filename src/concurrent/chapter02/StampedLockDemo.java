package concurrent.chapter02;


import java.util.concurrent.locks.StampedLock;

/**
 *  StampedLock 支持的三种锁模式
 *
 *  写锁、悲观锁、和乐观锁
 *
 *  StampedLock 里的写锁和悲观读锁加锁成功之后，都会返回一个
 * stamp；然后解锁的时候，需要传入这个 stamp
 *
 *
 *
 */

public class StampedLockDemo {



    public static void main(String[] args) {

        final StampedLock s1 = new StampedLock();

        long stamp = s1.readLock();

        try {
            //
        }finally {
            s1.unlockRead(stamp);
        }


        stamp = s1.writeLock();

        try{

        }finally {
            s1.unlockWrite(stamp);
        }

    }

}


class Ponit{

    private int x, y;
    final StampedLock s1 = new StampedLock();


    // 乐观锁升级到悲观读锁。
    int distanceFromOrigin(){
        long stamp = s1.tryOptimisticRead();
        // 读入局部变量

        int curX = x, curY = y;

        if (!s1.validate(stamp)){

            stamp = s1.readLock();

            try {
                curX = x;
                curY = y;
            }finally {
                s1.unlockRead(stamp);
            }
        }
        return curX * curY;

    }


}



















