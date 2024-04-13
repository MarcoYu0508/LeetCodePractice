/*
 * @lc app=leetcode id=1431 lang=cpp
 *
 * [1431] Kids With the Greatest Number of Candies
 */

#include <vector>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution
{
public:
    vector<bool> kidsWithCandies(vector<int> &candies, int extraCandies)
    {
        vector<bool> result;
        int max = *max_element(candies.begin(), candies.end());
        for (auto i : candies)
            result.push_back((extraCandies + i >= max));
        return result;
    }
};
// @lc code=end
