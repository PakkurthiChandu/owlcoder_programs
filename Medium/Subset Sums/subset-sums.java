//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    public static void subset(ArrayList<Integer> arr,int N,ArrayList<Integer> a,int ind,int sum)
    {
        if(ind==N)
        {
            a.add(sum);
            return;
        }
        subset(arr,N,a,ind+1,sum);
        sum+=arr.get(ind);
        subset(arr,N,a,ind+1,sum);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> a=new ArrayList<Integer>();
        subset(arr,N,a,0,0);
        return a;
    }
}