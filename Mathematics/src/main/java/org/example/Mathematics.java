package org.example;

public class Mathematics {

    public static void main(String[] args) {
        int n = 10;
        int a = 124;
        int b = 186;

        //fibonacci(n);
        //factorial(n);
        //armstrong(n);
        //reverseNumber(n);
        //greatestCommonDivisor(a, b);
        //pascalTriangle(n);
        //decimalToBinary(n);
        //binaryToDecimal(n);
        //perfectNumber(n);
    }

    public static void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }

    public static void factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println(fact);
    }

    public static void armstrong(int n) {
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            int rem = temp % 10;
            sum = sum + (rem * rem * rem);
            temp = temp / 10;
        }
        if (sum == n) {
            System.out.println("Armstrong");
        } else {
            System.out.println("Not Armstrong");
        }
    }

    public static void reverseNumber(int n) {
        int temp = n;
        int rev = 0;
        while (temp > 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        System.out.println(rev);
    }

    public static void greatestCommonDivisor(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
    }

    public static void pascalTriangle(int n) {
        for (int i = 0; i < n; i++)
        {
            int number = 1;
            for (int j = 0; j < n - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++)
            {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void decimalToBinary(int n) {
        int[] binary = new int[1000];
        int i = 0;
        while (n > 0) {
            binary[i] = n % 2;
            n = n / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j]);
        }
    }

    public static void binaryToDecimal(int n) {
        int decimal = 0;
        int power = 0;
        while (n > 0) {
            int rem = n % 10;
            decimal = decimal + (rem * (int) Math.pow(2, power));
            n = n / 10;
            power++;
        }
        System.out.println(decimal);
    }

    public static void perfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == n) {
            System.out.println("Perfect Number");
        } else {
            System.out.println("Not Perfect Number");
        }
    }

}