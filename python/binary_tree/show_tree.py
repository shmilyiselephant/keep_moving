#-*- coding:utf-8 -*-
class Node:
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None

class Tree:
    def __init__(self):
        self.queue=[]#利用队列存储树的节点
        self.flag=0#存储树根后flag置为1
        self.root=None

    #建树
    def createTree(self,list):
        while True:
            #list中没有数据，表示建树完成
            if len(list)==0:
                return
            #flag为0，表示树根不存在
            if self.flag==0:
                self.root=Node(list[0])
                #讲树根存入队列
                self.queue.append(self.root)
                #树根已创建，flag置为1
                self.flag=1
                #剔除list中第一个已经使用数
                list.pop(0)
            else:
                '''
                treeNode:队列中的第一个节点(该节点左右孩子不完全存在)
                添加treeNode的左右孩子，当添加treeNode的右孩子之后，
                将队列中的第一个节点出队。
                '''
                treeNode=self.queue[0]
                if treeNode.left==None:
                    treeNode.left=Node(list[0])
                    self.queue.append(treeNode.left)
                    list.pop(0)
                else:
                    treeNode.right = Node(list[0])
                    self.queue.append(treeNode.right)
                    list.pop(0)
                    self.queue.pop(0)


    # 递归实现先序遍历
    def front_recursion(self,root):
        if root==None:
            return
        else:
            print(root.data)
            self.front_recursion(root.left)
            self.front_recursion(root.right)
    # 递归实现中序遍历
    def middle_recursion(self,root):
        if root==None:
            return
        else:
            self.middle_recursion(root.left)
            print(root.data)
            self.middle_recursion(root.right)
    # 递归实现后序遍历
    def behind_recursion(self,root):
        if root==None:
            return
        else:
            self.behind_recursion(root.left)
            self.behind_recursion(root.right)
            print(root.data)

    # 队栈实现先序遍历
    def front_queueAndStack(self,root):
        if root==None:
            return
        #定义一个栈,存储节点
        stack=[]
        node=root
        while stack or node:
            #从树根开始一直输出左孩子
            while node:
                print(node.data)
                #将输出的节点加入栈中
                stack.append(node)
                node= node.left
            #该节点不存在左节点时,该节点出栈,搜索该节点右节点，
            node=stack.pop()
            node=node.right
    # 队栈实现中序遍历
    def middle_queueAndStack(self,root):
        if root==None:
            return
        # 定义一个栈,存储节点
        stack = []
        node = root
        while stack or node:
            #一直查找树的左节点,一直进栈
            while node:
                stack.append(node)
                node=node.left
            node=stack.pop()#该节点不存在左节点，该节点出栈，查找右节点
            print(node.data)
            node=node.right
    # 队栈实现后序遍历
    def behind_queueAndStack(self,root):
        if root==None:
            return
        # 定义一个栈,存储节点
        stack_1 = []
        stack_2 = []
        node = root
        stack_1.append(node)
        while stack_1:
            #该节点出栈1.左右节点进栈1(对于左右节点,右节点先出栈1,也先进栈1)
            node=stack_1.pop()
            if node.left:
                stack_1.append(node.left)
            if node.right:
                stack_1.append(node.right)
            #该节点进栈2
            stack_2.append(node)
        while stack_2:
            print(stack_2.pop().data)
    # 队栈实现层次遍历
    def level_queueAndStack(self,root):
        if root==None:
            return
        stack_1=[]
        stack_2=[]
        stack_1.append(root)
        stack_2.append(root)
        while stack_1:
            node=stack_1.pop(0)
            if node.left:
                stack_1.append(node.left)
                stack_2.append(node.left)
            if node.right:
                stack_1.append(node.right)
                stack_2.append(node.right)
        while stack_2:
            print(stack_2.pop(0).data)


if __name__ == '__main__':
    list=[0,1,2,3,4,5,6,7,8,9,]
    tree=Tree()
    tree.createTree(list)
    tree.front_recursion(tree.root)
    print("\n")
    tree.middle_recursion(tree.root)
    print('\n')
    tree.behind_recursion(tree.root)
    print('\n')
    tree.front_queueAndStack(tree.root)
    print('\n')
    tree.middle_queueAndStack(tree.root)
    print('\n')
    tree.behind_queueAndStack(tree.root)
    print('\n')
    tree.level_queueAndStack(tree.root)