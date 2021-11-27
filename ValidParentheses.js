/**
Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 */

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
    if (s.length == 1) return false;
    const stack = new Stack();
    for (const char of s) {
        if (char === '(' || char === '[' || char === '{') {
            stack.push(char)
        } else {
            if (!isMatch(stack.pop(), char)) return false;
        }
    }
    if (!stack.isEmpty()) return false;
    return true;
};

function Stack() {
    var items = [];
    this.push = function (element) {
        items.push(element);
    }
    this.pop = function () {
        return items.pop();
    }
    this.peek = function () {
        return items[items.length - 1];
    }
    this.isEmpty = function () {
        return items.length === 0;
    }
    this.clear = function () {
        items = [];
    }
    this.size = function () {
        return items.length;
    }
    this.print = function () {
        console.log(items.toString());
    }
}

const isMatch = (type, char) => {
    switch (type) {
        case '[':
            return char === ']';
        case '{':
            return char === '}';
        case '(':
            return char === ')';
        default:
            return false;
    }
}

console.log(isValid("("))