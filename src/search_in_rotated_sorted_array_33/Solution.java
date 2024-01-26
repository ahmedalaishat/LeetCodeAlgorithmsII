package search_in_rotated_sorted_array_33;

/**
 * Created by Ahmed Al-Aishat on Jul/16/2023.
 * LeetCode Algorithm II Project.
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }

    public int search(int[] nums, int target) {
        var rotationPivot = getRotationPivot(nums);
        if (rotationPivot == 0) return binarySearch(nums, target, 0, nums.length - 1);
        var sortedNums = getOriginalOfRotated(nums, rotationPivot);
        int index = binarySearch(sortedNums, target, 0, sortedNums.length - 1);
        if (index == -1) return -1;
        if (index + rotationPivot < nums.length) return index + rotationPivot;
        return index + rotationPivot - nums.length;
    }


    public int getRotationPivot(int[] rotated) {
        if (rotated.length == 1 || rotated[0] < rotated[rotated.length - 1]) return 0;
        int pivotIndex = 1;
        // find the pivot index
        while (rotated[pivotIndex - 1] < rotated[pivotIndex]) pivotIndex++;
        return pivotIndex;
    }

    public int[] getOriginalOfRotated(int[] rotated, int pivotIndex) {
        int[] original = new int[rotated.length];

        int originalIndex = 0;
        // copy items from pivot to the end of the original array in the first of rotated array
        while (pivotIndex < rotated.length) original[originalIndex++] = rotated[pivotIndex++];

        int beginIndex = 0;
        // copy the rest of the rotated array from the beginning of the original array
        while (originalIndex < rotated.length) original[originalIndex++] = rotated[beginIndex++];

        return original;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        var mid = (end + start) / 2;
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return binarySearch(nums, target, start, mid - 1);
        return binarySearch(nums, target, mid + 1, end);
    }
}