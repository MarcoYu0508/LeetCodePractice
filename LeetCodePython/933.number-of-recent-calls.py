#
# @lc app=leetcode id=933 lang=python3
#
# [933] Number of Recent Calls
#
from collections import deque


# @lc code=start
class RecentCounter:
    def __init__(self):
        self._counter = 0
        self._request_queue = deque()

    def ping(self, t: int) -> int:
        self._request_queue.append(t)
        self._counter += 1

        while self._request_queue[0] < t - 3000:
            self._request_queue.popleft()
            self._counter -= 1

        return self._counter


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
# @lc code=end
