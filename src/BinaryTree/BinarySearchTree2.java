package BinaryTree;

import java.util.*;

public class BinarySearchTree2 {
    private BinaryTreeNode<Integer> root;
    public void insert(int data) {
        //Implement the insert() function
       root= insertHelper(root, data);
    }
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;

        }
        if (root.data < data) {
            root.right = insertHelper(root.right, data);
            return root;
        } else if (root.data > data) {
            root.left = insertHelper(root.left, data);
            return root;
        } else// if(root.data==data)
        {
            root.left = insertHelper(root.left, data);
            return root;
        }

    }
//    public  void printLevelWise(BinaryTreeNode<Integer> root) {
//        if (root == null)
//            return;
//        Queue<BinaryTreeNode<Integer>> pending=new LinkedList<>();
//        pending.add(root);
//        String s="";
//        while(!pending.isEmpty())
//        {
//            BinaryTreeNode<Integer> front=pending.poll();
//            s=s+front.data+" ";
//
//            if(front.left!=null)
//            {
//                pending.add(front.left);
//            }
//
//            if(front.right!=null)
//            {
//                pending.add(front.right);
//            }
//
//
//        }
//        System.out.println(s);
//
//    }
    public void remove(int data)
    {
       root= deleteDatahelper(root,data);

    }
    private  BinaryTreeNode<Integer> deleteDatahelper(BinaryTreeNode<Integer> root,int data)
    {
        if(root==null)
            return null;
        if(root.data==data && root.left==null && root.right==null)
            root= null;
        else if(root.data==data && root.left==null)
            root= root.right;
        else if(root.data==data && root.right==null)
            root= root.left;
        else if(root.data>data)
            root.left= deleteDatahelper(root.left,data);
        else if(root.data<data)
            root.right=deleteDatahelper(root.right,data);

        else //if(root.data==data)
        {
            int replacement=  getmin(root.right);
            root.data=replacement;
            root.right= deleteDatahelper(root.right,replacement);

        }

        return root;

    }
    public  int  getmin(BinaryTreeNode<Integer> root) {

        if (root == null)
            return Integer.MAX_VALUE;
        int min = root.data;
        min = Math.min(min,(Math.min(getmin(root.left), getmin(root.right))));
        return min;

    }
    private  void print(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        String toBePrinted=root.data+":";
        if(root.left!=null)
            toBePrinted+="L:"+root.left.data+" ";

        if(root.right!=null)
            toBePrinted+="R:"+root.right.data+" ";
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);


    }
    public void printTree() {

        print(root);
    }


    private boolean hasDataHelper(BinaryTreeNode<Integer> root, int data)
    {
        if(root==null) return false;
        if(root.data==data) return true;
        else if(root.data<data) return  hasDataHelper(root.left,data);
        else return hasDataHelper(root.right,data);
    }
    public boolean search(int data)
    {
        return hasDataHelper(root,data);
    }

    public static void main(String[] args) {
        BinarySearchTree2 ob=new BinarySearchTree2();
        BinaryTreeUse ob1=new BinaryTreeUse();
        ob.insert(4);
        ob.insert(4);
        ob.insert(4);
        ob.insert(4);
        ob.printTree();
        ob.remove(4);
        ob.search(2);
        ob.printTree();

    }
}
  /** EXPLANATION FOR WHY WE DON'T USE <preorder successor> FOR FINDING REPLACEMENT
   *  The preorder traversal of a BST does not visit nodes in ascending order and therefore cannot be used to find
   *         the appropriate replacement node for a deleted node with both left and right children.


        In contrast, the inorder traversal of a BST visits nodes in ascending order, which makes it useful for
           finding the node with the smallest value in the right subtree of the deleted node.*/