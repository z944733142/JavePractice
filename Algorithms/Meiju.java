package Algorithms;

public class Meiju {
    public static void main(String[] args) {
        int a[] = new int[10];
        int flag[] = new int[10];
        int sum = 0;
        int total = 0;
        for(a[0] = 1; a[0] < 10; a[0]++)
            for(a[1] = 1; a[1] < 10; a[1]++)
                for(a[2] = 1; a[2] < 10; a[2]++)
                    for(a[3] = 1; a[3] < 10; a[3]++)
                        for(a[4] = 1; a[4] < 10; a[4]++)
                            for(a[5] = 1; a[5] < 10; a[5]++)
                                for(a[6] = 1; a[6] < 10; a[6]++)
                                    for(a[7] = 1; a[7] < 10; a[7]++)
                                        for(a[8] = 1; a[8] < 10; a[8]++)
                                        {

                                            sum = 0;
                                            for(int i = 0; i < 9; i++)
                                            {
                                                flag[i] = 0;
                                            }
                                            for (int i = 0; i < 9; i++)
                                            {
                                                flag[a[i] - 1] = 1;
                                            }
                                            for(int i = 0; i < 9; i++)
                                            {
                                            sum += flag[i];
                                            }

                                            if(sum == 9 && a[0] * 100 + a[1] * 10 + a[2]
                                                    + a[3] * 100 + a[4] * 10 + a[5]
                                                        == a[6] * 100 + a[7] * 10 + a[8])
                                            {
                                                total++;
                                                System.out.println(
                                                        "" + a[0] + a[1] + a[2] + "+" + a[3] + a[4] + a[5]  + "="+ a[6] + a[7] + a[8]);
                                            }
                                        }

        System.out.println(total);
    }

}
