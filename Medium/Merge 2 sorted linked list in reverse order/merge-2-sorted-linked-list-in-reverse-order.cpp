//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

/* Link list Node */
struct Node
{
    int data;
    struct Node* next;
};

void print(struct Node *Node)
{
    while (Node!=NULL)
    {
        cout << Node->data << " ";
        Node = Node->next;
    }
}


Node *newNode(int data)
{
    Node *temp = new Node;
    temp->data = data;
    temp->next = NULL;
    return temp;
}


// } Driver Code Ends
/*

The structure of linked list is the following

struct Node
{
    int data;
    Node* next;
};

*/
class Solution
{
    public:
    Node * reverse(Node* head)
    {
        Node *temp=head,*p;
        while(temp->next)
        {
            //cout<<temp->data<<"  " ;
            p=temp->next;
            temp->next=temp->next->next;
           // cout<<temp->next->data<<" ";
            p->next=head;
            head=p;
            //cout<<head->data<<"  ";
        }
        return head;
    }
    struct Node * mergeResult(Node *node1,Node *node2)
    {
        // your code goes here
        if(node1==NULL && node2==NULL)return node1;
        if(node1==NULL)return reverse(node2);
        if(node2==NULL)return reverse(node1);
        Node *temp1=node1,*temp2=node2;
        Node *n=new Node();
        n->data=0;
        Node *head=n;
        Node *t=head;
        while(temp1 && temp2)
        {
            if(temp1->data>temp2->data)
            {
                Node *n=new Node();
                n->data=temp2->data;
                t->next=n;
                t=t->next;
                temp2=temp2->next;
            }
            else
            {
                Node *n=new Node();
                n->data=temp1->data;
                t->next=n;
                t=t->next;
                temp1=temp1->next;
            }
        }
        while(temp1)
        {
            Node *n=new Node();
            n->data=temp1->data;
            t->next=n;
            t=t->next;
            temp1=temp1->next;
        }
        while(temp2)
        {
            Node *n=new Node();
            n->data=temp2->data;
            t->next=n;
            t=t->next;
            temp2=temp2->next;
        }
        Node *p=head;
        head=head->next;
        p->next=NULL;
        
        return reverse(head);
        
    }  
};


//{ Driver Code Starts.

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int nA;
        cin>>nA;
        int nB;
        cin>>nB;

        struct Node* headA=NULL;
        struct Node* tempA = headA;

        for(int i=0;i<nA;i++)
        {
            int ele;
            cin>>ele;
            if(headA==NULL)
            {
                headA=tempA=newNode(ele);

            }else{
                tempA->next = newNode(ele);
				tempA=tempA->next;
            }
        }

        struct Node* headB=NULL;
        struct Node* tempB = headB;


        for(int i=0;i<nB;i++)
        {
            int ele;
            cin>>ele;
            if(headB==NULL)
            {
                headB=tempB=newNode(ele);

            }else{
                tempB->next = newNode(ele);
				tempB=tempB->next;
            }
        }
        
        Solution ob;
        struct Node* result = ob.mergeResult(headA,headB);

        print(result);
        cout<<endl;


    }
}

// } Driver Code Ends