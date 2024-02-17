//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean jump(int[] a,int n,int ind)
    {
        if(ind==n-1)
            return true;
        if(ind>=n)return false;
        for(int i=ind+1;i<=ind+a[ind];i++)
        {
            if(jump(a,n,i))return true;
        }
        return false;
    }
    static int canReach(int[] A, int N) {
        // code here
        return jump(A,N,0)==true?1:0;
    }
};