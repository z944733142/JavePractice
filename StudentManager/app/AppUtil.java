package com.app;

import java.util.Scanner;

public class AppUtil {
    //  scanner
    static String nextLine()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int nextInt()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //   printer
    static void pntLine()
    {
        System.out.println("    --------------------------------------------------------------------------------------------------------------");
    }

    static void pntBlank()
    {
        System.out.println("                                                                                                                 ");
    }

    static void pntlineInfo(String Info)
    {
        pntlineInfo(0, Info);
    }
    static void pntlineInfo(int j, String Info)
    {
        for(int i = 0; i < 45 - j; i++){
            System.out.print(" ");
        }
        System.out.println(Info);

    }

    static void pntTitle()
    {
        pntLine();
        pntlineInfo("学籍管理系统");
        pntLine();
        pntBlank();
        pntBlank();
    }

    static void pntEnd()
    {
        pntBlank();
        pntBlank();
        pntLine();
        System.out.println("");
        System.out.println("");

    }

}
