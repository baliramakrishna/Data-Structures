/*package whatever //do not write package name here */

import java.util.*;

class BSTInsertion{
    
    Node root;
    
    class Node{
        
        int info;
        Node left;
        Node right;
        
        Node (int info){
            
            this.info=info;
            left=null;
            right=null;
        } 
        
    }
    
    void insert(int x){
        
       Node p=new Node(x);
       Node back;
       if(root==null){
       root=p;
       return;
       }
       
       Node q=root;
       back=q;
       
       while(q!=null){
           back=q;
           
           if(x<=q.info)
           q=q.left;
           else
           q=q.right;
           
       }
        
        if(back.info>=x)
        back.left=p;
        else
        back.right=p;
        
        
    }
    
    //1.node with no child(leaf Node)
    //2.node with one child
    //3.node with 2 children
    void delete(int x){
        
        Node p=root;
        Node back=p;
        
        while(p!=null && p.info!=x){
            back=p;
            if(x<=p.info)
            p=p.left;
            else
            p=p.right;
            
        }
        
        if(p==null)
        System.out.println("no such element exists");
        
        else{
            //case 1. if it is a leaf node
               if(p.left==null && p.right==null){
                
                if(back.left==p)
                back.left=null;
                else
                back.right=null;
                
                
               }
            
            //case 2.if it has one child
            
           else if(p.left==null|| p.right==null){
               
               if(p.left==null){
                   
                   if(back.left==p)
                   back.left=p.right;
                   else
                   back.right=p.right;
                   
               } else{
                   
                  if(back.left==p)
                  back.left=p.left;
                  else
                  back.right=p.left;
    
                }
               
           }
           
         else{
             
             Node q=p;
             q=q.left;
             back=q;
             while(q.right!=null){
                 
                 back=q;
                 q=q.right;
             }
             
             if(back==q){
                 p.info=q.info;
                 p.left=q.left;
             }else{
                 
                 p.info=q.info;
                 back.right=q.left;
             }
             
         }
        }    
        
    }
    
    
    void inorder(Node q){
        if(q!=null){
        
        inorder(q.left);
        System.out.print(q.info+" ");
        inorder(q.right);
            
        }
        
    }
    
    void preorder(Node q){
        if(q!=null){
          System.out.print(q.info+" ");  
          preorder(q.left);
          preorder(q.right);
        }
        
    }
    
    void postorder(Node q){
        
        if(q!=null){
            
            postorder(q.left);
            postorder(q.right);
            System.out.print(q.info+" ");  
            
        }
    }
    
    boolean search(int x){
        
        Node q=root;
        
        while(q!=null && q.info!=x){
         
         if(x<=q.info)
         q=q.left;
         else
         q=q.right;
         
        }
        
        if(q==null)
        return false;
        else
        return true;
        
    }
	public static void main (String[] args) {
		
		BSTInsertion b=new BSTInsertion();
		b.insert(45);
		b.insert(30);
		b.insert(90);
		b.insert(64);
		b.insert(32);
		b.insert(40);
		b.insert(48);
		b.inorder(b.root);
		System.out.println();
		b.preorder(b.root);
		System.out.println();
		b.postorder(b.root);
		System.out.println();
		System.out.println(b.search(32));
		System.out.println(b.search(30));
		System.out.println(b.search(29));
	    b.delete(48);
	    b.inorder(b.root);
	    System.out.println();
	    b.delete(32);
	    b.inorder(b.root);
	    System.out.println();
	    b.delete(45);
	    b.inorder(b.root);
	    System.out.println();
	    b.delete(29);
	    System.out.println();
		
		
	}
}
