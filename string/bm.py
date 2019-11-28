from typing import List, Tuple

SIZE = 256


def _generate_bad_char_table(pattern: str) -> List[int]:
    bc = [-1] * SIZE
    for i, char in enumerate(pattern):
        bc[ord(char)] = i
    return bc


def _generate_good_suffix_table(pattern: str) -> Tuple[List[bool], List[int]]:
    m = len(pattern)
    prefix, suffix = [False] * m, [-1] * m

    for i in range(m - 1):
        j = i
        k = 0
        while j >= 0 and pattern[j] == pattern[~k]:
            j -= 1
            k += 1
            suffix[k] = j + 1
        if j == -1: prefix[k] == True
    return (prefix, suffix)


def _move_by_good_suffix(bad_char_index: int, suffix: List[int], prefix: List[bool]) -> int:
    k = len(suffix) - 1 - bad_char_index
    if suffix[k] != -1: return bad_char_index - suffix[k] + 1
    # test from k - 1
    for r, can_match_prefix in enumerate(reversed(prefix[:k]), bad_char_index + 2):
        if can_match_prefix: return r
    return len(suffix)


def bm(s: str, pattern: str) -> int:
    bc = _generate_bad_char_table(pattern)
    prefix, suffix = _generate_good_suffix_table(pattern)
    n, m = len(s), len(pattern)
    i = 0
    while i <= n - m:
        j = m - 1
        while j >= 0:
            if s[i + j] != pattern[j]: break
            j -= 1
        if j < 0: return i

        x = j - bc[ord(s[i + j])]
        y = 0
        if j < m - 1:
            y = _move_by_good_suffix(j, suffix, prefix)
        i += max(x, y)
    return -1


if __name__ == "__main__":
    s = "Here is an example"
    pattern = "example"
    print(bm(s, pattern))
    print(s.find(pattern) == bm(s, pattern))

    s = "abcdcccdc"
    pattern = "cccd"
    print(s.find(pattern) == bm(s, pattern))
