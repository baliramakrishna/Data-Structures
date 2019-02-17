/*package whatever //do not write package name here */

import java.io.*;

class InorderSuccessor{
    
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
    
  Node find(int x){
     Node p=root;
     
     if(root==null)
     return null;
     
     while(p.data!=x && p!=null){
         
         if(x<p.data)
         p=p.left;
         else
         p=p.right;
     }
     if(p==null)
     return null;
     else
     return p;
     
      
  }
Node inorderSuccessor(Node root,int x){
    
    if(root==null)
    return null;
    
    Node current=find(x);
    
    Node successor=null;
    //it has right node
    if(current.right!=null){
        
        current =current.right;
        
        while(current.left!=null)
        current=current.left;
        
        successor=current;
    }
    else{
        
        //deepest ancestor with given data as its left child
        
        Node ancestor=root;
        while(current!=ancestor){
            
            if(current.data<ancestor.data){
                successor=ancestor;
                 ancestor=ancestor.left;
                
            }
            else
                ancestor=ancestor.right;
        }
       
    }
    return successor; 
}



	public static void main (String[] args) {
		
		InorderSuccessor x=new InorderSuccessor();
		x.insert(5);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(8);
		x.insert(6);
		x.insert(9);
		x.insert(10);
		Node p=x.inorderSuccessor(x.root,8);
		System.out.println(p.data);
	}
}
