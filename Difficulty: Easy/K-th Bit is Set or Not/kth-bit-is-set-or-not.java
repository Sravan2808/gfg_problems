//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Your code here
        // By using left shift
        // if((n&(1<<k))!=0) return true;
        // else return false;
        if(((n>>k)&1) != 0) return true;
        else return false;
    }
}

//{ Driver Code Starts.

class GFG {
    static int n;
    static int k;

    // Driver Code
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // Inputting the testcases

        while (t > 0) // While testcases exist
        {

            n = Integer.parseInt(br.readLine()); // Input N
            k = Integer.parseInt(br.readLine()); // Input K

            CheckBit obj = new CheckBit();

            if (obj.checkKthBit(n, k))
                System.out.println("true"); // If true, print Yes

            else
                System.out.println("false"); // Else print No

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends