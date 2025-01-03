//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        // BruteForce Approach TC:O(n^2) SC:O(N)
        // ArrayList<Integer> nge = new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[j]>arr[i]){
        //             nge.add(arr[j]);
        //             break;
        //         }
        //     }
        // }
        // return nge;
         
        //  BruteForce Approach
        
        ArrayList<Integer> nge = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for(int i=n-1 ;i>=0;i--){
            while(!stack.empty() && stack.peek()<=arr[i]) stack.pop();
            
            if(stack.empty()) nge.add(-1);
            else nge.add(stack.peek());
            
            stack.push(arr[i]);
        }
        Collections.reverse(nge);
        return nge;
    }
}