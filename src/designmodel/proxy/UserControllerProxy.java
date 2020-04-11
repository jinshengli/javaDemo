package designmodel.proxy;


/**
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
