//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    static int max=0;
    public static int LCS(String A,String B,String C,int n1,int n2,int n3,int i,int j,int k,int c,int[][][] a)
    {
        if(i>=n1 || j>=n2 || k>=n3)
        {
            return 0;
        }
        if(a[i][j][k]!=-1)return a[i][j][k];
        //System.out.printf("%c %c %c\n",A.charAt(i),B.charAt(j),C.charAt(k));
        if(A.charAt(i)==B.charAt(j) && B.charAt(j)==C.charAt(k))
        {
            int t=1+LCS(A,B,C,n1,n2,n3,i+1,j+1,k+1,c+1,a);
            //System.out.println(t);
            return a[i][j][k]=t;
        }
        else
        {
            //if(A.charAt(i)!=B.charAt(j) && B.charAt(j)!=C.charAt(k) && A.charAt(i)!=C.charAt(k))
            // LCS(A,B,C,n1,n2,n3,i+1,j,k,c,a);
            int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0;
            t1=LCS(A,B,C,n1,n2,n3,i,j,k+1,c,a);
            t2=LCS(A,B,C,n1,n2,n3,i,j+1,k,c,a);
            t3=LCS(A,B,C,n1,n2,n3,i+1,j,k,c,a);
            t4=LCS(A,B,C,n1,n2,n3,i+1,j+1,k,c,a);
            t5=LCS(A,B,C,n1,n2,n3,i,j+1,k+1,c,a);
            t6=LCS(A,B,C,n1,n2,n3,i+1,j,k+1,c,a);
            // System.out.printf("%d %d %d %d %d %d",x,y,z,d,e,f);
            return a[i][j][k]=Math.max(Math.max(Math.max(t1,t2),Math.max(t3,t4)),Math.max(t5,t6));
        }
    }
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int[][][] a=new int[n1][n2][n3];
        for(int i=0;i<n1;i++)
        {
            for(int j=0;j<n2;j++)
            {
                Arrays.fill(a[i][j],-1);
            }
        }
        int l=LCS(A,B,C,n1,n2,n3,0,0,0,0,a);
        int t=max;max=-1;
        return l;
        
    }
}