import sys

sys.path.append('singly_linked_list')
from singly_linked_list import SinglyLinkedList

def reverse(head):
    reverse_head = None
    while head:
        next = head.next
        head.next = reverse_head
        reverse_head = head
        head = next
    return reverse_head

def is_palindrome(l):
    l.print_all()
    slow, fast = l.head, l.head
    pos = 0
    while fast and fast.next:
        slow, fast = slow.next, fast.next.next
        pos += 1

    reverse_node = reverse(slow)
    head_node = l.head
    is_palin = True
    while (head_node and reverse_node):
        if (head_node.data == reverse_node.data):
            head_node = head_node.next
            reverse_node = reverse_node.next
        else:
            is_palin = False
            break
    return is_palin

if __name__ == "__main__":
    test_str_arr = ['ab','aa','aba','abba','abcba']
    for str in test_str_arr:
        l = SinglyLinkedList()
        for i in str:
            l.insert_value_to_head(i)

        print(is_palindrome(l))
