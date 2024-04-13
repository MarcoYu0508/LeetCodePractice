#include <vector>

using namespace std;

/*
 * @lc app=leetcode id=169 lang=cpp
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution
{
public:
    int majorityElement(vector<int> &nums)
    {
        int majIdx = 0;
        int cnt = 1;
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[majIdx] == nums[i])
                cnt++;
            else
                cnt--;

            if (cnt == 0)
            {
                majIdx = i;
                cnt = 1;
            }
        }

        return nums[majIdx];
    }
};
// @lc code=end
