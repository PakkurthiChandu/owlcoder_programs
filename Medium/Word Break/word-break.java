//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean fun(ArrayList<String> a,String s,int ind)
    {
        if(ind>=s.length())
        {
            // System.out.println("yes");
            return true;
        }
        for(int i=ind;i<s.length();i++)
        {
            String s1=s.substring(ind,i+1);
            if(a.contains(s1))
            {
                if(fun(a,s,i+1))
                return true;
            }
        }
        return false;
    }
    public static int wordBreak(int n, String s, ArrayList<String> a )
    {
        //code here
        if(fun(a,s,0))return 1;
        return 0;
    }
}