#include <vector>
#include <string>

using namespace std;
/*
 * @lc app=leetcode id=401 lang=cpp
 *
 * [401] Binary Watch
 */

// @lc code=start
class Solution
{
public:
    vector<string> readBinaryWatch(int turnedOn)
    {
        vector<string> res;

        for (int h = 0; h < 12; ++h)
            for (int m = 0; m < 60; ++m)
            {
                if (intToBinary(h) + intToBinary(m) == turnedOn)
                {
                    string s = "";
                    s += to_string(h);
                    s.push_back(':');
                    if (m < 10)
                        s.push_back('0');
                    s += to_string(m);
                    res.push_back(s);
                }
            }

        return res;
    }

private:
    int intToBinary(int n)
    {
        int res = 0;
        while (n > 0)
        {
            res += n % 2;
            n /= 2;
        }
        return res;
    }
};
// @lc code=end
