//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat[0].length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(mat[v1][v2] == 0){
                st.push(v1);
            }
            else if(mat[v2][v1] == 0){
                st.push(v2);
            }
            if(st.size() == 0) return -1;
        }
        int potential = st.pop();
        for(int j=0;j<n;j++){
            if(mat[potential][j] == 1) return -1;
        }
        for(int i=0;i<n;i++){
            if(i==potential) continue;
            if(mat[i][potential] == 0) return -1;
        }
        return potential;
    }
}