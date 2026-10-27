package com.example.demo.algortimos;

public class NumberofIslands {

    public static int countIslands( char[][] grid ){
        if (grid==null || grid.length ==0) return 0;
int count =0;

for (int r=0; r <grid.length; r++){
    for (int c=0; c <grid[0].length; c++)
    {if (grid [r][c] =='1') {
        count ++;
        dfs(grid,r,c);
    }
}
    }

return count;
}

private static void  dfs (char[][] g, int r, int c) {
    if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] != '1') return;
    g[r][c] = '0';
    dfs(g, r - 1, c);
    dfs(g, r + 1, c);
    dfs(g, r, c - 1);
    dfs(g, r, c + 1);
}
}