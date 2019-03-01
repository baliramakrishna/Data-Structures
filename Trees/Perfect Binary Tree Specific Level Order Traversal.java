/*package whatever //do not write package name here */

/*package whatever //do not write package name here */

import java.io.*;
class Node  
{ 
    int data; 
    Node left, right; 
  
    public Node(int data)  
    { 
        this.data = data; 
        left = right = null; 
    } 
} 
class BinaryTree{
    Node root; 
    
    void print(Node root){
        
        if(root==null)
        return;
        int l=0;
        Node p=root;
        while(p!=null){
            p=p.left;
            l++;
        }
       if(l==1){
       System.out.println(root.data);
       return;
       }
        for(int i=l;i>1;i--)
        printLevel(root.left,root.right,2,i);
        
        System.out.print(root.data);
    }
    
    void printLevel(Node root1,Node root2,int l,int k){
        
        
        if(root1==null && root2==null)
        return;
        if(l==k){
            System.out.print(root1.data+" "+root2.data+" ");
        }
        printLevel(root1.left,root2.right,l+1,k);
        printLevel(root1.right,root2.left,l+1,k);
        
    }
	public static void main (String[] args) {
	 BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
  
          tree.root.left.left  = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left  = new Node(6); 
        tree.root.right.right = new Node(7); 
   
        tree.root.left.left.left  = new Node(8); 
        tree.root.left.left.right  = new Node(9); 
        tree.root.left.right.left  = new Node(10); 
        tree.root.left.right.right  = new Node(11); 
        tree.root.right.left.left  = new Node(12); 
        tree.root.right.left.right  = new Node(13); 
        tree.root.right.right.left  = new Node(14); 
        tree.root.right.right.right  = new Node(15); 
   
        tree.root.left.left.left.left  = new Node(16); 
        tree.root.left.left.left.right  = new Node(17); 
        tree.root.left.left.right.left  = new Node(18); 
        tree.root.left.left.right.right  = new Node(19); 
        tree.root.left.right.left.left  = new Node(20); 
        tree.root.left.right.left.right  = new Node(21); 
        tree.root.left.right.right.left  = new Node(22); 
        tree.root.left.right.right.right  = new Node(23); 
        tree.root.right.left.left.left  = new Node(24); 
        tree.root.right.left.left.right  = new Node(25); 
        tree.root.right.left.right.left  = new Node(26); 
        tree.root.right.left.right.right  = new Node(27); 
        tree.root.right.right.left.left  = new Node(28); 
        tree.root.right.right.left.right  = new Node(29); 
        tree.root.right.right.right.left  = new Node(30); 
        tree.root.right.right.right.right  = new Node(31);
        
        tree.print(tree.root);
	}
}
