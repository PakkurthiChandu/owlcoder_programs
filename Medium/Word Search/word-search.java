//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    static int t=0;
    public static void search(char[][] b,String w,int i,int j,int ind,int n,int m,int l,int[][] a)
    {
        if(ind==l)t=1;
        if(i<0 || j<0 ||i>=n || j>=m || ind>=l)return;
        if(a[i][j]!=0)return;
        else{
            if(w.charAt(ind)!=b[i][j])return;
            a[i][j]=1;
            search(b,w,i,j+1,ind+1,n,m,l,a);
            search(b,w,i+1,j,ind+1,n,m,l,a);
            search(b,w,i,j-1,ind+1,n,m,l,a);
            search(b,w,i-1,j,ind+1,n,m,l,a);
            a[i][j]=0;
        }
        
    }
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n=board.length,m=board[0].length,l=word.length();
        int[][] a=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                search(board,word,i,j,0,n,m,l,a);
            }
        }
        if(t==1){
            t=0;
            return true;
        }
        return false;
    }
}