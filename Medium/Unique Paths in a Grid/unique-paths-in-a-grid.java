//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long c=0,mod=1000000007;
    public static long traverse(int[][] grid,int n,int m,int i,int j,long[][] a)
    {
        if(i==n ||j==m)return 0;
        if(grid[i][j]==0)return 0;
        if(i==n-1&&j==m-1)return 1;
        if(a[i][j]!=-1)return a[i][j];
        long c=traverse(grid,n,m,i,j+1,a);
        long b=traverse(grid,n,m,i+1,j,a);
        return a[i][j]=(b%mod+c%mod)%mod;
    }
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        long[][] a=new long[n+1][m+1];
        for(int i=0;i<n;i++)Arrays.fill(a[i],-1);
        long t=traverse(grid,n,m,0,0,a);
        return (int)t;
    }
}