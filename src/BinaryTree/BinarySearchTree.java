package BinaryTree;

import java.sql.SQLOutput;
import java.util.*;

public class BinarySearchTree {
    public static ArrayList<Integer> arr;
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n)
    {
        return makeBST(arr,0,n-1);

    }

    public static BinaryTreeNode<Integer> makeBST(int[] arr,int start,int end)
    {
        if(start>end)
            return null;
        else
        {
            int mid=start+(end-start)/2;
            BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[mid]);
            root.left=makeBST(arr, start,mid-1);
            root.right=makeBST(arr,mid+1,end);
            return root;
        }
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST1(int[] arr, int n)
    {
        if(n==0)
            return null;
        int j=(n-1)/2;
        BinaryTreeNode<Integer>  root=new BinaryTreeNode<>(arr[j]);

        int[] arr1 = new int[j];
        int k = 0;
        for (int i =0; i < j; i++) {
            arr1[k] = arr[i];
            k++;
        }

        BinaryTreeNode<Integer>  left=SortedArrayToBST1(arr1,j);
        root.left=left;
        int[] arr2=new int[n-(j+1)];
        k=0;
        for(int i=j+1;i<n;i++)
        {arr2[k]=arr[i];
            k++;}

        BinaryTreeNode<Integer> right=SortedArrayToBST1(arr2,n-j-1);
        root.right=right;

        return root;


    }
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> pending=new LinkedList<>();
        pending.add(root);
        String s="";
        while(!pending.isEmpty())
        {
            BinaryTreeNode<Integer> front=pending.poll();
          s=s+front.data+" ";

            if(front.left!=null)
            {
                pending.add(front.left);
            }

            if(front.right!=null)
            {
                pending.add(front.right);
            }


        }
        System.out.println(s);

    }

    public static void printLinkedList(LinkListNode<Integer> head)
    {
        LinkListNode<Integer> temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;

        }

    }

    public static LinkListNode<Integer> convert(BinaryTreeNode<Integer> root)
    { return  convert1(root).head;

    }
    public static Pair2<LinkListNode<Integer>> convert1(BinaryTreeNode<Integer> root)
    {  if(root==null)
       {
        Pair2<LinkListNode<Integer>> ans=new Pair2<>();
        ans.head=null;
        ans.tail=null;
        return ans ;
      }

       Pair2<LinkListNode<Integer>> left=convert1(root.left);
        LinkListNode<Integer> temp=new LinkListNode<>(root.data);

        if(left.tail==null&& left.head!=null) left.tail=left.head;
        else if(left.head!=null&&left.tail!=null) left.tail=left.tail.next;
        else if(left.head==null&& left.tail==null && root!=null) left.head=left.tail=temp;

        left.tail.next=temp;
        Pair2<LinkListNode<Integer>> right=convert1(root.right);

        if(right.tail==null&& right.head!=null) right.tail=right.head;
        else if(right.head!=null&&right.tail!=null) right.tail=right.tail.next;
        else if(right.head==null&& right.tail==null && root!=null) right.head=right.tail=temp;
        temp.next=right.head;
        right.tail.next=right.tail.next.next;
        Pair2<LinkListNode<Integer>> ans=new Pair2<>();
        ans.head=left.head;
        ans.tail=left.tail;
        return ans ;


    }

    public static ArrayList<Integer> getRootTodataPath(BinaryTreeNode<Integer> root,int data)
    {
        if(root==null)
        return null;

        if(root.data==data)
        {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftop=getRootTodataPath(root.left,data);
        if(leftop!=null)
        {   leftop.add(root.data);
            return leftop;
        }
        ArrayList<Integer> rightop=getRootTodataPath(root.right,data);
        if(rightop!=null)
        {   rightop.add(root.data);
            return rightop;
        }
        else
            return null;

    }
    private  static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
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
    private static BinaryTreeNode<Integer> deleteDatahelper(BinaryTreeNode<Integer> root,int data)
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
    public  static int  getmin(BinaryTreeNode<Integer> root) {

        if (root == null)
            return Integer.MAX_VALUE;
        int min = root.data;
        min = Math.min(min,(Math.min(getmin(root.left), getmin(root.right))));
        return min;

    }
    private static  void print(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        String toBePrinted=root.data+"->";
        if(root.left!=null)
            toBePrinted+="L:"+root.left.data+" ";

        if(root.right!=null)
            toBePrinted+="R:"+root.right.data+" ";
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);


    }
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
       // ArrayList<Integer> arr=bstToArray(root);
      //replaceWithLargerNodesSumHelper(root,arr);

    }
   public  static void bstToArray(BinaryTreeNode<Integer> root)
    { if(root==null)
        return ;
     bstToArray(root.left);
     if(root!=null)
       arr.add(root.data);
        System.out.println(arr);
       bstToArray(root.right);


    }
//    public static void replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root,arr) {
//
//
//
//    }

    public static void main(String[] args) {
       BinaryTreeUse ob=new BinaryTreeUse();
       BinaryTreeNode<Integer> root=  ob.takeInputLevelWise();//10 20 30 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//       ob.printLevelWise(root);
//       System.out.println("/////////////////////////////////");
//        printLevelWise(deleteDatahelper(root,30));
//        ob.printLevelWise(root);
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//       printLevelWise(insertHelper(root,25));
//        printLevelWise(insertHelper(root,40));
//        ob.printLevelWise(root);
//         print(root);
//        System.out.println("::::::::::::::::::::::::::::");
//       int[] arr={1,2,3,4,5,6,7,8};
//       ob.printLevelWise(SortedArrayToBST(arr,arr.length));
//       /** ANOTHER METHOD */
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//       printLevelWise(SortedArrayToBST1(arr,arr.length));
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//       // printLinkedList(convert(root));
//        System.out.println(getRootTodataPath(root,7));
          bstToArray(root);
        System.out.println(arr);
    }
}
