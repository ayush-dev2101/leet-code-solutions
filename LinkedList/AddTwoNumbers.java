### Add Two Numbers (LeetCode)

**Approach:**  
Traverse both linked lists simultaneously while keeping track of carry.  
A dummy node is used to build the result list efficiently.

**Time Complexity:** O(max(n, m))  
**Space Complexity:** O(max(n, m))

**CODE**
  /*
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {}

    // Constructor that sets the value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor that sets both value and next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify handling of the result list
        ListNode dummy = new ListNode(0);

        // Current pointer used to build the result list
        ListNode current = dummy;

        // Variable to store carry-over during addition
        int carry = 0;

        // Loop until both lists are fully traversed and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get value from l1 if available, otherwise 0
            int val1 = (l1 != null) ? l1.val : 0;

            // Get value from l2 if available, otherwise 0
            int val2 = (l2 != null) ? l2.val : 0;

            // Add the two values plus any carry
            int sum = val1 + val2 + carry;

            // Update carry for next iteration
            carry = sum / 10;

            // Create a new node with the digit
            current.next = new ListNode(sum % 10);

            // Move current pointer forward
            current = current.next;

            // Advance l1 and l2 if they are not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the head of the new list (skip dummy node)
        return dummy.next;
    }
}
