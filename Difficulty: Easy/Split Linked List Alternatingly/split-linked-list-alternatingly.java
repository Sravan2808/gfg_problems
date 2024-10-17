//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution { 
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        if (head == null) {
        return new Node[] {null, null}; // If the list is empty, return two nulls
    }

    Node h1 = head; // Head of the first list
    Node h2 = head.next; // Head of the second list
    Node current1 = h1; // Pointer for the first list
    Node current2 = h2; // Pointer for the second list

    while (current1 != null && current2 != null) {
        current1.next = current2.next; // Link to the next node in the first list
        current1 = current1.next; // Move forward in the first list
        
        if (current1 != null) { // Check if current1 is not null
            current2.next = current1.next; // Link to the next node in the second list
            current2 = current2.next; // Move forward in the second list
        }
    }

    // Terminate the last nodes of both lists
    if (current1 != null) {
        current1.next = null;
    }
    if (current2 != null) {
        current2.next = null;
    }

    return new Node[] {h1, h2};
}
}
