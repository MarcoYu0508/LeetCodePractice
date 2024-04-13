/*
 * @lc app=leetcode id=443 lang=cpp
 *
 * [443] String Compression
 */

#include <vector>
#include <string>

using namespace std;

// @lc code=start
class Solution
{
public:
    int compress(vector<char> &chars)
    {
        int groupIdx = 0;
        char currentChar = chars[0];
        int count = 1;

        for (size_t i = 1; i < chars.size(); i++)
        {
            if (chars[i] == currentChar)
            {
                count++;
            }
            else
            {
                if (count > 1)
                {
                    string count_str = to_string(count);
                    for (size_t j = 0; j < count_str.length(); j++)
                    {
                        chars[++groupIdx] = count_str[j];
                    }
                    chars[++groupIdx] = chars[i];
                    currentChar = chars[i];
                    count = 1;
                }
                else
                {
                    chars[++groupIdx] = chars[i];
                    currentChar = chars[i];
                    // groupIdx++;
                    count = 1;
                }
            }
        }

        if (count > 1)
        {
            string count_str = to_string(count);
            for (size_t j = 0; j < count_str.length(); j++)
            {
                chars[++groupIdx] = count_str[j];
            }
        }

        return groupIdx + 1;
    }
};
// @lc code=end
