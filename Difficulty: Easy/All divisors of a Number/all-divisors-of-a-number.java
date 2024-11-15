//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
        // TC:O(N) SC:O(1)
        // List<Integer> arr = new ArrayList<Integer>();
        // for(int i=1;i<n;i++){
        //     if(n%i == 0){
        //         arr.add(i);
        //     }
        // }
        
        // Tc:O(sqrt(n)*nLogn) Sc:O(1)
        
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=1;i*i<=n;i++){
            if(n%i == 0){
                arr.add(i);
                if(n/i != i){
                    arr.add(n/i);
                }
            }
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
