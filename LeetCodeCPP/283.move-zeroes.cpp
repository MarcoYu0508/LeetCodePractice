/*
 * @lc app=leetcode id=283 lang=cpp
 *
 * [283] Move Zeroes
 */
#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        int lastNoZeroIdx = 0;
        for (size_t i = 0; i < nums.size(); i++)
        {
            if (nums[i] != 0)
                nums[lastNoZeroIdx++] = nums[i];
        }
        for (size_t i = lastNoZeroIdx; i < nums.size(); i++)
        {
            nums[i] = 0;
        }
    }
};
// @lc code=end
