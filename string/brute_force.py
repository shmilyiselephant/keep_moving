def brute_force(t,p):
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

def simple_hash(s, start, end):
    """
    Calculate the hash of sub_string
    ASC-II of each char
    :param s:
    :param start:
    :param end:
    :return:
    """
    assert start <= end

    ret = 0
    for c in s[start: end+1]:
        ret += ord(c)
    return ret

def rk(main, pattern):
    n = len(main)
    m = len(pattern)

    if n <= m:
        return 0 if pattern == main else -1

    #hash of substring
    hash_memo = [None] * (n-m+1)
    hash_memo[0] = simple_hash(main, 0, m-1)
    for i in range(1, n-m+1):
        hash_memo[i] = hash_memo[i-1] - simple_hash(main, i-1, i-1) + simple_hash(main, i+m-1, i+m-1)

    #hash of pattern
    hash_p = simple_hash(pattern, 0, m-1)

    for i, h in  enumerate(hash_memo):
        if h == hash_p:
            if pattern == main[i: i+m]:
                return i
            else:
                continue
    return -1

if __name__ == "__main__":
    t = 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' \
        'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' \
        'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbb' \
        'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbasssssssssssssssssssssssssssssssssssssssssssssssa'
    p = 'bas'
    import time
    start_time_1 = time.time()
    print(brute_force(t,p))
    cost_time_1 = time.time() - start_time_1
    start_time_2 = time.time()
    print(rk(t,p))
    cost_time_2 = time.time() - start_time_2
    print("bf: %s,  rk:  %s" % (cost_time_1, cost_time_2))
    print("bf - rk = %s" % str(cost_time_1 - cost_time_2))
