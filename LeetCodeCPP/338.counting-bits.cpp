/*
 * @lc app=leetcode id=338 lang=cpp
 *
 * [338] Counting Bits
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    vector<int> countBits(int n)
    {
        vector<int> bits(n + 1, 0);

        for (size_t i = 1; i <= n; i++)
        {
            bits[i] = 1 + bits[i & (i - 1)];
        }
        return bits;
    }
};
// @lc code=end
