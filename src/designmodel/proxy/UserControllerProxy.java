package designmodel.proxy;


/**
 *  通过实现被代理类的接口  + 组合被代理对象 （委托代理对象进行工作）
 *
 *  好处：这个接口的所有子类都可以使用这个代理，来实现增强功能。
 *
 *
 */

public class UserControllerProxy implements IUserController{

    private IUserController iUserController;

    public UserControllerProxy(IUserController iUserController){
        this.iUserController = iUserController;
    }

    @Override
    public void register() {
        System.out.println("注册前工作....");
        iUserController.register();
        System.out.println("注册后工作....");
    }

    @Override
    public void login() {
        System.out.println("登录前。。。。");
        iUserController.login();
        System.out.println("登录后。。。。");

    }

    public static void main(String[] args) {

        UserController userController = new UserController();
        UserControllerProxy userControllerProxy = new UserControllerProxy(userController);

        userController.register();
        userController.login();

        userControllerProxy.register();
        userControllerProxy.login();
    }
}
