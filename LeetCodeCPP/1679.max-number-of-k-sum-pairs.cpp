/*
 * @lc app=leetcode id=1679 lang=cpp
 *
 * [1679] Max Number of K-Sum Pairs
 */

#include <vector>
#include <unordered_map>

using namespace std;

// @lc code=start
class Solution
{
public:
    int maxOperations(vector<int> &nums, int k)
    {
        int count = 0;

        unordered_map<int, int> map;
        for (auto &num : nums)
        {
            if (map[k - num] > 0)
            {
                map[k - num]--;
                count++;
            }
            else
            {
                map[num]++;
            }
        }
        return count;
    }
};
// @lc code=end
