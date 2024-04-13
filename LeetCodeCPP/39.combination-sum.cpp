#include <vector>
#include <set>
#include <queue>

using namespace std;
/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        vector<vector<int>> ans;
        vector<int> options;
        solve(candidates, 0, options, ans, 0, target);
        return ans;
    }

private:
    void solve(vector<int> &candidates, int idx, vector<int> &options, vector<vector<int>> &ans, int currSum, int &target)
    {
        // base cases
        if (currSum == target)
        {
            ans.push_back(options);
            return;
        }

        if (idx == candidates.size())
        {
            if (currSum == target)
            {
                ans.push_back(options);
            }
            return;
        }

        // call for picking same element
        if (currSum + candidates[idx] <= target)
        {
            options.push_back(candidates[idx]);
            solve(candidates, idx, options, ans, currSum + candidates[idx], target);
            options.pop_back();
        }

        solve(candidates, idx + 1, options, ans, currSum, target);
    }
};
// @lc code=end
