package find_peak_element_162;

/**
 * Created by Ahmed Al-Aishat on Jul/17/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid; // the peak must be in the left half or at the mid position
            else left = mid + 1; // the peak must be in the right half.
        }
        return left;
    }
}
