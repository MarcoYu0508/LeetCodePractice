/**
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
    const set = new Set();
    const resultSet = new Set();
    for (const num of nums) set.add(num);
    let array = [...set];
    for (const num of array) {
        const results = twoSum(removeItemOnce(nums, num), 0 - num)
        for (const result of results) {
            result.push(num);
            result.sort();
            resultSet.add(result.join(","));
        }
    }
    let resToArray = []
    resultSet.forEach(item => resToArray.push(item.split(',').map(item => parseInt(item))))
    return resToArray
};

var twoSum = function (nums, target) {
    let map = new Map();
    let result = [];
    for (let i = 0; i < nums.length; i++) {
        if (map.has(target - nums[i])) {
            result.push([nums[map.get(target - nums[i])], nums[i]]);
        } else {
            map.set(nums[i], i);
        }
    }
    return result;
};

var removeItemOnce = function (arr, value) {
    var index = arr.indexOf(value);
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}

const threeSumSol = (nums) => {
    const res = [];
    if (nums.length < 3) return res;

    nums.sort((a, b) => a - b);

    const target = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) continue;

        let leftIdx = i + 1;
        let rightIdx = nums.length - 1;

        const remain = target - nums[i];

        while (leftIdx < rightIdx) {
            const sum = nums[leftIdx] + nums[rightIdx];
            if (sum === remain) {
                res.push([nums[i], nums[leftIdx], nums[rightIdx]]);
                while (nums[leftIdx] === nums[leftIdx + 1]) leftIdx++;
                while (nums[rightIdx] === nums[rightIdx - 1]) rightIdx--;
                leftIdx++;
                rightIdx++;
            } else if (sum < remain) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
    }
    return res;
}

console.log(threeSumSol([-1,0,1,2,-1,-4]))