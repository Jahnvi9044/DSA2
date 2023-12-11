package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeRevesion {

    public static TreeNode<Integer> takeInputRecusively(Scanner sc)
    {   int data=sc.nextInt();
        TreeNode root=new TreeNode(data);
        System.out.println("Enter the no of children of"+root.data);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            root.children.add(takeInputRecusively(sc));
        }
        return root;

    }
    public static void printRecursively(TreeNode<Integer> root)
    {
        String st="";
        st=root.data+":";
        for(int i=0;i<root.children.size();i++)
        {
            st=st+" "+root.children.get(i).data;

        }

        System.out.println(st);
        for(int i=0;i<root.children.size();i++)
        {
            printRecursively(root.children.get(i));
        }


    }
    public static TreeNode<Integer> takeInputLevelWise(Scanner sc)
    {   int data=sc.nextInt();

        TreeNode<Integer> root=new TreeNode<>(data);
        Queue<TreeNode<Integer>> child=new LinkedList();
        child.add(root);

        while(!child.isEmpty())
        {   TreeNode<Integer> front=child.poll();
            System.out.println("Enter the no. of children of "+front.data);
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                int childdata=sc.nextInt();
                TreeNode<Integer> ch=new TreeNode<>(childdata);
                child.add(ch);
                front.children.add(ch);


            }
        }



        return root;
    }
    public static void  printLevelWise(TreeNode<Integer> root )
    {
        Queue<TreeNode<Integer>> pending =new LinkedList<>();
        pending.add(root);
        TreeNode<Integer> nullNode=new TreeNode<>(Integer.MIN_VALUE);
        pending.add(nullNode);
        System.out.println(root.data);
        while(pending.size()!=1)
        {
             TreeNode<Integer> front=pending.poll();
             if(front==nullNode)
             {   pending.add(nullNode);
                 System.out.println();
             }
             int n= front.children.size();
             for(int i=0;i<n;i++)
             {
                 System.out.print(front.children.get(i).data+" ");
                 pending.add(front.children.get(i));
             }

        }

    }




    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
//         TreeNode<Integer> root=takeInputRecusively(sc);
//         printRecursively(root);

         TreeNode<Integer> root1=takeInputLevelWise(sc);
         printLevelWise(root1);




    }
}
