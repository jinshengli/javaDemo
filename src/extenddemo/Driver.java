package extenddemo;

public class Driver extends Base {

    private int count = 1;

    public  int get(){
        return super.getCount();
    }

    public static void main(String[] args) {

        Driver driver = new Driver();



        System.out.println(driver.get());

    }

}
