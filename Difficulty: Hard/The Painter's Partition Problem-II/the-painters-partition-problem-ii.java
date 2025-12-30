    class Solution {
    public int BestCase(int cost[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cost.length; i++) {
            max = Math.max(max, cost[i]);
        }
        return max;
    }

    public int WorstCase(int[] cost) {
        int sum = 0;
        for (int i = 0; i < cost.length; i++)
            sum += cost[i];
        return sum;
    }

    public int PainterRequire(int[] cost, int mid) {
        int painter = 1;
        int currSum = 0;
        for (int i = 0; i < cost.length; i++) {
            if (currSum + cost[i] <= mid) {
                currSum += cost[i];
            } else {
                painter++;
                currSum = cost[i];
            }
        }
        return painter;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        int l = BestCase(arr);
        int r = WorstCase(arr);
        int ans = -1;

            while(l<=r){
                int mid = l+(r-l)/2;
                int P = PainterRequire(arr,mid);
            
                if(P<=k){
                    ans=mid;
                    r=mid-1;
                }
                else l = mid+1;
            }
            
         return ans;       
    }

}
