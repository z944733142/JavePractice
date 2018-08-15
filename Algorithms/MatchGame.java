package Algorithms;

import java.util.Scanner;

public class MatchGame {
    public static int[] a = {
            6, 2, 5, 5, 4, 5, 6, 3, 7, 6
    };
    public static void main(String[] args) {
        start();
    }

    public static void start()
    {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int c;
        for(int i = 0; i < 1111; i++)
        {
            for(int j = 0; j < 1111; j++)
            {
                c = i + j;
                if (func(i) + func(j) + func(c) == value)
                {
                    System.out.println(i + " + " +j + " = " + c);
                }
            }
        }
    }
    public static int func(Integer b)
    {
        int sum = 0;
        for(int i = 0; i < b.toString().length(); i++)
        {
            sum += a[new Integer(b.toString().substring(i, i+1))];
        }
        return sum;
    }
}

