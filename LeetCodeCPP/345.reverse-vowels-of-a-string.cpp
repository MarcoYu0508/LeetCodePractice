/*
 * @lc app=leetcode id=345 lang=cpp
 *
 * [345] Reverse Vowels of a String
 */

#include <string>
#include <unordered_set>

using namespace std;

// @lc code=start
class Solution
{
public:
    string reverseVowels(string s)
    {
        int i = 0, j = s.size() - 1;
        while (i < j)
        {
            i = s.find_first_of("aeiouAEIOU", i);
            j = s.find_last_of("aeiouAEIOU", j);
            if (i < j)
            {
                swap(s[i++], s[j--]);
            }
        }
        return s;
    }
};
// @lc code=end
