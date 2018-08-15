package Algorithms;


import java.util.Scanner;

public class Walk {
    static int min = 999;
    static int a[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    public static void main(String[] args)
    {

        int sx, sy, dx, dy;
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        while (b-- != 0)
        {
            min = 99999;
            sx = scanner.nextInt();
            sy = scanner.nextInt();
            dx = scanner.nextInt();
            dy = scanner.nextInt();
            func(sx, sy, dx, dy, 0);
            System.out.println(min);
        }
    }

    public static int func(int sx, int sy, int dx, int dy, int sum) {

        a[sx][sy] = 1;
        min = (a[sx + 1][sy] == 0 && (sx != dx || sy != dy)) ? func(sx + 1, sy, dx, dy, sum + 1) : min > sum && sx == dx && sy == dy ? sum : min;
        min = (a[sx - 1][sy] == 0 && (sx != dx || sy != dy)) ? func(sx - 1, sy, dx, dy, sum + 1) : min > sum && sx == dx && sy == dy ? sum : min;
        min = (a[sx][sy - 1] == 0 && (sx != dx || sy != dy)) ? func(sx, sy - 1, dx, dy, sum + 1) : min > sum && sx == dx && sy == dy ? sum : min;
        min = (a[sx][sy + 1] == 0 && (sx != dx || sy != dy)) ? func(sx, sy + 1, dx, dy, sum + 1) : min > sum && sx == dx && sy == dy ? sum : min;
        a[sx][sy] = 0;

        return min;
    }

}
