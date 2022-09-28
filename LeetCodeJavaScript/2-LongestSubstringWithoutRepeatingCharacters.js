/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let maxLength = 0, count = 0;
    let charSet = new Set();
    let leftBound = 0, rightBound = 0;

    if (!s) {
        return maxLength;
    }

    while (rightBound < s.length) {
        const char = s[rightBound];
        if (!charSet.has(char)) {
            charSet.add(char);
            count++;

            if (count > maxLength) {
                maxLength = count;
            }
        } else {
            while (s[leftBound] !== s[rightBound]) {
                charSet.delete(s[leftBound]);
                leftBound++;
                count--;
            }

            leftBound++;
        }
        rightBound++;
    }
    return maxLength;
};

console.log(lengthOfLongestSubstring("aabaab!bb"));