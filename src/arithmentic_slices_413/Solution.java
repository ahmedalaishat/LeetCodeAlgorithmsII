package arithmentic_slices_413;

/**
 * Created by Ahmed Al-Aishat on Jul/29/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int start = 0;
        int end = 2;
        int ans = 0;

        while (true) {
            if (end == nums.length) return 0;
            if (nums[end] - nums[end - 1] == nums[end - 1] - nums[start]) break;
            end++;
            start++;
        }

        var diff = nums[end] - nums[end - 1];
        outer:
        while (end < nums.length) {
            if (nums[end] - nums[end - 1] == diff) {
                ans += end - start - 1;
                end++;
            } else {
                start = end - 1;
                end++;
                while (true) {
                    if (end == nums.length) break outer;
                    if (nums[end] - nums[end - 1] == nums[end - 1] - nums[start]) break;
                    end++;
                    start++;
                }
                diff = nums[end] - nums[end - 1];
            }
        }
        return ans;
    }
}
