/**
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (nums[mid] === target) return mid;
           
        if (nums[left] <= nums[mid]) {
            // target is at the left section
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid - 1;
            } 
            // target is at the right section
            else {
                left = mid + 1;
            }
        } else {
             // target is at the right section
            if (nums[mid] <= target && target <= nums[right]) {
                left = mid + 1;
            } 
            // target is at the left section
            else {
                right = mid - 1;
            }
        }
    }
    return -1;
};