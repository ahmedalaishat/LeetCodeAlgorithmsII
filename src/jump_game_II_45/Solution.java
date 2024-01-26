package jump_game_II_45;

/**
 * Created by Ahmed Al-Aishat on Jul/28/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{5, 4, 0, 1, 3, 6, 8, 0, 9, 4, 9, 1, 8, 7, 4, 8}));
        System.out.println(new Solution().jump(new int[]{1}));
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
        System.out.println(new Solution().jump(new int[]{5, 2, 1, 2, 5, 2, 6, 8, 1, 9, 3, 5, 8, 0, 2}));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int reachable = 0;
        int[] steps = new int[nums.length]; // the minimum steps needed to reach each index
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) return steps[i] + 1;
            if (i + nums[i] > reachable) { // from the current position we can reach new positions
                for (int j = reachable + 1; j <= i + nums[i]; j++)
                    steps[j] = steps[i] + 1; // update the new positions with the current steps +1
                reachable = i + nums[i]; // update reachable
            }
        }
        return steps[nums.length - 1];
    }

//    public int jump(int[] nums) {
//        if (nums.length == 1) return 0;
//
//        int[] steps = new int[nums.length]; // the minimum steps needed to reach each index
//        int step = 1;
//        if (nums[0] >= nums.length - 1) return 1;
//        steps[nums[0]] = 1;
//        int reachable = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (i + nums[i] >= nums.length - 1) {
//                if (steps[i] != 0) return steps[i] + 1;
//                else return step + 1;
//            }
//            if (i + nums[i] > reachable) { // from the current position we can reach new positions
//                if (steps[reachable] == step + 1) steps[reachable] = 0;
//                reachable = i + nums[i]; // update reachable
//                steps[reachable] = step + 1; // update the last new positions with the current steps + 1
//            }
//            if (steps[i] != 0) step = steps[i] + 1;
//        }
//        return -1;
//    }
}
