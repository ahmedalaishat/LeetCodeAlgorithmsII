package house_robber_II_213;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 2, 4, 3, 2, 5}));
        System.out.println(new Solution().rob(new int[]{200, 3, 140, 20, 10}));
        System.out.println(new Solution().rob(new int[]{10, 20, 140, 3, 200}));
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution().rob(new int[]{1, 300, 1, 300, 1}));
        System.out.println(new Solution().rob(new int[]{300, 1, 1, 1, 300}));
        System.out.println(new Solution().rob(new int[]{300, 1, 1, 1, 300}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(solve(nums), solve(reverse(nums)));
    }

    public int solve(int[] nums) {
        int[] sums = new int[nums.length];
        boolean[] firstSelected = new boolean[nums.length];
        firstSelected[0] = true;

        // copy the first two elements
        System.arraycopy(nums, 0, sums, 0, 2);

        // fill the third element if the arr length > 2
        if (nums.length > 2) {
            sums[2] = sums[0] + nums[2];
            firstSelected[2] = true;
        }

        // compare i-2 with i-3 since we may skip two elements like [7,1,1,7]
        for (int i = 3; i < nums.length; i++) {
            if (sums[i - 2] == sums[i - 3]) {
                if (!firstSelected[i - 2])
                    sums[i] = sums[i - 2] + nums[i];
                else {
                    sums[i] = sums[i - 3] + nums[i];
                    firstSelected[i] = firstSelected[i - 3]; // update for the current sum if the first item is included or not
                }
            } else if (sums[i - 2] < sums[i - 3]) {
                sums[i] = sums[i - 3] + nums[i];
                firstSelected[i] = firstSelected[i - 3];
            } else {
                sums[i] = sums[i - 2] + nums[i];
                firstSelected[i] = firstSelected[i - 2];
            }

        }
        if (sums[sums.length - 2] > sums[sums.length - 1])
            return sums[sums.length - 2]; // the last item is not included => return sum without the last item

        boolean isFirstSelected = firstSelected[firstSelected.length - 1];
        if (!isFirstSelected)
            return sums[sums.length - 1]; // the first item is not included => return sum with the last item
        return Math.max(Math.max(sums[sums.length - 1] - nums[0], sums[sums.length - 2]), sums[sums.length - 3]); // retrun sum without the first or the last item
    }

    private int[] reverse(int[] arr) {
        int t;
        for (int i = 0; i < arr.length / 2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        return arr;
    }
}