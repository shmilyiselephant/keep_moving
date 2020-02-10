package binarytree;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * @author shmilyiselephant
 * @date 09.02.20
 * @decription
 */
public class MyBinaryTree {
    static class TreeNode {
        public int data;
        public TreeNode leftNode;
        public TreeNode rightNode;
        public TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    private TreeNode root;

    public MyBinaryTree(int data) {
        this.root = new TreeNode(data);
    }

    public TreeNode find(int data) {
        if (root == null)
            return null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data > data) curr = curr.leftNode;
            else if (curr.data < data) curr = curr.rightNode;
            else return curr;
        }
        return null;
    }

    public int findMax(TreeNode root) {
        if (root == null) return 0;
        else if (root.rightNode == null) return root.data;
        else return findMax(root.rightNode);
    }

    public int findMin(TreeNode root) {
        if (root == null) return 0;
        else if (root.leftNode == null) return root.data;
        else return findMin(root.leftNode);
    }
    
    /**
     * 
     * @param data 
     * @return void
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 10.02.20 14:24
     */
    public void delete(int data) {
        TreeNode curr = root;
        TreeNode currPar = null; //parent of curr
        while (curr != null && curr.data != data) {
            currPar = curr;
            if (curr.data > data) curr = curr.leftNode; //move left
            else curr = curr.rightNode; //move right
        }

        if (curr == null) return; //the node is not found

        if (curr.leftNode != null && curr.rightNode != null) {
            TreeNode minNode = curr.rightNode; //search_root of the right_subtree
            TreeNode minNodePar = curr;
            while (minNode.leftNode != null) {
                minNodePar = minNode;
                minNode = minNode.leftNode;
            }
            curr.data = minNode.data;
            curr = minNode;
            currPar = minNodePar; //to_delete_node's parent -> minNode
        }

        //get child node of the node_to_delete
        TreeNode child;
        if (curr.leftNode != null) child = curr.leftNode;
        else if (curr.rightNode != null) child = curr.rightNode;
        else child = null;

        //delete the curr node
        if (currPar == null) root = child; //if parent if null, meaning the node_to_delete is root, so delete the root
        else if (currPar.leftNode == curr) currPar.leftNode = child; //if curr is the leftnode of the parent,
        else currPar.rightNode = child; //if curr is the rightnode of the parent
    }
    
    /**
     * 
     * @param data
     * @return void
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 10.02.20 14:24
     */
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode curr = root;
        TreeNode par = null;
        while (true) {
            par = curr;
            if (data > curr.data) {
                if (curr.rightNode == null) {
                    newNode.parent = par;
                    curr.rightNode = newNode;
                    break;
                }
                curr = curr.rightNode;
            } else {
                if (curr.leftNode == null) {
                    newNode.parent = par;
                    curr.leftNode = newNode;
                    break;
                }
                curr = curr.leftNode;
            }
        }
    }

    //max_node among minor nodes
    public TreeNode predecessor(int data) {
        TreeNode curr = find(data);
        if (curr.leftNode != null)
            return new TreeNode(findMax(curr.leftNode));
        TreeNode p = curr.parent;
        while (p != null && p.leftNode == curr) {
            curr = p;
            p = p.parent;
        }
        return p;
    }

    //min_node among the bigger nodes
    public TreeNode successor(int data) {
        TreeNode curr = find(data);
        if (curr.rightNode != null)
            return new TreeNode(findMin(curr.rightNode));
        TreeNode p = curr.parent;
        while (p != null && p.rightNode == curr) {
            curr = p;
            p = p.parent;
        }
        return p;
    }

    /**
     * 
     * @param root 
     * @return void
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 10.02.20 14:22
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + "->");
        if (root.leftNode != null) preOrder(root.leftNode);
        if (root.rightNode != null) preOrder(root.rightNode);
    }

    /**
     * 
     * @param root 
     * @return void
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 10.02.20 14:22
     */
    public void midOrder(TreeNode root) {
        if (root == null) return;
        if (root.leftNode != null) midOrder(root.leftNode);
        System.out.print(root.data + "->");
        if (root.rightNode != null) midOrder(root.rightNode);
    }

    /**
     * 
     * @param root 
     * @return void
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 10.02.20 14:22
     */
    public void backOrder(TreeNode root) {
        if (root == null) return;
        if (root.leftNode != null) backOrder(root.leftNode);
        if (root.rightNode != null) backOrder(root.rightNode);
        System.out.print(root.data + "->");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode tmp = q.peek();
                q.poll();
                list.add(tmp.data);
                if (tmp.leftNode != null) q.add(tmp.leftNode);
                if (tmp.rightNode != null) q.add(tmp.rightNode);
                count--;
            }
            res.add(list);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Random r = new Random();
        MyBinaryTree tree = new MyBinaryTree(r.nextInt(100));
        for (int i = 0; i < 10; i++ ) {
            tree.insert(r.nextInt(100));
        }
        tree.insert(6);
        System.out.println();
        tree.preOrder(tree.root);
        System.out.println();
        tree.midOrder(tree.root);
        System.out.println();
        tree.backOrder(tree.root);
        System.out.println();
        int index = r.nextInt(100);
        System.out.print(index + " found ");
        System.out.println(tree.find(index));
        tree.insert(index);
        System.out.println();
        tree.midOrder(tree.root);
        System.out.println();
        tree.delete(index);
        System.out.println();
        tree.insert(10);
        tree.midOrder(tree.root);
        System.out.println();
        System.out.println(tree.predecessor(10).data);
        System.out.println(tree.successor(10).data);
        System.out.println("max: " + tree.findMax(tree.root) + "\tmin: " + tree.findMin(tree.root));
        System.out.println(tree.levelOrder(tree.root));
    }
}

/*
    * 1. delele()解析
    * 结点初始化注意事项：该删除的结点的和该结点的父节点都要保留
    * 第一个while循环的作用：判断是否能找到待删除结点
    * 接下来的if,探讨有两个字节点时候的删除方式，此时重新初始化两个结点，一个为带删除结点的右子节点minNode，
    * 另一个为该子节点的父节点minNodePar,接下来的while循环一直向左迭代寻找最小结点，找到后将该结点的数据替换到待删除结点的位置，将该最小结点变成新的待删除结点！
    * 当待删除结点没有子节点时，直接删除，当待删除结点有一个子节点时，用子节点替代待删除结点
 */
