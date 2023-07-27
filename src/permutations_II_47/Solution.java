package permutations_II_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/26/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        List<Integer> notSelected = Arrays.stream(nums).boxed().toList();
        solve(notSelected, selected, ans);
        return ans;
    }

    public static void solve(List<Integer> notSelected, List<Integer> selected, List<List<Integer>> ans) {
        if (notSelected.size() == 0) {
            if (!ans.contains(selected))
                ans.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < notSelected.size(); i++) {
            List<Integer> copy = new ArrayList<>(notSelected);
            selected.add(copy.remove(i));
            solve(copy, selected, ans);
            selected.remove(selected.size() - 1);
        }
    }
}
