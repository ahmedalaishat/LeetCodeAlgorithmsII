package shuffle_an_array_384;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ahmed Al-Aishat on Aug/04/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        var s = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }

    int[] nums;
    int[] shuffled;

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffled = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {

        for (int i = 0; i < shuffled.length - 1; i++) {
            int index = ThreadLocalRandom.current().nextInt(i, shuffled.length);
            if (index == i) continue;
            // swap
            int temp = shuffled[i];
            shuffled[i] = shuffled[index];
            shuffled[index] = temp;
        }
        return shuffled;
    }
}
