//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public static int sub(int[] arr,int m,int v,int ind,int[][] dp)
    {
        if(v==0)return 0;
        if(ind>=m || v<0)return Integer.MAX_VALUE-1;
        if(dp[ind][v]!=-1)return dp[ind][v];
        return dp[ind][v]=Math.min(1+sub(arr,m,v-arr[ind],ind,dp),sub(arr,m,v,ind+1,dp));
    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[M+1][V+1];
	    for(int i=0;i<=M;i++)Arrays.fill(dp[i],-1);
	    int t=sub(coins,M,V,0,dp);
	    return t!=Integer.MAX_VALUE-1?t:-1;
	} 
}