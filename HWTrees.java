//This code was adopted from Data Structures and Algorithms in Java / Edition 2 by Robert Lafore
// tree.java
// demonstrates binary search tree

//HW 4 QUESTIONs: provide the implementation of the methods below + TEST all your methods in the main by using the menu in the main (see main method)
//Make sure your code works (either compiled in command line (terminal) or in Eclipse. 



import java.io.*;
import java.util.*;               // for Stack class if needed
////////////////////////////////////////////////////////////////
class Node
   {
   public int iData;              // data item (key)
   public double dData;           // data item
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   }  // end class Node  
////////////////////////////////////////////////////////////////
class Tree
   {
   private Node root;             // first node of tree

// -------------------------------------------------------------
   public Tree()                  // constructor
      { root = null; }            // no nodes in tree yet
// -------------------------------------------------------------
   public Node find(int key)      // find node with given key
      {                           // (assumes non-empty tree)
         Node current = root;

         while (current != null) {
            if (current.iData == key)
               return current;
            else if (key < current.iData)
               current = current.leftChild;
            else
               current = current.rightChild;
         }
         return null;
         // found it
      }  // end find()
// -------------------------------------------------------------
   public void insert(int id, double dd) //this method inserts a node of (id and dd) into the tree. (We are consider a BINARY SEARCH TREE by iData)
      {
         Node newNode = new Node();
         newNode.iData = id;
         newNode.dData = dd;

         if (root == null) {
            root = newNode;
            return;
         }

         Node current = root;

         while (current != null)
         {
            if (id < current.iData) {
                  if (current.leftChild == null) {
                     current.leftChild = newNode;
                     return;
                  }
                  current = current.leftChild;
            }
            else {
                  if (current.rightChild == null) {
                     current.rightChild = newNode;
                     return;
                  }
                  current = current.rightChild;
            }
         }
      }  // end insert()
//////////////////////////////////////////////////////

   public void traverse(int traverseType) //this method is full implemented see below 
      {
       switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot) //implement preOrder traversal
      {
     

      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot) //implement in Order traversal
      {
     


      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot) //implement postOrder traversal
      {
  
      }


///////////////////////////////////////////////////////////////
    private void isBST(Node localRoot) //this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
    {
   
    } 

// -------------------------------------------------------------
   public boolean delete(int key) // delete node with given key (iData) (if there are multiple nodes match key with iData you have to delete all of them.
      {                           // (assumes non-empty list)
         boolean found = false;
      
         while (find(key) != null) {
            found = true;
      
            Node current = root;
            Node parent = null;
            boolean isLeftChild = false;
      
            // find
            while (current != null && current.iData != key) {
               parent = current;
            
               if (key < current.iData) {
                  isLeftChild = true;
                  current = current.leftChild;
               }
               else {
                  isLeftChild = false;
                  current = current.rightChild;
               }
            }
      
            // case 1, leaf
            if (current.leftChild == null && current.rightChild == null) {
               if (current == root) {
                  root = null;
               }
               else if (isLeftChild) {
                  parent.leftChild = null;
               }
               else {
                  parent.rightChild = null;
               }
            }
      
            // case 2, left child only
            else if (current.rightChild == null) {
               if (current == root) {
                  root = current.leftChild;
               }
               else if (isLeftChild) {
                  parent.leftChild = current.leftChild;
               }
               else {
                  parent.rightChild = current.leftChild;
               }
            }
      
            // case 3, right child only
            else if (current.leftChild == null) {
               if (current == root) {
                  root = current.rightChild;
               }
               else if (isLeftChild) {
                  parent.leftChild = current.rightChild;
               }
               else {
                  parent.rightChild = current.rightChild;
               }
            }
      
            // case 4, two children
            else {
               Node u = current;
               Node v = current.rightChild;
      
               while (v.leftChild != null) {
                  u = v;
                  v = v.leftChild;
               }
      
               current.iData = v.iData;
               current.dData = v.dData;
      
               if (u == current) {
                  u.rightChild = v.rightChild;
               }
               else {
                  u.leftChild = v.rightChild;
               }
            }
         }
      
         return found;
      }  // end delete()

// -------------------------------------------------------------
   public void displayTreeLevels() // this method will display the nodes at each level in the tree. (The method should print the nodes (id) as: Level1:.... - Level2:... 
      {
      






      }  // end displayTreeLevels()




// -------------------------------------------------------------

  public void displaymyChilds(int id, double dd) //given a node who idata is id and dd is ddata display it childen in the following way:
  {

    //Left child: idata:  dData: 
    //Right child: idata: dData: 

    //if the node does not have children you display message that the nodes Do not have children. 
    // or if one of the child is null, then you display a message stating that. 


  }


// -------------------------------------------------------------

public void displayLeaves() //this method will display all the leaves (iData and dData) of all the leaves)
  {

    


  }


// -------------------------------------------------------------



}  // end class Tree


////////////////////////////////////////////////////////////////
class HWTrees
   {
   public static void main(String[] args) throws IOException
      {

      //You can modify this code of the main as much as you want - as longs as  ALL the methods above are being tested and called. 


      int value;

      Tree theTree = new Tree();

       //... you change these inputs to build the tree, and/or can add other inputs to test the program. 
      //The tree is ordered by iData.  


      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);
     
      /*

      Menu:

      1. Traverse
      2. isBST 
      3. Delete 
      4. Display Tree by Levels
      5. Display my Childs
      6. Insert a New Node
      7. Display All the Leaves
   

      */
     

// -------------------------------------------------------------
   }  // end class TreeApp
////////////////////////////////////////////////////////////////
