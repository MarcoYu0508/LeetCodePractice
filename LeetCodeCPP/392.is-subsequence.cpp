/*
 * @lc app=leetcode id=392 lang=cpp
 *
 * [392] Is Subsequence
 */
#include <string>

using namespace std;

// @lc code=start
class Solution
{
    int subSequenceCount(string &s, string &t, int i, int j)
    {
        if (i == 0 || j == 0)
            return 0;
        else if (s[i - 1] == t[j - 1])
            return 1 + subSequenceCount(s, t, i - 1, j - 1);
        else
            return subSequenceCount(s, t, i, j - 1);
    }

public:
    bool isSubsequence(string s, string t)
    {
        int m = s.length(), n = t.size();
        if (m > n)
            return false;
        else if (subSequenceCount(s, t, m, n) == m)
            return true;
        else
            return false;
    }
};
// @lc code=end
