package se.exception;

public class TryCathFinally {


    public boolean returnTest()
    {
        try
        {
            return true;
        }
        catch (Exception e)
        {

        }
        finally
        {
            return false;
        }
    }

    public static void main(String[] args) {

        TryCathFinally g = new TryCathFinally();
        boolean b = g.returnTest();

        System.out.println(b);

    }
}
