//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        a.add(0);
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,0);
        for(int i=1;i<n;i++)
        {
            if(a.get(i-1)-i>0 && (!hm.containsKey(a.get(i-1)-i)))
            {
                a.add(a.get(i-1)-i);
                hm.put(a.get(i),0);
            }
            else
            {
                a.add(a.get(i-1)+i);
                hm.put(a.get(i),0);
            }
        }
        return a;
    }
}