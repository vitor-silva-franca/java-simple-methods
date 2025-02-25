import java.util.ArrayList;
import java.util.List;

public class Exceptions {

    public static void main(String[] args) {
        //triggerNullPointerExceptions();
        //triggerArrayIndexOutOfBoundsException();
        //triggerIndexOutOfBoundsException();
        //triggerClassCastException();
        //triggerArithmeticException();
    }

    public static void triggerNullPointerExceptions() {
        String str = null;
        try {
            System.out.println("Trying to get length of null string");
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerArrayIndexOutOfBoundsException() {
        int[] numbers = {1, 2, 3, 4, 5};
        try {
            System.out.println("Trying to access index beyond array length");
            int value = numbers[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerIndexOutOfBoundsException() {
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        try {
            System.out.println("Trying to access index beyond list size");
            String element = list.get(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerClassCastException() {
        try {
            System.out.println("Trying to cast Object to String");
            Object obj = new Integer(123);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerArithmeticException() {
        try {
            System.out.println("Trying to divide by zero");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }


}