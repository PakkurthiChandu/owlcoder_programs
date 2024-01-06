//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(hm.containsKey(arr[i])==false)
            {
                hm.put(arr[i],1);
            }
            else
            {   int t=hm.get(arr[i]);
                hm.put(arr[i],t+1);
                if(t==1)
                al.add(arr[i]);
            }
        }
        int[] a=new int[al.size()];
        for(int i=0;i<al.size();i++)a[i]=al.get(i);
        Arrays.sort(a);
        al.clear();
        for(int i=0;i<a.length;i++)al.add(a[i]);
        if(al.size()==0)al.add(-1);
        return al;
        // code here
    }
}
