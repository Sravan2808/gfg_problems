class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here

        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && st.peek()>=arr[i])
            st.pop();
            if(!st.isEmpty()) list.add(st.peek());
            else list.add(-1);
            st.push(arr[i]);
        }
        return list;
    }
}