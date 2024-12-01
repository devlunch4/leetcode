class Solution {
    public int[] twoSum(int[] nums, int target) {
                int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; ++i) {
            for (int j = i + 1; j < numsLength; ++j) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
