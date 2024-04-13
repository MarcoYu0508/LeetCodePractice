/*
 * @lc app=leetcode id=724 lang=cpp
 *
 * [724] Find Pivot Index
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    int pivotIndex(vector<int> &nums)
    {
        int sum = 0, leftSum = 0;
        for (auto num : nums)
            sum += num;

        for (size_t i = 0; i < nums.size(); i++)
        {
            if (leftSum == sum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
};
// @lc code=end
