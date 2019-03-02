/*package whatever //do not write package name here */
import java.io.*;
class Prev{
        int prev=Integer.MIN_VALUE;
    }
class BST{
    
    Node root;
    
    
    class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
        
    }
    
    void insert(int data){
        
        Node x=new Node(data);
        
        if(root==null)
        root=x;
        else{
           
           Node p=root;
           Node q=p;
           
           while(p!=null){
               q=p;
               if(data <=p.data)
               p=p.left;
               else
               p=p.right;
           }
            
            if(data<=q.data)
            q.left=x;
            else
            q.right=x;
        }
    }
    
  boolean inorder(Node root,Prev p){
      
      if(root==null)
      return true;
      
     boolean l= inorder(root.left,p);
     
     boolean b;
    
     if(l && root.data>=p.prev){
        p.prev=root.data;
        b=true;
     }else b=false;
   
     boolean r= inorder(root.right,p);
    
      return b&&r;
      
     
  }




	public static void main (String[] args) {
		
		BST x=new BST();
		x.insert(20);
		x.insert(8);
		x.insert(22);
		x.insert(4);
		x.insert(12);
		x.insert(10);
		x.insert(14);
	  System.out.println(x.inorder(x.root,new Prev()));
	  BST b=new BST();
	  b.root=b.new Node(3);
	  b.root.left = b.new Node(2); 
      b.root.right = b.new Node(5); 
      b.root.left.left  = b.new Node(1); 
      b.root.left.right = b.new Node(4);
      
      
       System.out.println(b.inorder(b.root,new Prev()));
	}
}
