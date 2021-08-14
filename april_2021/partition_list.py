task_desc = """
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


Input: head = [2,1], x = 2
Output: [1,2]


Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        head = head
        x_ref = None
        before_biggest_ref = None
        actual_biggest_ref = None
        
        previous_node = None
        current_node = head

        items_to_move_counter = 0

        # step 1 get all info
        while current_node is not None:
            current_val = current_node.val

            # update items to move counter 
            # TODO move logic here in order to do all in one go
            if current_val < x and before_biggest_ref is not None:
                items_to_move_counter += 1

            # update x_ref value if not set yet
            if x_ref is None and current_val == x:
                x_ref = current_node
            
            # update before_biggest_ref if not set yet 
            if before_biggest_ref is None and current_val >= x:
                if previous_node is None:
                    actual_biggest_ref = current_node
                    before_biggest_ref = current_node
                else:
                    actual_biggest_ref = current_node
                    before_biggest_ref = previous_node
            previous_node = current_node
            current_node = current_node.next

        # step 2 loop through items and insert those into proper place
        for i in range(items_to_move_counter):
            # pop out next node
            node_before = self.get_next_lower_node(start_node=actual_biggest_ref, treshold=x)
            node_to_move = node_before.next
            node_after = node_to_move.next

            node_before.next = node_after

            # insert next node
            # TODO spot the bug try head == prev_big_node and curr_big_node
            if before_biggest_ref is head and actual_biggest_ref is head:
                node_to_move.next = head
                head = node_to_move
                # before_biggest_ref = node_to_move
            else:
                node_after_insert = before_biggest_ref.next
                before_biggest_ref.next = node_to_move
                node_to_move.next = node_after_insert
                # before_biggest_ref = node_to_move
            # self.print(head)
            # print("iteration")
            before_biggest_ref = node_to_move
        return head

    def get_next_lower_node(self, start_node: ListNode, treshold: int) -> ListNode:
        prev_ref = None
        current_ref = start_node

        while current_ref is not None:

            if current_ref.val < treshold:
                return prev_ref

            prev_ref = current_ref
            current_ref = current_ref.next

    def print(self, head: ListNode):
        next_node = head
        while next_node is not None:
            print(next_node.val)
            next_node = next_node.next
    

# n6 = ListNode(val=2, next=None)
# n5 = ListNode(val=5, next=n6)
# n4 = ListNode(val=2, next=n5)
# n3 = ListNode(val=3, next=n4)
# n2 = ListNode(val=4, next=n3)
# n1 = ListNode(val=1, next=n2)

n6 = ListNode(val=2, next=None)
n5 = ListNode(val=5, next=n6)
n4 = ListNode(val=0, next=n5)
n3 = ListNode(val=3, next=n4)
n2 = ListNode(val=4, next=n3)
n1 = ListNode(val=1, next=n2)

l2 = ListNode(val=1, next=None)
l1 = ListNode(val=2, next=l2)

sol = Solution()
print("before#1")
sol.print(head=n1)
print("after#1")
result = sol.partition(head=n1, x=2)
sol.print(head=result)

# print("before#2")
# sol.print(head=l1)
# print("after#2")
# result = sol.partition(head=l1, x=2)
# sol.print(head=result)

# completed
