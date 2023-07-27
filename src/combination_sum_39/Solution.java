package combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2}, 1));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }

    public boolean solve(int[] candidates, int target, int start, List<Integer> selected, int selectedSum) {
        if (selectedSum == target) ans.add(new ArrayList<>(selected));
        if (selectedSum >= target) return true;
        List<Integer> current = new ArrayList<>(selected);
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            selectedSum += candidates[i];
            if (solve(candidates, target, i, current, selectedSum)) return false;
            current.remove(current.size() - 1);
            selectedSum -= candidates[i];
        }
        return false;
    }
}
