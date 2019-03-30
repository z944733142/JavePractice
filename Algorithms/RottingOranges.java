package Algorithms;

/*
在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(new int[][]{
                {1,2},
//                {0,1,1},
//                {1,0,1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        int key = 1;
        int i;
        for (i = 2; key == 1; i++) {
            key = 0;
            for (int j = 0; j < grid.length; j++) {
                for(int k = 0; k < grid[0].length; k++)
                {
                    if(grid[j][k] == i)
                    {
                        if(j + 1 < grid.length && grid[j + 1][k] == 1)
                        {
                            grid[j + 1][k] = i + 1;
                            key = 1;
                        }

                        if(k + 1 < grid[0].length && grid[j][k + 1] == 1)
                        {
                            grid[j][k + 1] = i + 1;
                            key = 1;
                        }

                        if(k - 1 >= 0 && grid[j][k - 1] == 1)
                        {
                            grid[j][k -1] = i + 1;
                            key = 1;
                        }

                        if(j - 1 >= 0 && grid[j - 1][k] == 1)
                        {
                            grid[j - 1][k] = i + 1;
                            key = 1;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {

                if(grid[j][k] == 1)
                {
                    return  -1;
                }
            }
        }

        return i - 3;

    }
}
//java.lang.ArrayIndexOutOfBoundsException: 1
//        at line 11, Solution.orangesRotting
//        at line 54, __DriverSolution__.__helper__
//        at line 79, __Driver__.main