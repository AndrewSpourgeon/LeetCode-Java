//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *next;

    Node(int x)
    {
        data = x;
        next = NULL;
    }
};

void printList(Node *node)
{
    while (node != NULL)
    {
        cout << node->data << " ";
        node = node->next;
    }
    cout << endl;
}

struct Node *inputList()
{
    int n; // length of link list
    scanf("%d ", &n);

    int data;
    cin >> data;
    struct Node *head = new Node(data);
    struct Node *tail = head;
    for (int i = 0; i < n - 1; ++i)
    {
        cin >> data;
        tail->next = new Node(data);
        tail = tail->next;
    }
    return head;
}


// } Driver Code Ends
//User function Template for C++

/*
Definition for singly Link List Node
struct Node
{
    int data;
    struct Node *next;

    Node(int x)
    {
        data = x;
        next = NULL;
    }
};
*/


class Solution
{
public:
   
    Node *reverse(Node *head, int k)
    {
        // code here
        Node* second = nullptr;
        Node* first = head;
        while (head != nullptr)
        {
            k--;
            if (k == 0)
            {
                second = head->next;
                head->next = nullptr;
                break;
            }
            head = head->next;
        }
        Node* prev1 = nullptr;
        Node* cur1 = first;
        while (cur1 != nullptr)
        {
            Node* next = cur1->next;
            cur1->next = prev1;
            prev1 = cur1;
            cur1 = next;
        }
        Node* prev2 = nullptr;
        Node* cur2 = second;
        while (cur2 != nullptr)
        {
            Node* next = cur2->next;
            cur2->next = prev2;
            prev2 = cur2;
            cur2 = next;
        }
        first->next = prev2;
        return prev1;
    }
};

//{ Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        struct Node *head = inputList();
        int k;
        cin >> k;

        Solution obj;
        Node *res = obj.reverse(head, k);

        printList(res);
    }
}
// } Driver Code Ends