/*
 * @lc app=leetcode id=151 lang=cpp
 *
 * [151] Reverse Words in a String
 */

#include <string>
#include <sstream>
#include <stack>

using namespace std;

// @lc code=start
class Solution
{
public:
    string reverseWords(string s)
    {
        stack<string> words;
        stringstream iss{s};

        string word;
        while (iss >> word)
        {
            words.push(word);
        }

        stringstream oss;

        while (!words.empty())
        {
            oss << words.top();
            words.pop();
            if (!words.empty())
                oss << " ";
        }
        return oss.str();
    }
};
// @lc code=end
