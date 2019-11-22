class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None

def create_linkList(n):
    """
    Create the link list and return the head
    :param n:
    :return:
    """
    head = Node(1)
    pre = head
    for i in range(2, n+1):
        newNode = Node(i)
        pre.next = newNode
        pre = newNode
    pre.next = head
    return head

def play(total_number, gap):
    """

    :param n:
    :param m:
    :return:
    """
    if gap == 1:
        print(total_number)
    else:
        head = create_linkList(total_number)
        pre = None
        cur = head
        # End point: the next node is the node self
        while cur.next != cur:
            for i in range(gap-1):
                pre = cur
                cur = cur.next
            print(cur.value)
            pre.next = cur.next
            cur.next = None
            cur = pre.next
        print(cur.value)

if __name__ == "__main__":
    import argparse
    parser = argparse.ArgumentParser(description="give the total number and gap")
    parser.add_argument("--total_number", dest="total_number", default=5, type=int)
    parser.add_argument("--gap", dest="gap", default=2, type=int)
    paras = parser.parse_args()
    if hasattr(paras, 'total_number') and hasattr(paras, 'gap'): #hasattr({object}, 'key')
        play(paras.total_number, paras.gap)
