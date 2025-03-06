import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exceptions {

    public static void main(String[] args) {
        //triggerNullPointerExceptions();
        //triggerArrayIndexOutOfBoundsException();
        //triggerIndexOutOfBoundsException();
        //triggerClassCastException();
        //triggerArithmeticException();
        //triggerIllegalArgumentException();
        //triggerIllegalStateException();
        //triggerUnsupportedOperationException();
        //triggerNumberFormatException();
        //triggerStringIndexOutOfBoundsException();
        //triggerNoSuchMethodException();
        //triggerInstantiationException();
        //triggerNoSuchFieldException();
        //triggerInterruptedException();
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

    public static void triggerIllegalArgumentException() {
        try {
            System.out.println("Trying to set negative age");
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        System.out.println("Age set to: " + age);
    }

    public static void triggerIllegalStateException() {
        try {
            System.out.println("Trying to modify list while iterating");
            List<String> list = new ArrayList<>();
            list.add("Item 1");
            list.add("Item 2");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                list.add("New Item");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerUnsupportedOperationException() {
        try {
            System.out.println("Trying to modify an unmodifiable list");
            List<String> list = List.of("Item 1", "Item 2");
            list.add("Item 3");
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void triggerNumberFormatException() {
        try {
            System.out.println("Trying to parse a non-numeric string");
            String str = "abc";
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerStringIndexOutOfBoundsException() {
        try {
            System.out.println("Trying to access index beyond string length");
            String str = "Hello";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerNoSuchMethodException() {
        try {
            System.out.println("Trying to access non-existent method");
            String str = "Hello";
            str.getClass().getMethod("nonExistentMethod");
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerInstantiationException() {
        try {
            System.out.println("Trying to instantiate an abstract class or interface");
            Class<?> clazz = Runnable.class;
            clazz.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void triggerNoSuchFieldException() {
        try {
            System.out.println("Trying to access non-existent field");
            Class<?> clazz = String.class;
            clazz.getField("nonExistentField");
        } catch (NoSuchFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void triggerInterruptedException() {
        try {
            System.out.println("Trying to sleep thread");
            Thread.sleep(1000);
            Thread.currentThread().interrupt();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Error: " + e.getMessage());
        }
    }

}