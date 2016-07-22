public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][]ans = new int[m][n];
        ans[m-1][n-1] = dungeon[m-1][n-1]>0 ? 0:-dungeon[m-1][n-1];
        for (int i = m-2; i>=0;i--){
            ans[i][n-1]= dungeon[i][n-1]>= ans[i+1][n-1]?0:ans[i+1][n-1]-dungeon[i][n-1];
        }
        for (int j = n-1; j>=0;j--){
            ans[m-1][j] = dungeon[m-1][j]>= ans[m-1][j+1]?0:ans[m-1][j+1]-dungeon[m-1][j];
        }
        for (int i = m-2; i >= 0; i--){
            for (int j = n-2;j>=0; j--){
                int down = dungeon[i][j] >= ans[i+1][j]?0:ans[i+1][j]-dungeon[i][j];
                int right = dungeon[i][j] >= ans[i][j+1]?0:ans[i][j+1]-dungeon[i][j];
                ans[i][j] = Math.min(down,right);
            }
        }
        return ans[0][0] + 1;
    }
}