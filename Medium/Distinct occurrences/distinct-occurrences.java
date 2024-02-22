//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    static long mod=(long)1e9+7;
    public static long sub(String s,String t,int ind,int tind,long[][] a)
    {
        if(tind>=t.length())return 1;
        if(ind>=s.length())return 0;
        if(a[ind][tind]!=-1)return a[ind][tind];
        long t1=0,t2=0;
        if(s.charAt(ind)==t.charAt(tind))
        t1=sub(s,t,ind+1,tind+1,a);
        t2=sub(s,t,ind+1,tind,a);
        return a[ind][tind]=(t1%mod+t2%mod)%mod;
    }
    public static long subs(String s,String t,int ind,int tind,long[][] a)
    {
        if(tind>=t.length())return 1;
        if(a[ind][tind]!=-1)return a[ind][tind];
        long sum=0;
        for(int i=ind;i<s.length();i++)
        {
            if(s.charAt(i)==t.charAt(tind))
            sum=(sum%mod+subs(s,t,i+1,tind+1,a)%mod)%mod;
        }
        return a[ind][tind]=sum%mod;
    }
    int subsequenceCount(String s, String t)
    {
    
	   long[][] a=new long[s.length()+1][t.length()+1];
	   for(int i=0;i<=s.length();i++)Arrays.fill(a[i],-1);
	   return (int) sub(s,t,0,0,a);
	   //return (int)subs(s,t,0,0,a);
    }
}