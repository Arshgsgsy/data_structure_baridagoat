//This code was adopted from Data Structures and Algorithms in Java / Edition 2 by Robert Lafore
// tree.java
// demonstrates binary search tree

//HW 4 QUESTIONs: provide the implementation of the methods below + TEST all your methods in the main by using the menu in the main (see main method)
//Make sure your codeworks (either compiled in command line (terminal) or in Eclipse. 



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
   public Node getRoot()          // for calling isBST(root) from main (root is private)
      { return root; }
// -------------------------------------------------------------
   public Node find(int key)      // find node with given key
      {                           // (assumes non-empty tree)
      


                  // found it
      return null;
      }  // end find()
// -------------------------------------------------------------
   public void insert(int id, double dd) //this method inserts a node of (id and dd) into the tree. (We are consider a BINARY SEARCH TREE by iData)
      {
         





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
    public void isBST(Node localRoot) //this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
    {
   
    } 

// -------------------------------------------------------------
   public boolean delete(int key) // delete node with given key (iData) (if there are multiple nodes match key with iData you have to delete all of them.
      {                           // (assumes non-empty list)
      

                    






      return false;
      }  // end delete()

// -------------------------------------------------------------
public void displayTreeLevels() {
   if (root == null) {
       System.out.println("Tree is empty.");
       return;
   }
   
   Queue<Node> queue = new LinkedList<>();
   queue.add(root); 
   int level = 1;

   while (!queue.isEmpty()) {
       int nodesInCurrentLevel = queue.size(); 
       System.out.print("Level" + level + ": ");
       
     
       for (int i = 0; i < nodesInCurrentLevel; i++) {
           Node current = queue.poll(); 
           System.out.print(current.iData + " ");
           
           // 
           if (current.leftChild != null) queue.add(current.leftChild);
           if (current.rightChild != null) queue.add(current.rightChild);
       }
       System.out.print(" - "); 
       level++;
   }
   System.out.println(); 
 }  // end displayTreeLevels()




// -------------------------------------------------------------

public void displaymyChilds(int id, double dd) {
   Node target = findNodeByIdAndDd(root, id, dd);

   if (target == null) {
       System.out.println("Node not found.");
       return;
   }

   if (target.leftChild == null && target.rightChild == null) {
       System.out.println("The node does not have children.");
       return;
   }

   if (target.leftChild != null) {
       System.out.println("Left child: idata: " + target.leftChild.iData + " dData: " + target.leftChild.dData);
   } else {
       System.out.println("Left child is NULL.");
   }

   if (target.rightChild != null) {
       System.out.println("Right child: idata: " + target.rightChild.iData + " dData: " + target.rightChild.dData);
   } else {
       System.out.println("Right child is NULL.");
   }
}

private Node findNodeByIdAndDd(Node localRoot, int id, double dd) {
   if (localRoot == null) {
       return null;
   }

   if (localRoot.iData == id && Math.abs(localRoot.dData - dd) < 1e-9) {
       return localRoot;
   }

   Node leftResult = findNodeByIdAndDd(localRoot.leftChild, id, dd);
   if (leftResult != null) {
       return leftResult;
   }

   return findNodeByIdAndDd(localRoot.rightChild, id, dd);
}


// -------------------------------------------------------------

// -------------------------------------------------------------
public void displayLeaves() // this method will display all the leaves (iData and dData)
{
    if (root == null) {
        System.out.println("The tree is empty, no leaves to display.");
        return;
    }
    
    System.out.print("Leaves found: ");
    findAndPrintLeaves(root); 
    System.out.println(); 
}

private void findAndPrintLeaves(Node localRoot) 
{
    if (localRoot == null) {
        return;
    }

    if (localRoot.leftChild == null && localRoot.rightChild == null) {
        System.out.print("[id: " + localRoot.iData + ", dd: " + localRoot.dData + "]  ");
    }

    findAndPrintLeaves(localRoot.leftChild);
    findAndPrintLeaves(localRoot.rightChild);
}
// -------------------------------------------------------------


// -------------------------------------------------------------



}  // end class Tree


////////////////////////////////////////////////////////////////
class HWTrees
   {
   public static void main(String[] args) throws IOException
      {

      //You can modify this code of the main as much as you want - as longs as  ALL the methods above are being tested and called. 

      Tree theTree = new Tree();
      Scanner input = new Scanner(System.in);

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

      boolean running = true;
      while (running)
         {
         System.out.println();
         System.out.println("Menu:");
         System.out.println("0. Exit");
         System.out.println("1. Traverse");
         System.out.println("2. isBST");
         System.out.println("3. Delete");
         System.out.println("4. Display Tree by Levels");
         System.out.println("5. Display my Childs");
         System.out.println("6. Insert a New Node");
         System.out.println("7. Display All the Leaves");
         System.out.print("Enter your choice: ");

         int choice = input.nextInt();

         switch (choice)
            {
            case 0:
               running = false;
               break;
            case 1:
               System.out.print("Enter 1=preorder, 2=inorder, 3=postorder, 4=find by key: ");
               int traverseType = input.nextInt();
               if (traverseType == 1 || traverseType == 2 || traverseType == 3)
                  theTree.traverse(traverseType);
               else if (traverseType == 4)
                  {
                  System.out.print("Enter key (iData) to find: ");
                  int findKey = input.nextInt();
                  Node found = theTree.find(findKey);
                  if (found == null)
                     System.out.println("Not found.");
                  else
                     System.out.println("Found: iData=" + found.iData + ", dData=" + found.dData);
                  }
               else
                  System.out.println("Invalid choice.");
               break;
            case 2:
               theTree.isBST(theTree.getRoot());
               break;
            case 3:
               System.out.print("Enter key (iData) to delete: ");
               int delKey = input.nextInt();
               theTree.delete(delKey);
               break;
            case 4:
               theTree.displayTreeLevels();
               break;
            case 5:
               System.out.print("Enter id (iData): ");
               int id = input.nextInt();
               System.out.print("Enter dd (dData): ");
               double dd = input.nextDouble();
               theTree.displaymyChilds(id, dd);
               break;
            case 6:
               System.out.print("Enter new id (iData): ");
               int newId = input.nextInt();
               System.out.print("Enter new dd (dData): ");
               double newDd = input.nextDouble();
               theTree.insert(newId, newDd);
               break;
            case 7:
               theTree.displayLeaves();
               break;
            default:
               System.out.println("Invalid choice.");
               break;
            }
         }

      input.close();
      System.out.println("Goodbye.");

// -------------------------------------------------------------
   }  // end main
}  // end class HWTrees
////////////////////////////////////////////////////////////////
