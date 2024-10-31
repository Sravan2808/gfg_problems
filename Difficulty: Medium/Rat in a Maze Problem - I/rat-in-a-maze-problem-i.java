//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public void solveMaze(ArrayList<String> ans ,int r,int c,int m[][] ,int n,String p,boolean[][] vis){
        if(r==n-1 && c==n-1 && m[r][c]!=0){
            ans.add(p);
            return;
        }
        if(r>=0 && r<n && c>=0 && c<n){
            if(vis[r][c] == true || m[r][c] == 0) return;
        vis[r][c] = true;
        solveMaze(ans,r+1,c,m,n,p+'D',vis);//down
        solveMaze(ans,r,c-1,m,n,p+'L',vis);//left
        solveMaze(ans,r,c+1,m,n,p+'R',vis);//right
        solveMaze(ans,r-1,c,m,n,p+'U',vis);//Up
        vis[r][c] = false;
        
        }
        
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat[0].length;
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solveMaze(ans,0,0,mat,n,"",visited);
        return ans;
    }
}