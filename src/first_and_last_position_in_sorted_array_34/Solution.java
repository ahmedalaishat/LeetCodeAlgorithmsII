package first_and_last_position_in_sorted_array_34;

/**
 * Created by Ahmed Al-Aishat on Jul/16/2023.
 * LeetCode Algorithm II Project.
 */
class Solution {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        var index = binarySearch(nums, target, 0, nums.length - 1);
        if (index < 0) return new int[]{-1, -1};
        int start = index, end = index;
        while (start > 0 && nums[start - 1] == nums[index]) start--;
        while (end < nums.length - 1 && nums[end + 1] == nums[index]) end++;
        return new int[]{start, end};
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start < end) return -1;
        var mid = (end + start) / 2;
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return binarySearch(nums, target, start, mid - 1);
        return binarySearch(nums, target, mid + 1, end);
    }
}