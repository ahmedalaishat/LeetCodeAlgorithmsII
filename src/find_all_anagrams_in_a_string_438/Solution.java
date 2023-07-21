package find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/20/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }
        if (checkZeroArr(count))
            indices.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - p.length()) - 'a']++;
            if (checkZeroArr(count))
                indices.add(i - p.length() + 1);
        }
        return indices;
    }

    private boolean checkZeroArr(int[] count) {
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0) return false;
        return true;
    }
}
