//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public static void dfs(int[] vis,ArrayList<ArrayList<Integer>> adj,int node,Stack<Integer> st,int temp)
    {
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==0)
            {
                dfs(vis,adj,adj.get(node).get(i),st,temp);
            }
        }
        if(temp==0)
        st.push(node);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++)
        if(vis[i]==0)
        dfs(vis,adj,i,st,0);
        Arrays.fill(vis,0);
        ArrayList<ArrayList<Integer>> rev_adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)rev_adj.add(new ArrayList<Integer>());
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                rev_adj.get(adj.get(i).get(j)).add(i);
            }
        }
        // System.out.println(rev_adj);
        int c=0;
        // System.out.println(st);
        Arrays.fill(vis,0);
        while(!st.isEmpty())
        {
            int t=st.pop();
            if(vis[t]==0)
            {
                dfs(vis,rev_adj,t,st,1);
                c++;
            }
            // for(int i=0;i<V;i++)
            // {
            //     System.out.printf("%d ",vis[i]);
            // }
            // System.out.println();
        }
        return c;
    }
}
