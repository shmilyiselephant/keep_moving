import sys

def print_matrix(n: int):
    for i in range(0, n):
        for i1 in range(i, n-i):
            print("(%s,%s)" % (i1, i))
        for i2 in range(i+1, n-i):
            print("(%s,%s)" % (i1, i2))
        for i3 in range(n-i-2, i-1, -1):
            print("(%s,%s)" % (i3, i2))
        for i4 in range(n-i-2, i, -1):
            print("(%s,%s)" % (i3, i4))

if __name__ == "__main__":
    n = sys.argv[1] 
    print_matrix(int(n))