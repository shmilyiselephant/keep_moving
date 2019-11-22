from typing import Optional


class Node:
    def __init__(self, data: int, next=None):
        self.data = data
        self._next = next


# Reverse single-linked-list
# keypoint: the direction of "next" never changed in the process
def reverse(head: Node) -> Optional[Node]:
    reversed_head = None
    current = head
    while current:
        reversed_head, reversed_head.next, current = current, reversed_head, current._next
    return reversed_head


def reverse_recursive(head: Node) -> Optional[Node]:
    if (head == None or head._next == None):
        return head
    p = Node(reverse_recursive(head.next))
    head.next.next = head
    head.next = None
    return p

# Detect cycle in a list
def has_cycle(head: Node) -> bool:
    slow, fast = head, head
    while fast and fast._next:
        slow = slow._next
        fast = fast._next._next
        if slow == fast:
            return True
    return False


# Detect cycle in a list two
def has_cycle_two(head: Node) -> bool:
    slow, fast = head, head
    while True:
        if fast and fast.next:
            slow = slow._next
            fast = fast._next._next
            if slow == fast:
                break
        else:
            return None

    fast = head
    while fast != slow:
        fast, slow = fast._next, slow._next
    return slow


# Merge two sorted linked list
def merge_sorted_list(l1: Node, l2: Node) -> Optional[Node]:
    if l1 and l2:
        p1, p2 = l1, l2
        fake_head = Node(None)
        current = fake_head
        while p1 and p2:
            if p1.data <= p2.data:
                current._next = p1
                p1 = p1._next
            else:
                current._next = p2
                p2 = p2._next
            current = current._next
        current._next = p1 if p1 else p2
        return fake_head._next
    # merge is direct if one list is null
    return l1 or l2

#slow node runs after fast node runs n steps
def remove_nth_from_end(head: Node, n: int) -> Optional[Node]:
    fast = head
    count = 0
    while fast and count < n:
        fast = fast._next
        count += 1
    if not fast and count < n:  # not that many nodes
        return head
    if not fast and count == n:
        return head._next

    slow = head
    while fast._next:
        fast, slow = fast._next, slow._next
    slow._next = slow._next._next
    return head


# Find the middle node of linked list
# A fast counter and a slow counter, when fast reached the end, the position of slow node is the middle node.
def find_middle_node(head: Node) -> Optional[Node]:
    slow, fast = head, head
    fast = fast._next if fast else None
    while fast and fast._next:
        slow, fast = slow._next, fast._next._next
    ### if return rest list
    ## if fast return slow.next else return slow
    return slow

# Remove node with virtual node
def remove_node(head, value):
    fast = Node(-1)
    fast.next = head
    prev = fast
    while prev._next:
        if prev._next.data == value:
            prev._next = prev._next._next
        else:
            prev = prev._next
    return fast._next

def print_all(head: Node):
    nums = []
    current = head
    while current:
        nums.append(current.data)
        current = current._next
    print("->".join(str(num) for num in nums))

def delete_node(node: Node):
    node.val = node._next.data
    node._next = node._next._next