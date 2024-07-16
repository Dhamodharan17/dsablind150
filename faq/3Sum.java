class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();

     //2 pointer
     Arrays.sort(nums);

     for(int i=0;i<nums.length-2;i++){

        if(i>0 && nums[i] == nums[i-1]) continue;

        int left=i+1;
        int right = nums.length-1;

        while(left<right){

            int currentSum = nums[i]+ nums[left]+ nums[right];

            if(currentSum==0){
                res.add(List.of(nums[i],nums[left],nums[right]));

                //skip duplicate - slide window
                while(left<right && nums[left]==nums[left+1]){
                    left++;
                }
                //skip duplicates - slidewindow
                while(left<right && nums[right] == nums[right-1]){
                    right--;
                }
                left++;
                right--;
            }else if(currentSum<0){
                left++;
            }else if(currentSum>0){
                right--;
            }
        }
     }

    return res;
    }
}
