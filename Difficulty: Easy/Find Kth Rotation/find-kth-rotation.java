//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n=arr.size();
        int ans=Integer.MAX_VALUE;
        int low =0;
        int high=n-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            // leftSorted
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<ans){
                    ans=arr.get(low);
                    index=low;
                }
                low=mid+1;
            }
            // right Sorted
            else{
                if(arr.get(mid)<ans){
                    ans=arr.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
}