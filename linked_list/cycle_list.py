class Node():
    """节点"""

    def __init__(self, elem):
        self.elem = elem
        self.next = None


class Single_CYCLE_LinkList():
    """单向循环链表"""

    def __init__(self, node=None):
        self._head = node
        if node:
            node.next = node

    def is_empty(self):
        # 链表是否为空
        if self._head == None:
            return True
        else:
            return False

    def length(self):
        # 链表长度
        if self.is_empty():
            return 0
        cur = self._head
        count = 1
        while cur.next != self._head:
            count += 1
            cur = cur.next
        return count

    def travel(self):
        # 遍历整个链表
        if self.is_empty():
            return
        else:
            cur = self._head
            while cur.next != self._head:
                print(cur.elem, end=' ')
                cur = cur.next
            print(cur.elem)

    def add(self, item):
        node = Node(item)
        if self.is_empty():
            self._head = node
            node.next = node
        else:
            cur = self._head
            while cur.next != self._head:
                cur = cur.next
            node.next = self._head
            self._head = node
            cur.next = node

    def append(self, item):
        node = Node(item)
        if self._head == None:
            self._head = node
            node.next = node
        else:
            cur = self._head
            while cur.next != self._head:
                cur = cur.next
            cur.next = node
            node.next = self._head

    def insert(self, pos, item):
        if pos <= 0:
            self.add(item)
        elif pos >= self.length():
            self.append(item)
        else:
            node = Node(item)
            pre = self._head
            count = 0
            while count < pos - 1:
                count += 1
                pre = pre.next
            node.next = pre.next
            pre.next = node

    def remove(self, item):
        """删除一个节点"""
        # 若链表为空，则直接返回
        if self.is_empty():
            return
        # 将cur指向头节点
        pre = None
        cur = self._head
        while cur.next != self._head:
            if cur.elem == item:
                # 先判断此节点是否是头结点
                if cur == self._head:
                    # 先找到尾节点
                    rear = self._head
                    while rear.next != self._head:
                        rear = rear.next
                    rear.next = self._head
                    self._head = cur.next

                else:
                    # 中间节点
                    pre.next = cur.next
                return
            else:
                pre = cur
                cur = cur.next
        # 退出循环，cur指向尾节点
        if cur.elem == item:
            if self.length() == 1:
                self._head = None
            else:
                pre.next = cur.next

    def search(self, item):
        if self.is_empty():
            return False
        cur = self._head
        while cur.next != self._head:
            if cur.elem == item:
                return True
            else:
                cur = cur.next
        if cur.elem == item:
            return True
        return False


if __name__ == '__main__':
    single_obj = Single_CYCLE_LinkList()
    print(single_obj.is_empty())
    print(single_obj.length())
    single_obj.append(1)
    single_obj.append(2)
    single_obj.append(3)
    single_obj.append(4)
    single_obj.append(5)
    single_obj.travel()
    single_obj.add(-1)
    single_obj.travel()
    single_obj.insert(-1, -2)
    single_obj.travel()
    single_obj.insert(2, 0)
    single_obj.travel()
    print(single_obj.search(0))
    single_obj.remove(2)
    single_obj.travel()
    single_obj.remove(5)
    single_obj.travel()
    single_obj.remove(-2)
    single_obj.travel()
