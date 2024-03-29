//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    public static int sub(int[] wt,int[] val,int n,int w,int ind,int[][] b)
	{
		if(ind==n)return 0;
		if(w<0)return 0;
		if(b[ind][w]!=-1)return b[ind][w];
		int t1=sub(wt,val,n,w,ind+1,b);
		int t2=Integer.MIN_VALUE;
		if(wt[ind]<=w)
		t2=val[ind]+sub(wt,val,n,w-wt[ind],ind+1,b);
		return b[ind][w]=Math.max(t1, t2);
	}
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
		int[][] b=new int[n+1][W+1];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(b[i], -1);
		}
        return sub(wt,val,n,W,0,b);
    } 
}


