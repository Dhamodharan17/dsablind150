
class Solution {
    public int binarysearch(int[] arr, int k) {
    //iterative
    
    int left=0;
    int right = arr.length-1;
    int mid;
    
    while(left<=right){
    
    mid = left+(right-left)/2;
    
    if(k == arr[mid]) return mid;
    //reduce scope
    else if(k > arr[mid]) left = mid+1;
    
    else right = mid-1;
        
    }
    
    return -1;
    
    }
}
