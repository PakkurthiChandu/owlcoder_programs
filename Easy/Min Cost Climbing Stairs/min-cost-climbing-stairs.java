//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    public static int mincost(int[] a,int N,int i,int[] dp)
    {
        if(i>=N)return 0;
        if(dp[i]!=-1)return dp[i];
        int t1=a[i]+mincost(a,N,i+1,dp);
        int t2=a[i]+mincost(a,N,i+2,dp);
        return dp[i]=Math.min(t1,t2);
    }
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        int min=0;
        int[] dp=new int[N];
        Arrays.fill(dp,-1);
        int t1=mincost(cost,N,0,dp);
        int t2=mincost(cost,N,1,dp);
        return Math.min(t1,t2);
    }
};