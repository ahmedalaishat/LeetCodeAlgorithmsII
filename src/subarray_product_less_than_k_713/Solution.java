package subarray_product_less_than_k_713;

/**
 * Created by Ahmed Al-Aishat on Jul/20/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int result = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            product = product * nums[right];

            while (product >= k && left < right) {
                product /= nums[left];
                left++;
            }

            if (product < k) {
                // Each step introduces x new subarrays, where x is the size of the current window (right - left + 1)
                result += (right - left + 1);
            }
            right++;
        }
        return result;
    }
}
