/*
 * @lc app=leetcode id=643 lang=cpp
 *
 * [643] Maximum Average Subarray I
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    double findMaxAverage(vector<int> &nums, int k)
    {
        double maxAvg = 0;
        int sum = 0;
        for (size_t j = 0; j < k; j++)
        {
            sum += nums[j];
        }
        maxAvg = (double)sum / k;
        for (size_t i = 1; i <= nums.size() - k; i++)
        {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxAvg = max(maxAvg, (double)sum / k);
        }
        return maxAvg;
    }
};
// @lc code=end
