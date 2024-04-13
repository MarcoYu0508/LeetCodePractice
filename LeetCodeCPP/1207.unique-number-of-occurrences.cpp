/*
 * @lc app=leetcode id=1207 lang=cpp
 *
 * [1207] Unique Number of Occurrences
 */

#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

// @lc code=start
class Solution
{
public:
    bool uniqueOccurrences(vector<int> &arr)
    {
        unordered_map<int, int> freqMap;
        for (auto num : arr)
        {
            freqMap[num]++;
        }

        unordered_set<int> freqSet;
        for (auto [key, value] : freqMap)
        {
            freqSet.insert(value);
        }

        return freqMap.size() == freqSet.size();
    }
};
// @lc code=end
