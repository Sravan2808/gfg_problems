//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        // Hashing TC:O(N*logm + m) SC:O(M)
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<N;i++){
        //     map.put(Arr[i],map.getOrDefault(Arr[i],0)+1);
        // }
        // List<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> mp : map.entrySet()){
        //     if(mp.getValue()==1){
        //         ans.add(mp.getKey());
        //     }
        // }
        // int finalAns[] = new int[2];
        //  Collections.sort(ans, Collections.reverseOrder());
        // finalAns[0] = ans.get(0);
        // finalAns[1] = ans.get(1);
        
        // return finalAns;
        
        int xor = 0;
        for(int i=0;i<N;i++) xor = xor ^ Arr[i];
        
        int rightmost = (xor^xor-1)&xor;
        int b1 = 0,b2=0;
        
        for(int i=0;i<N;i++){
            if((Arr[i] & rightmost) != 0) b1=b1^Arr[i];
            else b2=b2^Arr[i];
        }
        return (b1<b2)? new int[]{b2,b1} : new int[]{b1,b2};
    }
}