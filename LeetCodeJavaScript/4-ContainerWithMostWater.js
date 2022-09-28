/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let result = 0;
	let	leftIdx = 0
	let	rightIdx = height.length - 1;

	while (leftIdx < rightIdx) {
		let smallestSide = Math.min(height[leftIdx], height[rightIdx]);
		let area = (rightIdx - leftIdx) * smallestSide;

		if (area > result) result = area;

		if (height[leftIdx] < height[rightIdx]) leftIdx++;
		else rightIdx--;
	}
    return result;
};


// let height = [4, 3, 2, 1, 4];
// let height = [3, 7, 5, 10, 7, 6];
let height = [1,0,0,0,0,0,0,2,2]
console.log(maxArea(height));