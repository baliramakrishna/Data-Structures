/*package whatever //do not write package name here */

import java.util.*;

class Traversal{
    
    Node root;
    
    class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
        
    }
    
    void inorder(Node root){
        
        if(root==null)
        return;
        else{
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        
    }
    
     void preorder(Node root){
        
        if(root==null)
        return;
        else{
            System.out.print(root.data+" ");
            inorder(root.left);
            inorder(root.right);
        }
        
    }
    
    void postorder(Node root){
        
         if(root==null)
        return;
        else{
           
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data+" ");
        }
    }
    
    void levelorder(Node root){
        
        if(root==null)
        return;
        else{
            
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            
            while(!q.isEmpty()){
                
                Node temp=q.poll();
                System.out.print(temp.data+" ");
                
                if(temp.left!=null)
                q.add(temp.left);
                
                if(temp.right!=null)
                q.add(temp.right);
                
            }
            
            System.out.println();
        }
        
    }
    
    void insert(int x){
        
        Node p=new Node(x);
        if(root==null){
            root=p;
            return;
        }
        
        Queue<Node> q=new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node temp=q.poll();
            
            if(temp.left==null){
                temp.left=p;
                return;
            }else
            q.add(temp.left);
            
            if(temp.right==null){
                temp.right=p;
                return;
            }else
            q.add(temp.right);
            
        }
        
    }
	public static void main (String[] args) {
	  
	Traversal t=new Traversal();
	t.insert(10);
	t.insert(11);
	t.insert(12);
	t.insert(13);
	t.insert(14);
	t.insert(15);
	
	t.inorder(t.root);
	System.out.println();
	t.preorder(t.root);
	System.out.println();
	t.postorder(t.root);
	System.out.println();
	t.levelorder(t.root);
	
	
	  
	}
}
