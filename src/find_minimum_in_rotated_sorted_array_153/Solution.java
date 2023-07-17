package find_minimum_in_rotated_sorted_array_153;

/**
 * Created by Ahmed Al-Aishat on Jul/17/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 1, 2, 3}));
    }

    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        return findRotatedMin(nums, 0, nums.length - 1);
    }

    public int findRotatedMin(int[] nums, int start, int end) {
        if (start > end) return -1;
        var mid = (start + end) / 2;
        if (mid - 1 > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return nums[mid + 1];
        if (nums[mid] > nums[0]) return findRotatedMin(nums, mid + 1, end);
        return findRotatedMin(nums, start, mid - 1);
    }
}
