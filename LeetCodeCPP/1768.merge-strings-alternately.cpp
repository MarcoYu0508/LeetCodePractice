/*
 * @lc app=leetcode id=1768 lang=cpp
 *
 * [1768] Merge Strings Alternately
 */
#include <string>
using namespace std;
// @lc code=start
class Solution
{
public:
    string mergeAlternately(string word1, string word2)
    {
        int m = word1.size();
        int n = word2.size();
        string result = "";

        for (int i = 0; i < max(m, n); i++)
        {
            if (i < m)
            {
                result.push_back(word1[i]);
            }
            if (i < n)
            {
                result.push_back(word2[i]);
            }
        }

        return result;
    }
};
// @lc code=end
