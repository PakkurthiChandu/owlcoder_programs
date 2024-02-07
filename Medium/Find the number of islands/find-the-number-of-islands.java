//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public static void change(char[][] mat,int i,int j,int n,int m)
    {
        // System.out.println("YES");
        if(i<0 || i>=n || j<0 ||j>=m)return;
        if(mat[i][j]=='0')return;
        mat[i][j]='0';
        change(mat,i,j+1,n,m);
        change(mat,i,j-1,n,m);
        change(mat,i+1,j,n,m);
        change(mat,i-1,j,n,m);
        change(mat,i+1,j+1,n,m);
        change(mat,i-1,j-1,n,m);
        change(mat,i-1,j+1,n,m);
        change(mat,i+1,j-1,n,m);
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length,m=grid[0].length,c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    c+=1;
                    change(grid,i,j,n,m);
                }
            }
        }
        return c;
    }
}