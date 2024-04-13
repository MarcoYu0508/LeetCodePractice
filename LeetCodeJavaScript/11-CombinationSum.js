/**
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */


/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
    const set = new Set();
    const resultSet = new Set();
    for (const num of candidates) set.add(num);
    let i;
    let _target;

    for (let index = candidates.length - 1; index >= 0; index--) {
        i = index;
        _target = target
        let num = candidates[i];
        let result = [];
        while (_target > 0) {
            _target -= num;
            if (_target == 0) {
                result.push(num);
                result.sort();
                resultSet.add(result.join(","));
                break;
            }
            if (num > _target) {
                if (set.has(_target)) {
                    result.push(_target);
                    result.push(num);
                    resultSet.add(result.join(","));
                    break;
                }
            } else {
                result.push(num);
            }
        }
    }
    const results = [];
    for (const result of resultSet) {
        const numbers = [];
        const number_str = result.split(",");
        for (const str of number_str) {
            numbers.push(parseInt(str, 10));
        }
        results.push(numbers.sort());
    }
    return results;
};

console.log(combinationSum([2, 3, 6, 7], 7));
console.log(combinationSum([2, 3, 5], 8));
console.log(combinationSum([2], 1));