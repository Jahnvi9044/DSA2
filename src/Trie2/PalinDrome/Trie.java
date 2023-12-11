package Trie2.PalinDrome;

import java.util.*;



/*
Palindrome Pair

Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word,
 which itself is a palindrome or not.

Note: The function should return either true or false. You don't have to print anything.
Input Format :
The first line of the test case contains an integer value denoting 'n'.

The following contains 'n' number of words each separated by a single space.
Output Format :
The first and only line of output contains true if the conditions described in the task are met and false otherwise.
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome
Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.'
 */
class TrieNode {


    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    boolean Rest_Palindrome , Ending;


    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
        Rest_Palindrome=false;
        Ending=false;
    }
}

public class Trie {

    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }


    //        insert()       >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            root.Ending=true;
            return;
        }
        if(isPalindrome(word.substring(1)))
            root.Rest_Palindrome=true;


        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    private boolean isPalindrome(String st){
        for(int i=0;i<st.length()/2;i++)
        {
            if(st.charAt(i)!=st.charAt(st.length()-i-1))
                return false;
        }
        return true;

    }

    public void add(String word){
        add(root, word);
    }


    //        search()          >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private boolean search(TrieNode root, String word) {

        if(word.length()==0)
        {
//                case 1
            if(root.Ending==true)
                return true;

//                case 2
            else if(root.Rest_Palindrome==true)
                return true;


            else
                return false;


        }

        int childIndex=word.charAt(0) - 'a';
        TrieNode child=root.children[childIndex];


        if(child == null) {
            return false;
        }



//               case 3

        if(child.Ending && isPalindrome(word.substring(1)))
            return true;










        return search(child,word.substring(1));

    }

    public boolean search(String word) {
        return search(root,word);
    }

    private void print(TrieNode root, String word){
        if (root == null) {
            return;
        }
        if (root.isTerminating) {
            System.out.println(word);
        }
        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }


    /*..................... Palindrome Pair................... */


    public boolean isPalindromePair(ArrayList<String> words) {
        //Your code goes here
        boolean flag=false;
        for(String st:words)
        {
            add((new StringBuffer(st)).reverse().toString());

            if(isPalindrome(st)==true)
                return true;

        }

        for(String st:words)
        {
            return search(st);
        }

        return false;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        List<String> arr=Arrays.asList("abc","mcba");
        boolean b=trie.isPalindromePair(new ArrayList<>(arr));
        System.out.println(b);

    }



}