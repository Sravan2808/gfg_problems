class Solution {
    static int merge(int arr[],int l,int mid,int r){
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for(int i=l;i<=mid;i++){
            arr1.add(arr[i]);
        }
        for(int i=mid+1;i<=r;i++){
            arr2.add(arr[i]);
        }
        
        int i=0;
        int j=0;
        int k=l;
        int inversion = 0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                arr[k] = arr1.get(i);
                i++;
                k++;
            }
            else{
                arr[k] = arr2.get(j);
                j++;
                k++;
                inversion += arr1.size() - i;
            }
        }
          while (i < arr1.size()) {
            arr[k++] = arr1.get(i++);
        }

        while (j < arr2.size()) {
            arr[k++] = arr2.get(j++);
        }
        return inversion;
    }
    static int mergeSort(int arr[],int l,int r){
        if(l>=r) return 0;
        int mid = (l+r)/2;
        int result = 0;
         result += mergeSort(arr,l,mid);
         result += mergeSort(arr,mid+1,r);
         result += merge(arr,l,mid,r);
        return result;
    }
    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr,0,arr.length-1);
    }
}