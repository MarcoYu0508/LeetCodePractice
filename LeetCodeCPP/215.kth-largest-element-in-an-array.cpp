#include <vector>

using namespace std;

/*
 * @lc app=leetcode id=215 lang=cpp
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution
{
public:
    int findKthLargest(vector<int> &nums, int k)
    {
        int count[20001] = {0};
        for (auto x : nums)
            count[x + 10000]++;

        int i = 20000;
        while (k > 0)
            k -= count[i--];

        return i + 1 - 10000;
    }
};
// @lc code=end
