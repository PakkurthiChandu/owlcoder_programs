//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
         int max=arr[0],min=arr[n-1];
    int[] left=new int[n];
    int[] right=new int[n];
    for(int i=1;i<n;i++)
    {
        left[i]=max;
        if(arr[i]>max)max=arr[i];
    }
    for(int i=n-2;i>=0;i--)
    {
        right[i]=min;
        if(arr[i]<min)min=arr[i];
    }
    for(int i=1;i<n-1;i++)
    {
        if(left[i]<=arr[i] && arr[i]<=right[i])
        {
            return arr[i];
        }
    }
    return -1;
    }
}