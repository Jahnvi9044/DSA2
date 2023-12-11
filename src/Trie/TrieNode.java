package Trie;

import java.util.*;

public class TrieNode {
   char data;
   boolean isTerminating;
   TrieNode children[];

   public TrieNode(char data)
   {
       this.data=data;
       isTerminating=false;
       children=new TrieNode[26];

   }
}

class Trie{

    private TrieNode root;

    public Trie(){

        root=new TrieNode('\0');
    }

      /*
      This class has 3 functions :
      1. add()
      2. search()
      3. remove()
      */


//    add()     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private void add(TrieNode root,String word)
    {
        if(word.length()==0)
        {
            root.isTerminating=true;
            return;
        }

        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];

        if(child==null)
        {
            child=new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
        }

        add(child,word.substring(1) );

    }

    public void add( String word){
        add(root,word);
    }




//    search()   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      public boolean search(String word)
      {
         return  search(root, word);

      }
      private  boolean search(TrieNode root,String word)
      {  if(word.length()==0)
         {
          if(root.isTerminating)
              return true;
          else
              return false;
         }
            int childIndex=word.charAt(0)-'a';
          TrieNode child= root.children[childIndex];
          if(child==null)
          {
              return false;
          }
          return search(child,word.substring(1));
      }


//      remove()     >>>>>>>>>>>>>>>>>>>>>>>>>>>>
      public void remove(String word)
      {    remove(root,word);

      }
      public void remove(TrieNode root, String word)
      {

      }




}

