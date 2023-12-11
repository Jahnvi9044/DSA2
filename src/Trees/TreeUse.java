package Trees;

import BinaryTree.BinaryTreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeUse {
    public static TreeNode<Integer> takeinput(Scanner sc)//recursive input
    {

        // System.out.println("Enter node data");
        int data=sc.nextInt();
        TreeNode<Integer> root=new TreeNode<>(data);
        //System.out.println("Enter No. of  children");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            TreeNode<Integer> child=takeinput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> takeInput(Scanner sc)//level vise
    {   int data=sc.nextInt();
        TreeNode<Integer> root=new TreeNode<>(data);
        Queue<TreeNode<Integer>> pendingNodes=new LinkedList<TreeNode<Integer>>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()) {
            TreeNode<Integer> frontNode = pendingNodes.poll();
            //System.out.println("No. of children of " + frontNode.data);
            int num = sc.nextInt();
            for (int i = 0; i < num; i++)
            {
                int d = sc.nextInt();
                TreeNode<Integer> child = new TreeNode<>(d);
                frontNode.children.add(child);
                pendingNodes.add(child);
            }

        }
        return root;
    }
    public static void printlevelwise(TreeNode<Integer> root)
    {   Queue<TreeNode<Integer>> pending=new LinkedList<>();
        Queue<TreeNode<Integer>> child=new LinkedList<>();
        pending.add(root);
        System.out.println(root.data);
        String s="";
        while(!pending.isEmpty())
        {
            TreeNode<Integer> front=pending.poll();
            int num= front.children.size();
            for(int i=0;i<num;i++)
            {   s=s+front.children.get(i).data+" ";
                child.add(front.children.get(i));
            }
           if(pending.isEmpty())
           {
               System.out.println(s);
               s="";
             Iterator it=child.iterator();
             while(it.hasNext())
             {
                 pending.add((TreeNode<Integer>) it.next());
             }
               //System.out.println(pending);
               //System.out.println(child);
               child.clear();
               //System.out.println(child);
               // child=new LinkedList<>();
               //System.out.println(pending);
               //10 3 20 30 40 2 5 15 1 25 1 35 2 1 2 1 2 2 3 5 3 6 7 8 0 0 0 0 0 0 0 0 try this as input
           }
        }

    }
    public static int getHeight(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> pending=new LinkedList<>();
        Queue<TreeNode<Integer>> child=new LinkedList<>();
        pending.add(root);
        int count=0;
        while(!pending.isEmpty())
        {
            TreeNode<Integer> front=pending.poll();
            int num= front.children.size();
            for(int i=0;i<num;i++)
            {
                child.add(front.children.get(i));
            }
            if(pending.isEmpty())
            {  count++;
                pending=child;
                child=new LinkedList<>();
            }

        }
        return count;
    }

    public static void print(TreeNode<Integer> root) {
        String s=root.data+":";
        for(int i=0;i<root.children.size();i++)
        {
           s=s+root.children.get(i).data+',';
        }
        System.out.println(s);

        for(int i=0;i<root.children.size();i++)
        {
            print(root.children.get(i));
        }

    }

    public static int  numgreaterthanx(TreeNode<Integer> root,int x) {
        int count=0;
        if(root==null)
            return 0;
        if(root.data>x)
            count++;
        for(TreeNode<Integer> a:root.children)
        {
            count+=numgreaterthanx(a,x);

        }
        return count;
    }

    public static int Height(TreeNode<Integer> root)
    {
        int height=0;
        if(root==null)
            return 0;
        for(int i=0;i<root.children.size();i++)
        {int childheigth=Height(root.children.get(i));
            if(height<childheigth)
            {
                height=childheigth;
            }

        }
        return height+1;

    }

    public static void printdepthnode(TreeNode<Integer> root,int k) {
        if(k<0)
            return ;
        if(k==0) {
            System.out.print(root.data+" ");
            return;
        }
        for(int i=0;i<root.children.size();i++)
        {
            printdepthnode(root.children.get(i),k-1 );
        }

    }

    public static int  NoOfLeaf(TreeNode<Integer> root ) {
        if(root==null)//Corner Case
            return 0 ;
        int leaf=0;
        if(root.children.size()==0)
        {leaf++;

        }
        for(int i=0;i<root.children.size();i++){
            leaf+=NoOfLeaf(root.children.get(i));
        }
        return leaf;
    }
//    public static TreeNode<Integer> remove(TreeNode<Integer> root)
//    {
//        if(root==null)
//            return null ;
//        //if root is a leaf //Corner case
//        if(root.left==null&&root.right==null)
//        {  return null;}
//
//        root.left=  remove(root.left);
//        root.right= remove(root.right);
//        return root;
//
//    }
static TreeNode<Integer> removeLeaf(TreeNode<Integer> root)
{   if(root==null){ return null;}// if root is null return null
    if(root.children.size()==0){// if root itself is leaf return null
        return null;}
    for (int i = 0; i < root.children.size(); i++) {

        TreeNode<Integer> child=root.children.get(i);

        // if it is  a leaf
        if (child.children.size() == 0) {


            for (int j = i; j < root.children.size() - 1; j++)
                root.children.set(j, root.children.get(j + 1));

            root.children.remove(root.children.size()-1);

            i--;
        }
    }

    for (int i = 0;
         i < root.children.size();
         i++) {

        // call function for root.children
        root.children.set(i,removeLeaf(root.children.get(i)));
    }
    return root;
}


    public static void postOrder(TreeNode<Integer> root) {
        if(root==null)
            return ;
        for(int i=0;i<root.children.size();i++)
        {
            postOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

    public static void preOrder(TreeNode<Integer> root) {
        if(root==null)
            return ;
        System.out.print(root.data+" ");
        for(int i=0;i<root.children.size();i++)
        {
            preOrder(root.children.get(i));
        }

    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root==null)
            return false;
        Queue<TreeNode<Integer>> pending=new LinkedList<>();
        pending.add(root);
        while(!pending.isEmpty())
        {
            TreeNode<Integer> front=pending.poll();
            int num=front.children.size();
            for(int i=0;i<num;i++)
            {   if(front.children.get(i).data==x)
                return true;
                pending.add(front.children.get(i));

            }
        }
        return false;


        // Write your code here

    }

    public static boolean checkIfContainsXRecursion(TreeNode<Integer> root, int x){
        if(root==null)
            return false;

        if (root.data == x)
            return true;
        for(int i=0;i<root.children.size();i++)
        {
            if(checkIfContainsXRecursion(root.children.get(i),x))
                return true;

        }
        // Write your code here
        return false;
    }


    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        if(root==null)
            return null;
        Queue<TreeNode<Integer>> pending=new LinkedList<>();

        int sum=0;
        int max=0;
        TreeNode<Integer> maxn=root;
        pending.add(root);
        while(!pending.isEmpty())
        {   TreeNode<Integer> front=pending.poll();
            int num=front.children.size();
            for(int i=0;i<num;i++)
            {   sum+=front.children.get(i).data;
                pending.add(front.children.get(i));
            }

            if(sum>max)
            {   max=sum;
                maxn=front;
            }
            sum=0;

        }
        return maxn;

    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2)
    {
       ArrayList<Integer> arr1= preorder(root1);
        System.out.println(arr1);
        ArrayList<Integer> arr2= preorder(root2);
        System.out.println(arr2);
        int i=arr1.size()-1,j=arr2.size()-1;
        while(i!=0&&j!=0)
        { if(arr1.get(i)!=arr2.get(j))
            return false;
           if(arr1.get(i)==arr2.get(j))
           { i--;
             j--;
           }
        }
        if(i==0&&j==0)
            return true;
        else
            return false;
    }

    private static ArrayList<Integer> preorder(TreeNode<Integer> root1)
    {
           if (root1 == null)
               return null;
           ArrayList<Integer> arr = new ArrayList<>();
           arr.add(root1.data);
           for (int i = 0; i < root1.children.size(); i++)
           {
               ArrayList<Integer> child = preorder(root1.children.get(i));
               for (int j = 0; j < child.size(); j++)
                   arr.add(child.get(j));

           }
           return arr;
       }//Converts Tree to ArrayLsit
    private static int  findLargest(TreeNode<Integer> root)
    {

        int  max=0;
        if(root.data>max)
            max=root.data;
        for(int i=0;i<root.children.size();i++)
        {
            int  child=findLargest(root.children.get(i));

            if( max<child)
            {
                max=child;
            }
        }
        return max;
        // Write your code here

    }

    private static TreeNode<Integer> findjustLess(TreeNode<Integer> root,int max)
    {     int diff=Integer.MAX_VALUE;
        TreeNode<Integer> node=root;
        if(root.data<max)
        {
            if(diff>max-root.data)
            {
                diff=max-root.data;
                node=root;
            }
        }
        for(int i=0;i<root.children.size();i++)
        {
            TreeNode<Integer> child=findjustLess(root.children.get(i),max);
            if(child.data<max)
            {
                if(diff>max-child.data)
                {
                    diff=max-child.data;
                    node=child;
                }
            }
        }
        return node;

    }

    public static int CountNodes(TreeNode<Integer> root)
    {
        if(root==null)
            return 0;
          int count=1;//root;
        for(int i=0;i<root.children.size();i++)
        {
            count+=CountNodes(root.children.get(i));
        }
        return count;
    }


    public static void main(String[] args) {

        //  TreeNode<Integer> root= takeinput(new Scanner(System.in));
        TreeNode<Integer> root1= takeInput(new Scanner(System.in));
        // TreeNode<Integer> root2= takeInput(new Scanner(System.in));
        printlevelwise(root1);//10 3 20 30 40 2 5 15 1 25 1 35 2 1 2 1 2 2 3 5 3 6 7 8 0 0 0 0 0 0 0 0 use this
       // printlevelwise(root2);

       // System.out.println(preorder(root1));
       //  System.out.println(checkIdentical(root1,root2));


//        System.out.println(findLargest(root1));
//
//        System.out.println(findjustLess(root1,40).data);
//        System.out.println("No. of Nodes: " +CountNodes(root1));
//        printlevelwise(removeLeaf(root1));

        /*printlevelwise(root1);
        System.out.println("No.of nodes having data greater than 10:"+numgreaterthanx(root1,10));
        System.out.println("Height of the tree:"+Height(root1));
        System.out.print("Nodes at the depth of 2:");
        printdepthnode(root1,2);
        System.out.println();
        System.out.println("No.of Leafs in the tree:"+NoOfLeaf(root1));
        System.out.print("postOrder:");
        postOrder(root1);
        System.out.println();
        System.out.print("preOrder:");
        preOrder(root1);
        System.out.println();
        System.out.println(maxSumNode(root1).data);*/


//       TreeNode<Integer> root=new TreeNode<>(4);
//       TreeNode<Integer> node1=new TreeNode<>(2);
//       TreeNode<Integer> node2=new TreeNode<>(3);
//       TreeNode<Integer> node3=new TreeNode<>(6);
//       TreeNode<Integer> node4=new TreeNode<>(5);
//       root.children.add(node1);
//       root.children.add(node2);
//       root.children.add(node3);
//       node2.children.add(node4);
//        System.out.println(root);
//
        
    }
}
