//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int ss=0;
    public static int fun(char grid[][],int i,int j,String t,int ind,HashSet<String> a,String s,int r,int c,int n,int[][] v)
    {
        if(i<0 || j<0 || i>=r || j>=c)return 0;
        if(ind==n)
        {
            // System.out.println(a);
            a.add(s);
            return -1;
        }
        if(t.charAt(ind)!=grid[i][j])return 0;
        if(v[i][j]==0)
        {
            v[i][j]=1;
            s+=grid[i][j];
            int t1=fun(grid,i+1,j,t,ind+1,a,s,r,c,n,v);if(t1==-1){v[i][j]=0;return t1;}
            int t2=fun(grid,i,j+1,t,ind+1,a,s,r,c,n,v);if(t2==-1){v[i][j]=0;return t2;}
            int t3=fun(grid,i-1,j,t,ind+1,a,s,r,c,n,v);if(t3==-1){v[i][j]=0;return t3;}
            int t4=fun(grid,i,j-1,t,ind+1,a,s,r,c,n,v);if(t4==-1){v[i][j]=0;return t4;}
            int t5=fun(grid,i+1,j+1,t,ind+1,a,s,r,c,n,v);if(t5==-1){v[i][j]=0;return t5;}
            int t6=fun(grid,i-1,j-1,t,ind+1,a,s,r,c,n,v);if(t6==-1){v[i][j]=0;return t6;}
            int t7=fun(grid,i+1,j-1,t,ind+1,a,s,r,c,n,v);if(t7==-1){v[i][j]=0;return t7;}
            int t8=fun(grid,i-1,j+1,t,ind+1,a,s,r,c,n,v);if(t8==-1){v[i][j]=0;return t8;}
            v[i][j]=0;
        }
        return 0;
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        int r=board.length,c=board[0].length;
        if((r==1) && (c==1))
        {
            String [] s=new String[1];
            s[0]=dictionary[0];
            return s;
        }
        HashSet<String> a=new HashSet<>();
        String s="";
        int[][] v=new int[r][c];
        for(int k=0;k<dictionary.length;k++){
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                s="";
                if(dictionary[k].charAt(0)==board[i][j])
                fun(board,i,j,dictionary[k],0,a,s,r,c,dictionary[k].length(),v);
            }
        }
        }
        int l=a.size(),k=0;
        String[] b=new String[l];
        for(String i:a)
        b[k++]=i;
        return b;
    }
}