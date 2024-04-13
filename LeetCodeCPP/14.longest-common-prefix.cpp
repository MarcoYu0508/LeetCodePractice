#include <string>
#include <vector>

using namespace std;
/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        string ans = "";
        int index = 0;
        while (true)
        {
            for (int i = 0; i < strs.size(); i++)
            {
                if (strs[i].length() == 0)
                    return "";
                else if (strs[i].length() > index)
                {
                    if (strs[0][index] != strs[i][index])
                        return ans;
                }
                else
                    return ans;
                ;
            }
            ans += strs[0][index];
            index++;
        }
    }
};
// @lc code=end
