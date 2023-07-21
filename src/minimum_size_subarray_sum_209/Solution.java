package minimum_size_subarray_sum_209;

import java.util.Arrays;

/**
 * Created by Ahmed Al-Aishat on Jul/20/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                min = Math.min(right - left, min);
                left++;
            }
            right++;
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min + 1;
    }
}