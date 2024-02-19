//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            hm.merge(s.charAt(i),1,Integer::sum);
        }
        TreeMap<Integer,Integer> tm=new TreeMap<>(Collections.reverseOrder());
        for(char i:hm.keySet())
        {
            tm.merge(hm.get(i),1,Integer::sum);
        }
        while(k>0){
            ArrayList<Integer> a=new ArrayList<Integer>();
            for(int i:tm.keySet())
            {
                if(tm.get(i)==0){
                    a.add(i);
                    continue;
                }
                k-=1;
                tm.put(i,tm.get(i)-1);
                tm.merge(i-1,1,Integer::sum);
                break;
            }
            for(int i=0;i<a.size();i++)
            tm.remove(a.get(i));
        }
        for(int i:tm.keySet())
        {
            sum+=tm.get(i)*i*i;
        }
        return sum;
    }
}