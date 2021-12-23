/**
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 */


/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
    if (lists.length == 0) return null;
    // repeat until only one list is left
    let last = lists.length - 1;
    while (last != 0) {
        let i = 0, j = last;

        // (i, j) forms a pair
        while (i < j) {
            // merge List i with List j and store
            // merged list in List i
            lists[i] = SortedMerge(lists[i], lists[j]);

            // consider next pair
            i++;
            j--;

            // If all pairs are merged, update last
            if (i >= j)
                last = j;
        }
    }

    return lists[0];
};

/**
 * 
 * @param {ListNode} node1
 * @param {ListNode} node2
 * @returns 
 */
const SortedMerge = (node1, node2) => {
    let result = null;
    if (node1 == null)
        return node2;
    else if (node2 == null)
        return node1;

    if (node1.data <= node2.data) {
        result = node1;
        result.next = SortedMerge(node1.next, node2);
    } else {
        result = node2;
        result.next = SortedMerge(node1, node2.next);
    }

    return result;
}