/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tez = head;
        ListNode dheere = head;
        ListNode first = head, second = head;
        for(int i = 0; i < k - 1; i++) tez = tez.next;
        first = tez;
        while(tez.next != null) {
			dheere = dheere.next;
            tez = tez.next;
        }
        
        second = dheere;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
