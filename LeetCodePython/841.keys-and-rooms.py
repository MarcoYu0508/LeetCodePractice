#
# @lc app=leetcode id=841 lang=python3
#
# [841] Keys and Rooms
#

from typing import List


# @lc code=start
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        can_visit_list = [False] * len(rooms)
        can_visit_list[0] = True

        room_stack = [0]

        while len(room_stack) > 0:
            room_idx = room_stack.pop()
            for key in rooms[room_idx]:
                if not can_visit_list[key]:
                    can_visit_list[key] = True
                    room_stack.append(key)

        return all(can_visit for can_visit in can_visit_list)


# @lc code=end
