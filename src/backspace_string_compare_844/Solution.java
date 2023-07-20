package backspace_string_compare_844;

/**
 * Created by Ahmed Al-Aishat on Jul/20/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("bxj##tw", "bxj###tw"));
    }

    public boolean backspaceCompare(String s, String t) {
        int sPt = s.length() - 1, tPt = t.length() - 1;
        int sBackSpaces = 0, tBackSpaces = 0;
        while (sPt >= 0 && tPt >= 0) {
            if (sBackSpaces == 0 && tBackSpaces == 0 && s.charAt(sPt) != '#' && t.charAt(tPt) != '#') {// no backspaces
                if (s.charAt(sPt) != t.charAt(tPt)) return false; // different chars
                // same char => continue
                sPt--;
                tPt--;
                continue;
            }

            if (s.charAt(sPt) == '#') { // increase s backspaces counter
                sPt--;
                sBackSpaces++;
            } else if (sBackSpaces > 0) { // decrease t backspaces counter otherwise the pointer will not moved
                sPt--;
                sBackSpaces--;
            }

            if (t.charAt(tPt) == '#') { // increase t backspaces counter
                tPt--;
                tBackSpaces++;
            } else if (tBackSpaces > 0) { // decrease t backspaces counter otherwise the pointer will not moved
                tPt--;
                tBackSpaces--;
            }
        }
        // check the remaining strings, as one of them may not checked, therefor its beginning should be empty input
        return isEmpty(s.substring(0, sPt + 1), sBackSpaces) && isEmpty(t.substring(0, tPt + 1), tBackSpaces);
    }

    boolean isEmpty(String s, int backSpaces) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (backSpaces < 0) return false;
            if (s.charAt(i) == '#') backSpaces++;
            else backSpaces--;
        }
        return backSpaces >= 0;
    }
}
