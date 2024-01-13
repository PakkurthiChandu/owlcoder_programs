//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    static int key=0,sc=1,l=0;
    public static void insertion(Node head)
    {
        // System.out.println(""+(sc++));
        if(head.next==null)
        {   
            return;
        }
            //System.out.println(head.data);
        if(head.data<=head.next.data)insertion(head.next);
        if(l==1)return;
        if(head.data>head.next.data){
            int t=head.data;
            head.data=head.next.data;
            head.next.data=t;
            sc=1;
        }
        if(head.next==null)
        l=1;
    }
    public static Node insertionSort(Node head_ref)
    {
        //code here
        // Node temp=head_ref;
        while(true)
        {
            sc=0;
            l=0;
            insertion(head_ref);
            if(sc==0)break;
            // temp=temp.next;
        }
        return head_ref;
        
    }
}