def nmatching(t,p):
    i, j = 0, 0
    n, m = len(t), len(p)
    while i < n and j < m:
        if t[i] == p[j]:
            i, j = i+1, j+1
        else:
            i, j = i-j+1, 0
    if j == m:
        return i-j

    return -1

if __name__ == "__main__":
    t = 'aaaaabbbasssa'
    p = 'as'
    print(nmatching(t,p))