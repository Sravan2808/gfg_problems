class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                min = max;
                max = arr[i];
            }
            else if(arr[i]>min && max!=arr[i]) min=arr[i];
        }
        return min;
    }
}