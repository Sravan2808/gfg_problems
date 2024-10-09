//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int mediann(int matrix[][],int R,int C){
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                ls.add(matrix[i][j]);
            }
        }
        Collections.sort(ls);
        return ls.get((R*C)/2);
    }
    int median(int matrix[][], int R, int C) {
        // code here 
        // BruteForce Approach Tc:O(n*m + (n*m)log(n*m))
        int ans = mediann(matrix,R,C);
        return ans;
    }
}