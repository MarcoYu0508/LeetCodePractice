/**
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    // for (var i = 0; i < nums.length; i++) {
    //     const remain = target - nums[i];
    //     const index = nums.slice(i + 1).indexOf(remain);
    //     if (index !== -1) {
    //         return [i, index + i + 1];
    //     }
    // }

    // let ans = [];
    // let map = new Map();

    // for (let i = 0; i < nums.length; i++) {
    //     map.set(nums[i], i);
    // }
    // for (let i = 0; i < nums.length; i++) {
    //     if (map.has(target - nums[i]) && map.get(target - nums[i]) != i) {
    //         ans.push(i)
    //         ans.push(map.get(target - nums[i]));
    //         break;
    //     }
    // }
    // return ans;

    let map = new Map();
    
    for(let i = 0; i < nums.length; i ++) {
        if(map.has(target - nums[i])) {
            return [map.get(target - nums[i]), i];
        } else {
            map.set(nums[i], i);
        }
    }
	return [];
};

let nums = [3, 3];
let target = 6;
console.log(twoSum(nums, target));


