#include <vector>

using namespace std;

/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int current = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            current = max(current + nums[i], nums[i]);
            res = max(current, res);
        }
        return res;
    }
};
// @lc code=end
