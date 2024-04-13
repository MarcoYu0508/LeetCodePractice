/*
 * @lc app=leetcode id=1732 lang=cpp
 *
 * [1732] Find the Highest Altitude
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    int largestAltitude(vector<int> &gain)
    {
        int maxAlt = 0;
        int currentAlt = 0;
        for (auto alt : gain)
        {
            currentAlt += alt;
            maxAlt = max(maxAlt, currentAlt);
        }
        return maxAlt;
    }
};
// @lc code=end
