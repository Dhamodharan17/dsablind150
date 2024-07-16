class Solution {
    public int binarysearch(int[] arr, int k) {
     
     //divide into 2 subarrays
     int left =0;
     int right = arr.length-1;
     
     //recursively divide and find
     return binarySearchUtil(arr,left,right,k);
     
     
    }
    
    public int binarySearchUtil(int[] arr,
    int left,int right,int k){
        
        if(left>right) return -1;
        
        int mid = left + (right-left)/2;
        if(arr[mid]==k) return mid;
        // target is greater then mid
        if(k>arr[mid]) return binarySearchUtil(arr,mid+1,right,k);
        
        else return binarySearchUtil(arr,left,mid-1,k);
 
    }
}
