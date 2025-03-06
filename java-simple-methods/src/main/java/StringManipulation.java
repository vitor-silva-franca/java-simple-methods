public class StringManipulation {

    public static void main(String[] args) {
        //ReverseString();
        //Palindrome();
        //VowelAndConsonants();
        //CheckAnagram();
        //CountWords();
        //StringLenght();
        //StringLenght2();
        //EmptyString();
        //CountCharacter();
        //CountCharacter2();
        //RemoveWhiteSpace();
        //RemoveWhiteSpace2();
        //StringContains();
        //StringContains2();
        //StringContains3();
        //StringReplace();
        //StringReplaceAll();
        //StringReplaceFirst();
    }

    public static void ReverseString() {
        String str = "Hello World";
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        System.out.println(reverse);

        //Using StringBuilder
        StringBuilder reversed = new StringBuilder(str).reverse();
        System.out.println(reversed);
    }

    public static void Palindrome() {
        String str = "madam";
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        if (str.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    public static void VowelAndConsonants() {
        String str = "Hello World";
        int vowels = 0, consonants = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void CheckAnagram() {
        String str1 = "listen";
        String str2 = "silent";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        if (java.util.Arrays.equals(arr1, arr2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }

    public static void CountWords() {
        String str = "Hello World World Hello";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("Number of words: " + (count + 1));
    }

    public static void StringLenght() {
        String str = "Hello World";
        int length = 0;
        for (char c : str.toCharArray()) {
            length++;
        }
        System.out.println("Length: " + length);
    }
    public static void StringLenght2() {
        String str = "Hello World";
        int length = str.length();
        System.out.println("Length: " + length);
    }

    public static void EmptyString() {
        String str = "";
        if (str.isEmpty()) {
            System.out.println("Empty String");
        } else {
            System.out.println("Not Empty String");
        }
    }

    public static void CountCharacter() {
        String str = "Hello World";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'l') {
                count++;
            }
        }
        System.out.println("Number of l: " + count);
    }
    public static void CountCharacter2() {
        String str = "Hello World";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'l') {
                count++;
            }
        }
        System.out.println("Number of l: " + count);
    }

    public static void RemoveWhiteSpace() {
        String str = "Hello World";
        String str2 = str.replaceAll("\\s", "");
        System.out.println(str2);
    }
    public static void RemoveWhiteSpace2() {
        String str = "Hello World";
        String str2 = str.replace(" ", "");
        System.out.println(str2);
    }

    public static void StringContains() {
        String str = "Hello World";
        if (str.contains("World")) {
            System.out.println("Contains World");
        } else {
            System.out.println("Does not contain World");
        }
    }
    public static void StringContains2() {
        String str = "Hello World";
        if (str.indexOf("World") != -1) {
            System.out.println("Contains World");
        } else {
            System.out.println("Does not contain World");
        }
    }
    public static void StringContains3() {
        String str = "Hello World";
        if (str.matches(".*World.*")) {
            System.out.println("Contains World");
        } else {
            System.out.println("Does not contain World");
        }
    }

    public static void StringReplace() {
        String str = "Hello World";
        String str2 = str.replace("World", "Java");
        System.out.println(str2);
    }
    public static void StringReplaceAll() {
        String str = "Hello World World";
        String str2 = str.replaceAll("World", "Java");
        System.out.println(str2);
    }
    public static void StringReplaceFirst() {
        String str = "Hello World World";
        String str2 = str.replaceFirst("World", "Java");
        System.out.println(str2);
    }

}
