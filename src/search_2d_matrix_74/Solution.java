package search_2d_matrix_74;

/**
 * Created by Ahmed Al-Aishat on Jul/16/2023.
 * LeetCode Algorithm II Project.
 */
class Solution {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        int row = rowBinarySearch(matrix, target);
        if (row == -1) return false;
        return binarySearch(matrix[row], target, 0, matrix[row].length - 1) >= 0;
    }

    public int rowBinarySearch(int[][] matrix, int target) {
        int start = 0, end = matrix.length;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) return mid;
            if (target > matrix[mid][matrix[0].length - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        var mid = (end + start) / 2;
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return binarySearch(nums, target, start, mid - 1);
        return binarySearch(nums, target, mid + 1, end);
    }
}