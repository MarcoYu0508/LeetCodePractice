/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    int maxArea(vector<int> &height)
    {
        int maxA = 0;

        int i = 0;
        int j = height.size() - 1;

        while (i < j)
        {
            int h = min(height[i], height[j]);

            maxA = max(maxA, (j - i) * h);
            while (height[i] <= h && i < j)
                i++;
            while (height[j] <= h && i < j)
                j--;
        }
        return maxA;
    }
};
// @lc code=end
