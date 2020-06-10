package concurrent.chapter02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountDemo {


    private int balance;

    private final Lock lock = new ReentrantLock();


    void transfer(AccountDemo tar, int amt){

        while (true){

            if (this.lock.tryLock()){
                try{
                    if ( tar.lock.tryLock() ){
                        try {
                            this.balance -=amt;
                            tar.balance += amt;
                        } finally {
                            tar.lock.unlock();
                        }
                    }
                }finally {
                    this.lock.unlock();
                }


            }



        }


    }


}
