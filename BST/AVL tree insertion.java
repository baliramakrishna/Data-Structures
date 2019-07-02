/*package whatever //do not write package name here */

import java.io.*;

class AvlTree{
    
    Node root;
   static  class Node{
    
     int data;
     int height;
     Node left;
     Node right;
     
     Node(int data){
         this.data=data;
         this.height=1;
     }
     
    }
    
    int height(Node root){
        
        if(root==null)
        return 0;
        else
        return root.height;
    }
    
    Node leftRotate(Node root){
        
        Node x=root.right;
        Node temp=x.left;
        x.left=root;
        root.right=temp;
        
        root.height=1+Math.max(height(root.left),height(root.right));
        x.height=1+Math.max(height(x.left),height(x.right));
        
        return x;
        
    }
    
    Node rightRotate(Node root){
        
        Node x=root.left;
        Node temp=x.right;
        x.right=root;
        root.left=temp;
        
         root.height=1+Math.max(height(root.left),height(root.right));
        x.height=1+Math.max(height(x.left),height(x.right));
        
        return x;
        
    }
    
    Node insert(Node root,int x){
        
        if(root==null)
        return new Node(x);
        else if(root.data<x)
        root.right=insert(root.right,x);
        else
        root.left=insert(root.left,x);
        
        root.height=1+Math.max(height(root.left),height(root.right));
        
        int balance=height(root.left)-height(root.right);
        
        if(balance>1 ){
            
            //left left
            if(height(root.left.left)>height(root.left.right))
            root=rightRotate(root);
            else{
                root.left=leftRotate(root.left);
                root=rightRotate(root);
            }
            
        }else if(balance<-1){
            
            
            if(height(root.right.right)>height(root.right.left))
            root=leftRotate(root);
            else{
                root.right=rightRotate(root.right);
                root=leftRotate(root);
            }
        }
        
        return root;
        
        
    }
    
    
    void preOrder(Node root){
        
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	public static void main (String[] args) {
       
       
      AvlTree t=new AvlTree();
      t.root=t.insert(t.root,1);
      t.root=t.insert(t.root,2);
      t.root=t.insert(t.root,3);
      t.root=t.insert(t.root,6);
      t.root=t.insert(t.root,5);
      t.root=t.insert(t.root,-2);
      t.root=t.insert(t.root,-5);
      t.root=t.insert(t.root,8);
      t.preOrder(t.root);
     
       
       
       
       
	}
}
