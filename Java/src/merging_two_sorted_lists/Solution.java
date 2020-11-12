package merging_two_sorted_lists;

public class Solution {
    public static void main(String [] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode B = new ListNode(1, new ListNode(2, new ListNode(4)));
        Solution ans = new Solution();
        ListNode result = ans.mergeTwoLists(A, B);
        while(result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode reference = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }

        if (l1 == null) {
            newNode.next = l2;
        } else if (l2 == null) {
            newNode.next = l1;
        }
        return reference.next;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}