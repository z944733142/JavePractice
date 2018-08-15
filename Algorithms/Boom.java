package Algorithms;

import java.util.Scanner;

public class Boom {
    static char[][] chars = null;
    static int max = 0;
    static int maxx;
    static int maxy;

    public static void main(String[] args) {
        run();
        System.out.println(maxx +" " +maxy + " "+ max);
    }

    public static void run() {
        chars = new char[1024][1024];
        Scanner a = new Scanner(System.in);

        int temp1;
        int x = a.nextInt();
        a.nextLine();
        for (int i = 0; i < x; i++) {
            String temp = a.nextLine();
            temp.getChars(0, temp.length(), chars[i], 0);
        }
        for(int i = 0; i < x; i++)
        for(int j = 0; j < chars[x].length; j++)
        {
            if(chars[i][j] == '.' && (temp1 = func(i, j)) > max)
            {
                max = temp1;
                maxx = i;
                maxy = j;
            }

        }

        for(int i = 0; i < x; i++)
        System.out.println(chars[i]);

    }


    public static int func(int x, int y) {

        int sum = 0;
        for (int i = 0; chars[x - i][y] != '#'; i++) {
            if (chars[x - i][y] == 'G')
                sum++;
        }
        for (int i = 0; chars[x + i][y] != '#'; i++) {
            if (chars[x + i][y] == 'G')
                sum++;
        }
        for (int i = 0; chars[x][y - i] != '#'; i++) {
            if (chars[x][y - i] == 'G')
                sum++;
        }
        for (int i = 0; chars[x][y + i] != '#'; i++) {
            if (chars[x][y + i] == 'G')
                sum++;
        }
        return sum;
    }


}
