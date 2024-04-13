#include <string>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=13 lang=cpp
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution
{
public:
    int romanToInt(string s)
    {
        unordered_map<char, int> romanMap = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000},
        };
        int ans = 0;
        int n = s.size();
        int prev = romanMap[s[n - 1]];
        ans = ans + prev;

        for (int i = n - 2; i >= 0; i--)
        {
            int temp = romanMap[s[i]];
            if (temp >= prev)
                ans = ans + temp;
            else
                ans = ans - temp;

            prev = temp;
        }
        return ans;
    }
};
// @lc code=end
