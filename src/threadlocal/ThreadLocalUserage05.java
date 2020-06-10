package threadlocal;


import link.User;



/**
 * create by ljs on 2020/6/9 23:46
 * <p>
 * description: 使用ThreadLocal 避免单线程参数在多个service传递。
 *
 *
 *
 */
public class ThreadLocalUserage05 {


    public static void main(String[] args) {

        new Service().process();

    }


}


class Service{

    public void process(){

        User user = new User();
        user.setName("ljs");
        user.setAge(123);
        UserContextHolder.holder.set(user);
        System.out.println("service: user" + user);
        new Service1().process();
    }

}


class Service1{


    public void process(){


        User user = UserContextHolder.holder.get();
        System.out.println("service1: user" + user);

        UserContextHolder.holder.remove();

        user = new User();
        user.setAge(12);
        user.setName("婉商");

        UserContextHolder.holder.set(user);
        new Service2().process();

    }


}

class Service2{

    public void process(){


        User user = UserContextHolder.holder.get();
        System.out.println("service2: user" + user);

        // 使用完 ThreadLocal之后，需要remove()，避免内存泄漏
        UserContextHolder.holder.remove();

    }
}

/**
 *   holder类代表我拥有什么对象，需要可以到我这里拿。
 */
class UserContextHolder{

    public static ThreadLocal<User> holder = new ThreadLocal<>();


}