public class SimpleTest {

    public static void main(String[] args) {
        String text = "199";
        try {
            text = text.concat(".5");
            double decimal = Double.parseDouble(text);
            text = Double.toString(decimal);
            int status = (int) Math.ceil(Double.valueOf(text).doubleValue());
            System.out.println(status);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }
    }
}