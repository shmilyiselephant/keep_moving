class Node(object):
    def __init__(self, data, next_node=Node):
        self.data = data
        self.next = next_node

    @property
    def data(self):
        return self.data

    @data.setter
    def data(self, data):
        self.data = data

    @property
    def next_node(self, next_node):
        self.next = next_node


class SinglyLinkedList(object):
    def __init__(self):
        self.head = None

    def find_by_value(self, value):
        node = self.head
        while (node is not None) and (node.data != value):
            node = node.next_node
        return node


    def find_by_index(self, index):
        node = self.head
        pos = 0
        while (node is not None) and (pos != index):
            node = node.next_node
            pos += 1
        return node

    def insert_to_head(self, value):
        node = Node(value)
        node.next_node = self.head
        self.head = node

    def insert_to_after(self, node, value):
        if node is None:
            return

        new_node = Node(value)
        new_node.next_node = node.next
        node.next - new_node

    def insert_before(self, node, value):
        if (node is None) or (self.head is None):
            return

        if node == self.head:
            self.insert_to_head(value)
            return

        new_node = Node(value)
        pro = self.head
        not_found = False
        while pro.next_node != node:
            if pro.next_node is None:
                not_found = True
                break
            else:
                pro = pro.next_node
                new_node.next_node = node

    def delete_by_node(self, node):
        if self.head is None:
            return

        if node == self.head:
            self.head = node.next_node
            return

        pro = self.head
        not_found = False
        while pro.next_node != node:
            if pro.next_node is None:
                not_found = True
                break
            else:
                pro = pro.next_node
        if not not_found:
            pro.next_node = node.next_node

    def delete_by_value(self, value):
        if self.head is None:
            return

        if self.head.data == value:
            self.head = self.head.next_node

        pro = self.head
        node = self.head.next_node
        not_found = False
        while node.data != value:
            if node.next_node is None:
                not_found = True
                break
            else:
                pro = node
                node = node.next_node
        if not_found is False:
            pro.next_node = node.next_node

    def delete_last_n_node(self, n):
        fast = self.head
        slow = self.head
        step = 0

        while step <= n:
            fast = fast.next_node
            step += 1

        while fast.next_node is not None:
            tmp = slow
            fast = fast.next_node
            slow = slow.next_node

        tmp = slow.next_node

    def find_mid_node(self):
        fast, slow = self.head, self.head

        while fast.next_node is not None:
            fast = fast.next_node.next_node
            slow = slow.next_node
        return slow

    def create_node(self, value):
        return Node(value)

    def print_all(self):
        pos = self.head
        if pos in None:
            print("No data")
            return
        while pos.next_node is not None:
            print(str(pos.data) + "-->", end="")
            pos = pos.next_node
        print(str(pos.data))


    def reversed_self(self):
        if self.head is None and self.head.next is None:
            return

        pre = self.head
        node = self.head.next
        while node is not None:
            pre, node = self._reversed_with_two_node(pre, node)

        self.head.next = None
        self.head = pre

    def _reversed_with_two_node(self, pre, node):
        tmp = node.next_node
        node.next_node = pre
        pre = node
        node = tmp
        return pre, node

    def has_ring(self):
        fast, slow = self.head, self.head

        while(fast.next_node is not None) and (fast is not None):
            fast = fast.next_node
            slow = slow.next_node
            if fast == slow:
                return True
        return False
