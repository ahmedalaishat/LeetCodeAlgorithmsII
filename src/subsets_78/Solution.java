package subsets_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/24/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int ind, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = ind; i < nums.length; i++) {
            temp.add(nums[i]);
            solve(i + 1, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
