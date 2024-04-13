/*
 * @lc app=leetcode id=605 lang=cpp
 *
 * [605] Can Place Flowers
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
    bool canPlaceFlowers(vector<int> &flowerbed, int n)
    {
        int count = 0;
        int size = flowerbed.size();
        for (size_t i = 0; i < size; i++)
        {
            if (flowerbed[i] == 0)
            {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0))
                {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n)
                    {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
};
// @lc code=end
