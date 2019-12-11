class Array:
    def __init__(self, capacity=10):
        """
        构造函数
        """
        self._capacity = capacity  # 数组最大容量
        self._size = 0  # 数组已使用的大小
        self._data = [None] * self._capacity  # 初始化元素

    def add(self, index, elem):
        """
        向数组中添加新元素
        """
        # 1.index有效性判断
        if (index < 0 or index > self._size):
            print("index不合法！")
            return
        # 2.判断容量capacity是否足够
        # 已满:扩容
        if (self._size == self._capacity):
            self._resize(self._capacity * 2)
        # 3.在指定位置添加元素
        # 先将index之后的元素全部依次后移一位
        for i in range(self._size - 1, index - 1, -1):
            self._data[i + 1] = self._data[i]
        self._data[index] = elem  # 将元素添加到index
        # 4.更新size
        self._size += 1

    def _resize(self, new_capacity):
        """
        扩容方法
        """
        # 1.新建一个大容量数组
        newarr = Array(new_capacity)
        # 2.将现在self._data的元素逐个拷贝到新数组
        for i in range(self._size):
            newarr.add(i, self._data[i])
        # 3.更新变量
        self._capacity = new_capacity
        self._data = newarr._data

    def print(self):
        """
        打印数组
        """
        for i in range(self._size):
            print(self._data[i], end='\t')


if __name__ == "__main__":
    array1 = Array(10)
    for i in range(10):
        array1.add(i, i + 1)
    array1.print()

    print()
    array1.add(3, 100)
    array1.print()

