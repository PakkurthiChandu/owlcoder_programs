//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long mod=(long)1e9+7;
    public static long seq(int n,int idx,int r)
    {
        if(n==0)return 0;
        long p=1;
        int i=idx;
        for(i=idx;i<idx+r;i++)p=((p%mod)*(i%mod))%mod;
        return (p%mod+seq(n-1,i,r+1)%mod)%mod;
    }
    static long sequence(int n){
        // code here
        return seq(n,1,1);
    }
}