//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to flatten a linked list
   
    Node flatten(Node root) {
        
        // code here
        // 1.)Tranverse all the linkedlist and child as well
        // 2.)Sort the Linkedlist
        // 3.)Place in the vertical direction
        // // TimeComplexity TC:O(2*N*m + xlogx) where X=(N*M) Sc:O(N*m);
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     Node temp = root;
    //     while(temp!=null){
    //         Node t2 = temp;
    //         while(t2!=null){
    //             arr.add(t2.data);
    //             t2=t2.bottom;
    //         }
    //         temp = temp.next;
    //     }
    //     Collections.sort(arr);
    //     root = Convert(arr);
    //     return root;
    // }
    //  Node Convert(ArrayList<Integer> arr){
    //     if(arr.size() == 0) return null;
    //     Node head = new Node(arr.get(0));
    //     Node temp = head;
    //     for(int i = 1;i<arr.size();i++){
    //         Node newNode = new Node(arr.get(i));
    //         temp.bottom = newNode;
    //         temp = temp.bottom;
    //     }
    //     return head;
    // Optimal Approach TC:(N*2M) Sc:O(N)
    
    if(root == null || root.next == null) return root;
    Node mergeHead = flatten(root.next);
    return mergeList(root,mergeHead);
    }
    
    Node mergeList(Node l1,Node l2){
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                res.bottom = l1;
                res = l1;
                l1=l1.bottom;
            }
            else{
                res.bottom = l2;
                res = l2;
                l2 = l2.bottom;
            }
            res.next = null;
        }
        if(l1!=null) res.bottom=l1;
        else res.bottom = l2;
        return dummyNode.bottom;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends