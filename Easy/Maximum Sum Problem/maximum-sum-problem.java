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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // static int maxi=0;
    public static int max(int n)
    {
        if(n<=0)return 0;
        int t1=max(n/2);
        int t2=max(n/3);
        int t3=max(n/4);
        return Math.max(n,t1+t2+t3);
    }
    public int maxSum(int n) 
    { 
        //code here.
        return max(n);
    } 
}
