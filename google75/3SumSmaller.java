/*
Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
*/

// 2 pointer appraoch
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);// step 1 - sort
        int ans = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
          // step2 : 2 pointers
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s >= target) {
                  // sum is more or equal but need less 
                    --k;//remove the higher element
                } else {
                  //if the sum s is smaller than the target, all triplets that include nums[i], nums[j], and any element from nums[j+1] to nums[k] are valid since array is sorted
                    ans += k - j;
                    ++j;
                }
            }
        }
        return ans;
    }
}
