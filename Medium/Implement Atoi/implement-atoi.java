//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
    	int s=0,c=0;
    	for(int i=0;i<str.length();i++)
    	{
    	   if(str.charAt(i)>='0' && str.charAt(i)<='9')
    	   {
    	       s=s*10+(str.charAt(i)-48);
    	       //System.out.println("yes)";
    	   }
    	   else if(str.charAt(i)=='-' && i==0)c=1;
    	   else
    	   return -1;
    	}
    	if(c==1)s=-s;
    	return s;
    }
}
