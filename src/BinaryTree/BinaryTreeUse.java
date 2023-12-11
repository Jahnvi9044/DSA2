package BinaryTree;


import java.util.*;

public class BinaryTreeUse {
    static  ArrayList<Integer> arr=new ArrayList<>();
    public static BinaryTreeNode<Integer> takeInput(Scanner sc){
      //  System.out.println("Enter data");
        int data=sc.nextInt();

        if(data==-1)
            return null;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
        root.left=takeInput(sc);
        root.right=takeInput(sc);
          return root;
    }
    public static BinaryTreeNode<Integer> takeInputLevelWise()
    {
        Scanner sc=new Scanner(System.in);
        int rootdata=sc.nextInt();
        if(rootdata==-1)
            return null;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
        Queue<BinaryTreeNode<Integer>> pending=new LinkedList<>();
        pending.add(root);

        while(!pending.isEmpty())
        {  BinaryTreeNode<Integer> front= pending.poll();
            System.out.println("Enter the left child of "+front.data);
            int leftdata=sc.nextInt();
            if(leftdata!=-1)
            {        BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<>(leftdata);
                     pending.add(leftChild);
                     front.left=leftChild;

            }

             System.out.println("Enter the right child of "+front.data);
             int rightdata=sc.nextInt();
             if(rightdata!=-1)
            {        BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<>(rightdata);
                     pending.add(rightChild);
                     front.right=rightChild;

            }


        }
        return root;

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> pending=new LinkedList<>();
        pending.add(root);

        while(!pending.isEmpty())
        {
            BinaryTreeNode<Integer> front=pending.poll();
            String s=front.data+" ";

            if(front.left!=null)
            {
                s+="L:"+front.left.data+" ";
                pending.add(front.left);
            }

            if(front.right!=null)
            {
                s+="R:"+front.right.data+" ";
                pending.add(front.right);
            }
            System.out.println(s);
            s="";

        }

    }


    public static void printLevel(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> pending=new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> child=new LinkedList<>();
        pending.add(root);
        System.out.println(root.data);
        while(!pending.isEmpty())
        {
            BinaryTreeNode<Integer> front=pending.poll();
            String s="";

            if(front.left!=null)
            {
                s+=front.left.data+" ";
                child.add(front.left);
            }

            if(front.right!=null)
            {
                s+=front.right.data+" ";
                child.add(front.right);
            }
            System.out.print(s);
            s="";
            if(pending.isEmpty())
            {
                Iterator it=child.iterator();
                while(it.hasNext())
                {
                    pending.add((BinaryTreeNode)it.next());
                }
                child.clear();
                System.out.println();
            }

        }

    }
    public static void print(BinaryTreeNode<Integer> root) {
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

    public static int CountNodes(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return 0;

        else {
           int count=0;
            count+= CountNodes(root.left);
            count+= CountNodes(root.right);
            return count+1;
        }
    }
    public static int Height(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return 0;
        int height=0;
        int h1=Height(root.left);
        int h2=Height(root.right);
        if(h1>height)
            height=h1;
        if(h2>height)
            height=h2;
        return height+1;
    }
    public static int Largest(BinaryTreeNode<Integer> root)
    {
        if( root==null)
        return -1;
        int max=root.data;
        int largestLeft=Largest(root.left);
        int largestRight=Largest(root.right);
        int d=Math.max(largestLeft,largestRight);
        if(max<d)
            max=d;
        return max;
    }
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x)
    {
        if(root==null)
            return 0;
        int count=0;
        if(root.data>x)
            count++;
        count+=countNodesGreaterThanX(root.left,x);
        count+=countNodesGreaterThanX(root.right,x);
        return count;

    }
    public static int NoOfLeafNode(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return 0;
        int count=0;
        if(root.left==null&&root.right==null)
            count++;
        count+=NoOfLeafNode(root.left);
        count+=NoOfLeafNode(root.right);
        return count;


    }
    public static void depthPrint(BinaryTreeNode<Integer> root, int k)
    {
          if(root==null)
              return ;

        if(k==0)
            System.out.print(root.data+" ");
        if(k<0)
            return ;

        depthPrint(root.left,k-1);
        depthPrint(root.right,k-1);

    }
    public static void changeToDepthTree(BinaryTreeNode<Integer> root,int k)
    {   if(root==null)
        return ;
        root.data=k;
        changeToDepthTree(root.left,k+1);
        changeToDepthTree(root.right,k+1);

    }
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here

        if(root==null)
            return ;

        if(root.left==null&&root.right!=null)
            System.out.print(root.right.data+" ");
            if(root.right==null&&root.left!=null)
            System.out.print(root.left.data+" ");
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);

    }

    public static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return null ;
        //if root is a leaf //Corner case
        if(root.left==null&&root.right==null)
        {  return null;}

      root.left=  remove(root.left);
       root.right= remove(root.right);
       return root;

    }
     public static boolean balanced(BinaryTreeNode<Integer> root)
     {    if(root==null)
         return false;
         int h1=Height(root.left);
         int h2=Height(root.right);
         if(Math.abs(h1-h2)<=1)
             return true;
         if(balanced(root.left) && balanced(root.right))
             return true;
         return false;

     }
       public static BalancedTreeReturn BalancedBetter(BinaryTreeNode<Integer> root)
       {  if(root==null)//base Case;
          {   int height=0;
              boolean isBal=true;
              BalancedTreeReturn ans=new BalancedTreeReturn();
              ans.isBalanced=isBal;
              ans.height=height;

            }

            BalancedTreeReturn lefttree=BalancedBetter(root.left);
            BalancedTreeReturn righttree=BalancedBetter(root.right);
            boolean isBal;
            int height=1+ Math.max(lefttree.height, righttree.height);
            if(lefttree.isBalanced && righttree.isBalanced)
                isBal=true;
            else
                isBal=false;
            BalancedTreeReturn ans=new BalancedTreeReturn();
            ans.height=height;
            ans.isBalanced=isBal;
            return ans;

       }

       public static DiameterOfTree Diameter(BinaryTreeNode<Integer> root)
       {
           if(root==null)
           {
               DiameterOfTree ans=new DiameterOfTree();
               ans.heightD=0;
               ans.diameter=0;
               return ans;
           }

           DiameterOfTree lefttree=Diameter(root.left);
           DiameterOfTree righttree=Diameter(root.right);
           int h=lefttree.heightD+righttree.heightD+1;//+1 because Nodes were taken into consideration
           int d=Math.max(h,Math.max(lefttree.diameter, righttree.diameter));
           DiameterOfTree ans=new DiameterOfTree();
           ans.heightD=Math.max(lefttree.heightD,righttree.heightD)+1;
           ans.diameter=d;
           return ans;

       }

       public static int diameter(BinaryTreeNode<Integer> root)
       {
           if(root==null)
           {
               return 0;}
               int option1=Height(root.left)+Height(root.right);
               int option2=diameter(root.left);
               int option3=diameter(root.right);
               return Math.max(option1,Math.max(option2,option3));


       }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return ;
        BinaryTreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");


    }
    public static void inOrder(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        postOrder(root.left);
        System.out.print(root.data+" ");
        postOrder(root.right);



    }


    public static BinaryTreeNode<Integer> buildTree(int[] preOrder,int[] inOrder,int InS,int InE,int PreS,int PreE)
    {if(InS>InE)
        return null;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(preOrder[PreS]);

        int rootindex=-1;
        for(int i=InS;i<=InE;i++)
        {
            if(preOrder[i]==root.data)
            {
                rootindex=i;
                break;
            }
        }
        if(rootindex==-1)
            return null;

        int leftInS=InS;
        int leftInE=rootindex-1;
        int leftPreS=PreS+1;
        int leftPreE=leftInE=leftInS+leftPreS;
        int rightInS=rootindex+1;
        int rightInE=InE;
        int rightPreS=leftPreE+1;
        int rightPreE=PreE;
        root.left=buildTree(preOrder,inOrder,leftInS,leftInE,leftPreS,leftPreE);
        root.right=buildTree(preOrder,inOrder,rightInS,rightInE,rightPreS,rightPreE);
        return root;

    }

    public static BinaryTreeNode<Integer> buildTree2(int[] postOrder,int[] inOrder,int InS,int InE,int PreS,int PreE)
    {if(InS>InE)
        return null;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(postOrder[PreE]);
        if (InS == InE)
            return root;
        int rootindex=-1;
        for(int i=InS;i<=InE;i++)
        {
            if(inOrder[i]==root.data)
            {
                rootindex=i;
                break;
            }
        }
        if(rootindex==-1)
            return null;

        int leftInS=InS;
        int leftInE=rootindex-1;
        int leftPreS=PreS;
        int leftPreE=leftInE-leftInS+leftPreS;

        int rightPreS=leftPreE+1;
        int rightPreE=PreE-1;
        int rightInS=rootindex+1;
        int rightInE=InE;
        root.right=buildTree2(postOrder,inOrder,rightInS,rightInE,rightPreS,rightPreE);
        root.left=buildTree2(postOrder,inOrder,leftInS,leftInE,leftPreS,leftPreE);

        return root;

    }
        public static void insertDuplicateNode(BinaryTreeNode<Integer> root)
        {

            if(root==null)
                return ;
            BinaryTreeNode<Integer> temp=root.left;
            BinaryTreeNode<Integer> dup=new BinaryTreeNode<>(root.data);
            root.left=dup;
            dup.left=root.left;
            dup.right=null;
            insertDuplicateNode(root.left);
            insertDuplicateNode(root.right);

        }
       public static Pair<Integer> isBST(BinaryTreeNode<Integer> root)
       {
           if(root==null)
           {   Pair<Integer> ans=new Pair<>();
               ans.max=Integer.MIN_VALUE;
               ans.min=Integer.MAX_VALUE;
               ans.chk=true;
               return ans ;
           }



           Pair<Integer> leftans=isBST(root.left);
           Pair<Integer> rightans=isBST(root.right);

           int max=Math.max(root.data,Math.max(leftans.max,rightans.max));
           int min=Math.min(root.data,Math.min(leftans.min,rightans.min));
                boolean b;
           if( leftans.max<root.data && rightans.min>=root.data && leftans.chk && rightans.chk)
           {
               b=true;
           }


           else
               b=false;
           Pair<Integer> ans=new Pair<>();
           ans.min=min;
           ans.max=max;
           ans.chk=b;
           return ans;

       }


    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtreeHelper(root).maxHeight;
    }
    public static Pair3 largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        if(root==null)  return new Pair3();
        Pair3 left=largestBSTSubtreeHelper(root.left);
        Pair3 right=largestBSTSubtreeHelper(root.right);
        Pair3 ans=new Pair3();

//        if(largestBSTSubtreeHelper(root.right).chk && largestBSTSubtreeHelper(root.left).chk)
//        {
//
//        }

        ans.min=Math.min(root.data,Math.min(left.min,right.min));
        ans.max=Math.max(root.data,Math.max(left.max,right.max));

        ans.chk=left.max<root.data && right.min>=root.data && left.chk && right.chk;
        if(ans.chk)
        {ans.maxHeight=Math.max(left.maxHeight,right.maxHeight)+1;

        }
        else {
            ans.maxHeight=Math.max(left.maxHeight, right.maxHeight);
        }
        return ans;

    }


    public static int getmax(BinaryTreeNode<Integer> root)
    {

        if(root==null)
            return Integer.MIN_VALUE ;
        int  max=root.data;
        max=Math.max(max,(Math.max(getmax(root.left),getmax(root.right))));
        return max;

    }

    public static int  getmin(BinaryTreeNode<Integer> root) {

        if (root == null)
            return Integer.MAX_VALUE;
        int min = root.data;
        min = Math.min(min,(Math.min(getmin(root.left), getmin(root.right))));
        return min;

    }
    public static boolean isBST1(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return true;


        if(root.left!=null&&getmax(root.left)>root.data)
            return false;

        if(root.right!=null&&getmin(root.right)<root.data)
            return false;
        boolean b1= isBST1(root.left);
        boolean b2=isBST1(root.right);
        if(b1&&b2)
            return true;
        else return false;


    }
   static  boolean isSibling(BinaryTreeNode<Integer> node, int  a, int  b)
    {
        // Base case
        if (node == null)
            return false;

        return ((node.left.data == a && node.right.data == b) ||
                (node.left.data == b && node.right.data == a) ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b));
    }
    public static int getLevelOfNode(BinaryTreeNode<Integer> root,int key,int level)
    {
        if(root==null)
            return 0;
        if(root.data==key)
            return level;

        int result=getLevelOfNode(root.left,key,level+1) ;
        if(result!=0)
        {
            // If found in left subtree , return
            return result;
        }
        result= getLevelOfNode(root.right,key,level+1);

        return result;
    }
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q)
    {
        if(root==null)
            return false;
        if(getLevelOfNode(root, p,0)==getLevelOfNode(root, q,0))
        { if(!isSibling(root , p, q))
            return true;
		else return false;}
        else return false;



    }


   static  void printPathsRecur(BinaryTreeNode<Integer> node, int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        arr.add( node.data);


        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null)
            printArray(pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, pathLen);
            printPathsRecur(node.right, pathLen);
        }
    }
   static  void printArray( int len)
    {
        int i;
        for (i = arr.size()-1;i>=0; i--)
            System.out.print(i + " ");
        System.out.println();
    }
    static void printPaths(BinaryTreeNode<Integer> node)
    {

        printPathsRecur(node, 0);
    }




    public static ArrayList<Integer> longestPath(BinaryTreeNode<Integer> root)
    {

        // If root is null means there
        // is no binary tree so
        // return a empty vector
        if(root == null)
        {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }

        // Recursive call on root.right
        ArrayList<Integer> right = longestPath(root.right);

        // Recursive call on root.left
        ArrayList<Integer> left = longestPath(root.left);

        // Compare the size of the two ArrayList
        // and insert current node accordingly
        if(right.size() < left.size())
        {
            left.add(root.data);
        }
        else
        {
            right.add(root.data);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left :right);
    }











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



    public  static void bstToArray(BinaryTreeNode<Integer> root)
    { if(root==null)
        return ;
        bstToArray(root.left);

            arr.add(root.data);

        bstToArray(root.right);


    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        Scanner sc = new Scanner(System.in);
        //root=takeInput(sc);//10 20 5 -1 -1 6 -1 -1 30 7 -1 -1 -1 try this input
        root = takeInputLevelWise();//10 20 30 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 try this input

        //print(root);
        printLevelWise(root);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        printLevel(root);
        System.out.println("No. of Nodes : " + CountNodes(root));
        System.out.println("Height of the tree is : " + Height(root));
        System.out.println("Largest Node: " + Largest(root));
        System.out.println("Count Nodes greater Than 20  : " + countNodesGreaterThanX(root, 20));
        System.out.println("No. of Leaf Nodes : " + NoOfLeafNode(root));
        System.out.println(isBST1(root));
        System.out.println(isBST(root).chk);
     System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
       printPaths(root);
//        System.out.println(isCousin(root,3,4));
//        //int[] arr={1,2,3,4,5,6,7,8};
//       printLevelWise(SortedArrayToBST(arr,arr.length));
//       /**  ANOTHER ARRAY  */
//       printLevelWise(SortedArrayToBST1(arr,arr.length));


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(largestBSTSubtree(root));
        bstToArray(root);
        System.out.println(arr);
        System.out.println(":::::::::::::::::::::::::::::::::::");
        ArrayList<Integer> k= longestPath(root);

//        //depthPrint(root,1);
//
//        //changeToDepthTree(root,0);
//        //printLevelWise(root);
//        System.out.println("Print node without siblings :");
//        printNodesWithoutSibling(root);
////        System.out.println("Remove the leafs :");
////        printLevelWise( remove(root));
//       // printLevelWise(root);
//        System.out.println();
//        System.out.println("The Tree is Balanced or not :"+balanced(root));
//
//        DiameterOfTree ans=new DiameterOfTree();
//        ans=Diameter(root);
//        System.out.println(ans.diameter);
//
////        mirrorBinaryTree(root);
////        printLevelWise(root);
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
////       int[] preorder={1,2,4,5,3,6,7};
////       int[] inorder={4,5,2,1,6,7,3};
////       printLevelWise(buildTree(preorder,inorder,0,inorder.length-1,0,preorder.length-1) );
////            //insertDuplicateNode(root);
//
////        int[] post={5 ,6 ,20, 7 ,30 ,10 };
////        int[] in={5 ,6 ,20 ,10 ,7 ,30 };
////        printLevelWise(buildTree2(post,in,0,in.length-1,0,post.length-1) );
////         //  printLevelWise(root);
////
//
//       /* 10 L:20 R:30
//        20 L:5 R:6
//        30 L:7
//        5
//        6
//        7
//
//        */
//        /*10 L:30 R:20
//        30 R:7
//        20 L:6 R:5
//        7
//        6
//        5 */
//
//
////        BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(100);
////        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(200);
////       root.left=node1;
////       root.right=node2;
////        System.out.println(root.data);
////
//    }//10 20 5 -1 -1 6 -1 -1 30 7 -1 -1 -1
    }}
