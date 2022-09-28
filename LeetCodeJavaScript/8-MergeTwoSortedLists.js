/**
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

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function (list1, list2) {
    let head = new ListNode();
    let nextList = head;
    if (list1 == null) 
        head.next = list2;
    else if (list2 == null) 
        head.next = list1;
    else {
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                nextList.next = list2;
                break;
            } else if (list2 == null) {
                nextList.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    nextList.next = list1;
                    nextList = nextList.next;
                    list1 = list1.next;
                } else if (list1.val > list2.val) {
                    nextList.next = list2;
                    nextList = nextList.next;
                    list2 = list2.next;
                } else {
                    nextList.next = list1;
                    nextList = nextList.next;
                    list1 = list1.next;
                    nextList.next = list2;
                    nextList = nextList.next;
                    list2 = list2.next;
                }
            }
        }
    }

    return head.next;
};