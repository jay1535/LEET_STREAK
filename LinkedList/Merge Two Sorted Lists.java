//Solution


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;  // Add the smaller node to the merged list
                l1 = l1.next;    // Move the pointer to the next node in l1
            } else {
                tail.next = l2;  // Add the smaller node to the merged list
                l2 = l2.next;    // Move the pointer to the next node in l2
            }
            tail = tail.next;  // Move the tail of the merged list
        }

        // Attach the remaining part of l1 or l2 (if any) to the merged list
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        // Return the merged list, starting from the next node of dummy
        return dummy.next;
    }
}

/*

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
*/
