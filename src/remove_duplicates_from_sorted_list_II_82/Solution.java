package remove_duplicates_from_sorted_list_II_82;

import common.ListNode;

/**
 * Created by Ahmed Al-Aishat on Jul/18/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(new Solution().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        var preHead = new ListNode();
        preHead.next = head;
        var trailer = preHead; // reference for the last item before duplicates
        var leader = head; // to pass over duplicates
        while (leader != null && leader.next != null) {
            // no duplicates for the current item
            if (leader.val != leader.next.val) {
                leader = leader.next;
                trailer = trailer.next;
                continue;
            }
            while (true) {
                // end of the list or end of the current duplicates
                if (leader.next == null || leader.val != leader.next.val) {
                    leader = leader.next;
                    break;
                }
                leader = leader.next;
            }
            trailer.next = leader;
        }
        return preHead.next;
    }
}
