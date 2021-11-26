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


