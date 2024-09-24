//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int repeated=-1,missing=-1;
        int n=arr.length;
        int hash[] = new int[n+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]=hash[arr[i]]+1;
        }
        for(int i=1;i<=n;i++){
            if(hash[i]==2) repeated=i;
            else if(hash[i]==0) missing=i;
        }
        int ans[]={repeated,missing};
        return ans;
    }
}