//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long paths(int[][] arr,int n,int k,ArrayList<Integer> al,int i,int j
    ,long[][][] dp){
        //base
        if(i==n-1 && j==n-1 && k-arr[i][j]==0)
        {
            return 1;
        }
        if(i>=n || j>=n || k<0)return 0;
        if(dp[i][j][k]!=-1)return dp[i][j][k];
        return  dp[i][j][k]=paths(arr,n,k-arr[i][j],al,i,j+1,dp)+paths(arr,n,k-arr[i][j],al,i+1,j,dp);
    }
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        long[][][] dp=new long[n+1][n+1][k+1];
        for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)Arrays.fill(dp[i][j],-1);
        return paths(arr,n,k,al,0,0,dp);
    }
}