/*
 * @lc app=leetcode id=1456 lang=cpp
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

#include <string>
#include <unordered_set>
using namespace std;

// @lc code=start
class Solution
{
public:
    int maxVowels(string s, int k)
    {
        unordered_set<char> vowels{'a', 'e', 'i', 'o', 'u'};
        int count = 0;

        for (size_t i = 0; i < k; i++)
        {
            count += vowels.count(s[i]);
        }

        int answer = count;

        for (size_t i = k; i < s.length(); i++)
        {
            count += vowels.count(s[i]) - vowels.count(s[i - k]);
            answer = max(answer, count);
        }

        return answer;
    }
};
// @lc code=end
