from typing import List

import random

def quick_sort(a):
    _quick_sort_between(a, 0, len(a) - 1)

def _quick_sort_between(a, low, high):
    if low < high:
        k = random.randint(low, high)
        a[low], a[k] = a[k], a[low]

        m = _partition(a, low, high)
        _quick_sort_between(a, low, m-1)
        _quick_sort_between(a, m+1, high)

def _partition(a, low, high):
    pivot, j = a[low], low
    for i in range(low+1, high+1):
        if a[i] <= pivot:
            j += 1
            a[j], a[i] = a[i], a[j]
    a[low], a[j] = a[j], a[low]
    return j

def findkth(num, low, high, k):  # 找到数组里第k个数
    index = _partition(num, low, high)
    #print(_partition(num, low, high))
    if index == k: return num[index]
    if index < k:
        return findkth(num, index + 1, high, k)
    else:
        return findkth(num, low, index - 1, k)


def test_quick_sort():
    a1 = [3, 5, 6, 7, 8]
    quick_sort(a1)
    assert a1 == [3, 5, 6, 7, 8]
    a2 = [2, 2, 2, 2]
    quick_sort(a2)
    assert a2 == [2, 2, 2, 2]
    a3 = [4, 3, 2, 1]
    quick_sort(a3)
    assert a3 == [1, 2, 3, 4]
    a4 = [5, -1, 9, 3, 7, 8, 3, -2, 9]
    quick_sort(a4)
    assert a4 == [-2, -1, 3, 3, 5, 7, 8, 9, 9]


if __name__ == "__main__":
    a1 = [3, 5, 6, 7, 8]
    a2 = [2, 2, 2, 2]
    a3 = [4, 3, 2, 1]
    a4 = [5, -1, 9, 3, 7, 8, 3, -2, 9]
    quick_sort(a1)
    print(a1)
    quick_sort(a2)
    print(a2)
    quick_sort(a3)
    print(a3)
    quick_sort(a4)
    print(a4)
    print(findkth(a4,0,len(a4)-1,5))