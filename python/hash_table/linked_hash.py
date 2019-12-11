class ListNode(object):
    def __init__(self, key):
        self.key = key
        self.next = None

class HashMap(object):
    def __init__(self, tablesize):
        self.table=[None]*tablesize
        self._n = 0

    def __len__(self):
        return self._n

    def _hash(self,key):
        return abs(hash(key)%len(self.table))

    def __getitem__(self, key):
        j = self._hash(key)
        node = self.table[j]
        while node is not None and node.key != key:
            node = node.next
        if node is not None:
            raise(KeyError,'Keyerror'+repr(key))
        return node

    def insert(self,key):
        try:
            self[key]
        except KeyError:
            j = self._hash(key)
            node = self.table[j]
            self.table[j] = ListNode(key)
            self.table[j].next = node
            self._n += 1

    def __delitem__(self, key):
        j = self._hash(key)
        node = self.table[j]
        if node is not None:
            self.table[j] = node.next
            self._n -= 1
        else:
            while node.next != None:
                pre = node
                node = node.next
                if node.key == key:
                    pre.next = node.next
                    self._n -= 1
                    break