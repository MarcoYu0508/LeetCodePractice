/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    const symbolString = insertSymboInString(s);
    const n = symbolString.length;

    const radius = [];
    let C = 0, L = 0, R = 0;

    for (let i = 0; i < n - 1; i++) {
        let mirrorIndex = C * 2 - i;
        // special cases, using central expand to get radius
        if (mirrorIndex <= 2 || i >= R || i + radius[mirrorIndex] >= R) {
            if (mirrorIndex >= 0 && i + radius[mirrorIndex] >= R) {
                // We can just do central expanding among unknown range
                radius[i] = R - i;
            } else {
                radius[i] = 0;
            }
            while (symbolString[i - radius[i] - 1] == symbolString[i + radius[i] + 1]) {
                radius[i]++;
            }
            C = i;
            L = i - radius[i];
            R = i + radius[i];
        } else {
            radius[i] = radius[mirrorIndex];
        }
    }

    let maxIndex = 1;

    // [1 ~ n - 1] 的範圍是因為頭尾是用來界定邊界的不同符號，不需要計算到
    for (let i = 1; i < n - 1; i++) {
        if (radius[i] > radius[maxIndex]) {
            maxIndex = i;
        }
    }
    let startIndex = (maxIndex - radius[maxIndex]) / 2;

    const LPS = s.substring(startIndex, startIndex + radius[maxIndex]);
    return LPS;
};

var insertSymboInString = function (s) {
    let symbolString = "$#";
    for (let i = 0; i < s.length; i++) {
        symbolString += s[i] + "#";
    }
    return symbolString + "^";
}

console.log(longestPalindrome("babad"));


// https://havincy.github.io/blog/post/ManacherAlgorithm/