import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static char[][] copyGrid(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    private static void runTest(String testName, char[][] grid, int expected) {
        NumberOfIslands sol = new NumberOfIslands();
        char[][] gridCopy = copyGrid(grid);

        System.out.println("=== " + testName + " ===");
        System.out.println("Input grid:");
        printGrid(gridCopy);

        int result = sol.numIslands(gridCopy);
        String status = (result == expected) ? "✅ PASS" : "❌ FAIL";

        System.out.println("Expected: " + expected + ", Got: " + result + " " + status);
        System.out.println();
    }

    // ===== Main method =====
    public static void main(String[] args) {

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        runTest("Test 1: One big island", grid1, 1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        runTest("Test 2: Three islands", grid2, 3);

        char[][] grid3 = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        runTest("Test 3: All water", grid3, 0);

        char[][] grid4 = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        runTest("Test 4: All land", grid4, 1);

        char[][] grid5 = {{'1'}};
        runTest("Test 5: Single cell land", grid5, 1);

        char[][] grid6 = {{'0'}};
        runTest("Test 6: Single cell water", grid6, 0);

        char[][] grid7 = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        runTest("Test 7: Diagonal (not connected)", grid7, 5);

        char[][] grid8 = {{'1', '0', '1', '1', '0', '1'}};
        runTest("Test 8: Single row", grid8, 3);

        char[][] grid9 = {
                {'1'},
                {'0'},
                {'1'},
                {'1'},
                {'0'}
        };
        runTest("Test 9: Single column", grid9, 2);

        char[][] grid10 = {
                {'1', '0', '0'},
                {'1', '0', '0'},
                {'1', '1', '1'}
        };
        runTest("Test 10: L-shaped island", grid10, 1);
    }


    // bfs method

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid,r,c,rows,cols,directions);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid,int r, int c , int rows,int cols,int[][] directions){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r,c});
        grid[r][c] = '0';

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0],col = cell[1];
            for (int[] dir:directions ) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (
                        newRow >= 0 &&
                        newCol >=0 &&
                        newRow < rows &&
                        newCol < cols &&
                        grid[newRow][newCol] == '1'
                ) {
                    grid[newRow][newCol] = '0';
                    queue.offer(new int[] { newRow,newCol});
                }
            }
        }
    }

    // dfs method
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) return 0;
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int count = 0;
//
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                if (grid[r][c] == '1') {
//                    count++;
//                    dfs(grid,r,c,rows,cols);
//                }
//            }
//        }
//        return count;
//    }

//    private void dfs(char[][] grid,int r, int c , int rows,int cols) {
//        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
//            return;
//        }
//        grid[r][c] = '0';
//
//        dfs(grid,r-1,c,rows,cols);
//        dfs(grid,r+1,c,rows,cols);
//        dfs(grid,r,c-1,rows,cols);
//        dfs(grid,r,c+1,rows,cols);
//    }
}
