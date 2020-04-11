package designmodel.proxy;

/**
 *    通过继承实现静态代理。
 *    被代理类和代理类  1 VS 1 同时增长。
 */

public class UserControllerExtendProxy extends UserController {


    @Override
    public void register() {
        System.out.println("注册前、、、、");
        super.register();
        System.out.println("注册后、、、、");
    }

    @Override
    public void login() {
        System.out.println("登录前、、、");
        super.login();
        System.out.println("登录后、、、");
    }

    public static void main(String[] args) {

        UserControllerExtendProxy userControllerExtendProxy = new UserControllerExtendProxy();
        userControllerExtendProxy.register();
        userControllerExtendProxy.login();
    }
}
