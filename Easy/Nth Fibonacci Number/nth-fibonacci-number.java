//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        int a=1,b=1,c=2,d=0;
        if(n==1 || n==2)return a;
        while(c<n)
        {
            d=a%(1000000007)+b%(1000000007);
            a=b%(1000000007);
            b=d%(1000000007);
            c++;
        }
        return d%(1000000007);
    }
}