package designmodel.proxy;


public class UserController implements IUserController {
    @Override
    public void register() {
        System.out.println("register......");
    }

    @Override
    public void login() {
        System.out.println("login.....");

    }
}
