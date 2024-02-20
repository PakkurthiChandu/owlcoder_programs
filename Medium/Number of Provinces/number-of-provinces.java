//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int[] vis,int node)
    {
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==0)
            {
                dfs(adj,vis,adj.get(node).get(i));
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int[] vis=new int[V];
        int c=0;
        ArrayList<ArrayList<Integer>> adj1=new ArrayList<>();
        for(int i=0;i<adj.size();i++)
        {
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<adj.get(i).size();j++)
            {
                if(i!=j && adj.get(i).get(j)==1)
                {
                    a.add(j);
                }
            }
            adj1.add(new ArrayList<>(a));
            a.clear();
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(adj1,vis,i);
                c++;
            }
        }
        return c;
    }
};