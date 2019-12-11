
class MyArray:
    """
    A simple wrapper around list.
    """
    def __init__(self, capacity):
        self._data = []
        self._capacity = capacity

    def __getitem__(self, position):
        return self._data[position]

    def __setitem__(self, key, value):
        self._data[key] = value

    def __len__(self):
        return len(self._data)

    def __iter__(self):
        for item in self._data:
            yield item

    def __str__(self):
        return 'Foo object (len: %s)' % self._data.__len__()

    def find(self, index):
        try:
            return self._data[index]
        except IndexError:
            return None

    def delete(self, index):
        try:
            self._data.pop(index)
            return True
        except IndexError:
            return False

    def insert(self, index, value):
        if len(self) >= self._capacity:
            return False
        else:
            return self._data.insert(index, value)

    def print_all(self):
        for item in self:
            print(item)

def test_myarray():
    array = MyArray(5)
    array.insert(0, 3)
    array.insert(0, 4)
    array.insert(1, 5)
    array.insert(1, 5)
    array.insert(3, 9)
    assert array.insert(0, 100) is False
    assert len(array) == 5
    assert array.find(1) == 5
    assert array.delete(4) is True
    array.print_all()

if __name__ == "__main__":
    test_myarray()
