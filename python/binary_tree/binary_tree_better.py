class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def insert(root: TreeNode, val: int):
    if not root:
        root = TreeNode(val)
    else:
        if val <= root.val:
            root.left = insert(root.left, val)
        elif val > root.val:
            root.right = insert(root.right, val)
    return root


def query(root: TreeNode, val: int):
    if not root:
        return False
    if root.val == val:
        return True
    else:
        if val < root.val:
            return query(root.left, val)
        else:
            return query(root.right, val)


def delete(root: TreeNode, val: int):
    if not root:
        return None
    if val < root.val:
        root.left = delete(root.left, val)
    if val > root.val:
        root.right = delete(root.right, val)
    else:
        if root.left == None and root.right == None:
            root = None
        elif root.left and root.right:
            temp = findMin(root.right)
            root.val = temp.val
            delete(root.right, temp.val)
        elif root.left == None:
            root = root.right
        elif root.right == None:
            root = root.left
    return root

def findMin(root):
    if not root:
        return None
    elif root.left:
        return findMin(root.left)
    else:
        return root


def findMax(root):
    if not root:
        return None
    elif root.right:
        return findMax(root.right)
    return root


def back_recursion(root: TreeNode):
    if root == None:
        return
    else:
        front_recursion(root.left)
        front_recursion(root.right)
        print(root.val)


def mid_recursion(root: TreeNode):
    if root == None:
        return
    else:
        front_recursion(root.left)
        print(root.val)
        front_recursion(root.right)


def front_recursion(root: TreeNode):
    if root == None:
        return
    else:
        print(root.val)
        front_recursion(root.left)
        front_recursion(root.right)


if __name__ == "__main__":
    root = TreeNode(3)
    insert(root, 2)
    insert(root, 5)
    insert(root, 6)
    print("Front_recursion")
    front_recursion(root)
    print("Mid_recursion")
    mid_recursion(root)
    print("Back_recursion")
    back_recursion(root)
    #print("delete root 3")
    #print("MIN")
    #print(findMin(root).val)
    print("print delete")
    front_recursion(delete(root, 5))
