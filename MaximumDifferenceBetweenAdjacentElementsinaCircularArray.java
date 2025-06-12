
/*==========================================================

Given a circular array nums, find the maximum absolute difference between adjacent elements.
Note: In a circular array, the first and last elements are adjacent.

Example 1:
Input: nums = [1,2,4]

Output: 3
Explanation:
Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

============================================================ */

public class MaximumDifferenceBetweenAdjacentElementsinaCircularArray {
    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.abs(nums[i - 1] - nums[i]));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1,2,4}));
    }
}
