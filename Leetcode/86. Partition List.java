package Leetcode;
/**
 *  Approach
        1. Dummy Nodes: Create two dummy nodes, lessDummy and greaterDummy. These act as placeholders 
        to make it easier to append nodes without checking if the lists are empty.
        2.  Pointers: Initialize less and greater pointers to track the current tail of each list.
        3. Traverse and Split: * Iterate through the original list.
            1. If head.val < x, attach the node to the less list.
            2. Otherwise, attach it to the greater list.
            3. Move the corresponding tail pointer forward.
        4. Terminate & Connect:
            1. Crucial Step: Set greater.next = null. This prevents potential cycles in the linked list, 
            as the last node of the greater list might still be pointing to a node that was moved to the 
            "less" list.
            2. Connect the end of the less list to the start of the greater list (greaterDummy.next).
        5. Return: Return lessDummy.next.
    Complexity
        Time complexity: O(N) — We perform a single pass through the linked list where is the number of 
        nodes.
        Space complexity: O(1) — We are not creating new nodes (the original nodes are just re-linked)
        , and we only use a constant amount of extra pointer variables.
 */
class Solution {
//   Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        // Two dummy nodes to start the two lists
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        
        // Pointers to the current end of the two lists
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Important: end the greater list to avoid cycles
        greater.next = null;
        
        // Connect the "less" list to the "greater" list
        less.next = greaterDummy.next;
        
        return lessDummy.next;
    }
}
