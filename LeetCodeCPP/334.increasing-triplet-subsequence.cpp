/*
 * @lc app=leetcode id=334 lang=cpp
 *
 * [334] Increasing Triplet Subsequence
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    bool increasingTriplet(vector<int> &nums)
    {
        int firstMin = INT_MAX;
        int secondMin = INT_MAX;
        for (auto &num : nums)
        {
            if (num <= firstMin)
                firstMin = num;
            else if (num < secondMin)
                secondMin = num;
            else if (num > secondMin)
                return true;
        }
        return false;
    }
};
// @lc code=end
