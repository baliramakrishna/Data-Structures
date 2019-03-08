/*package whatever //do not write package name here */

// Java program to print boundary traversal of binary tree 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node { 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree { 
	Node root; 

	// A simple function to print leaf nodes of a binary tree 
	void printBoundary(Node node)
	{
		// Your code here
		if (node != null) { 
            System.out.print(node.data + " "); 
  
            // Print the left boundary in top-down manner. 
            printLeft(node.left); 
  
            // Print all leaf nodes 
            printLeaves(node.left); 
            printLeaves(node.right); 
  
            // Print the right boundary in bottom-up manner 
            printRight(node.right); 
        } 
	}
	
		void printLeft(Node root){
	    
	    if(root==null)
	    return;
	    if(root.left==null && root.right==null)
	    return;
	    
	    System.out.print(root.data+" ");
	    if(root.left!=null)
	    printLeft(root.left);
	    else
	    printLeft(root.right);
	    
	}
	void printLeaves(Node node) 
    { 
        if (node != null) { 
            printLeaves(node.left); 
  
            // Print it if it is a leaf node 
            if (node.left == null && node.right == null) 
                System.out.print(node.data + " "); 
            printLeaves(node.right); 
        } 
    } 
     void printRight(Node root){
        
        if(root==null)
        return;
        
        if(root.left==null && root.right==null)
        return;
        
        if(root.right!=null){
        System.out.print(root.right);
           System.out.print(root.data+" ");
        }
        else{
        System.out.print(root.left);
           System.out.print(root.data+" ");

        }
        
       
    }

	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14); 
		tree.root.right = new Node(22); 
		tree.root.right.right = new Node(25); 
		tree.printBoundary(tree.root); 
	} 
} 
