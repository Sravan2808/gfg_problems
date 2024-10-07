//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // Bry==
        // code here
        int index = -1;
        int max_cnt = 0;
        for(int i=0;i<arr.length;i++){
            int cnt_row = 0;
            for(int j=0;j<arr[0].length;j++){
                cnt_row+=arr[i][j];
            }
            if(cnt_row > max_cnt){
                max_cnt = cnt_row;
                index = i;
            }
        }
        return index;
    }
}