package jumb_game_55;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }
    public boolean canJump(int[] nums) {
        int steps = 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i] < steps) steps++;
            else steps = 1;
        return steps == 1;
    }
}
