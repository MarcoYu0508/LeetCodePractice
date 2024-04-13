/*
 * @lc app=leetcode id=933 lang=cpp
 *
 * [933] Number of Recent Calls
 */

#include <vector>
#include <iostream>
using namespace std;

// @lc code=start
class RecentCounter
{
private:
    vector<int> requests;

public:
    RecentCounter()
    {
    }

    int ping(int t)
    {
        requests.push_back(t);

        while (requests.front() < t - 3000)
        {
            requests.erase(requests.begin());
        }

        return requests.size();
    }
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter* obj = new RecentCounter();
 * int param_1 = obj->ping(t);
 */
// @lc code=end

int main()
{
    RecentCounter counter;

    cout << "ping: " << counter.ping(642) << endl;
    cout << "ping: " << counter.ping(1849) << endl;
    cout << "ping: " << counter.ping(4921) << endl;
    cout << "ping: " << counter.ping(5936) << endl;
    cout << "ping: " << counter.ping(5957) << endl;
}
