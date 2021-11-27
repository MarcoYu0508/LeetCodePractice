/**
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
    let node = head;
    const nodeList = [];
    nodeList.push(node);
    while (node.next !== null) {
        nodeList.push(node.next);
        node = node.next;
    }
    const length = nodeList.length;
    if (length - n === 0) {
        if (length === 1) return null;
        else {
            head = nodeList[1];
        }
    } else {
        nodeList[length - n - 1].next = nodeList[length - n + 1] === undefined ? null : nodeList[length - n + 1]
    }
    return head;
};