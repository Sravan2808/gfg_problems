class Solution {
    public int adjacent(int stalls[]){
        int min = Integer.MAX_VALUE;
        for(int i=1;i<stalls.length;i++){
            min = Math.min(min,stalls[i]-stalls[i-1]);
        }
        return min;
    }
    public int posStalls(int stalls[],int mid){
        int cows = 1;
        int position = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-position>=mid){
                cows++;
                position = stalls[i];
            }
        }
        return cows;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int l = adjacent(stalls);
        int r = stalls[n-1] - stalls[0];
        int ans = -1;
        
        while(l<=r){
            int mid = (l+(r-l)/2);
            int cows = posStalls(stalls,mid);
            if(cows>=k){
                ans = mid;
                l=(mid+1);
            }
            else r=mid-1;
            
        }
        return ans;
    }
}