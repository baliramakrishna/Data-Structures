/*package whatever //do not write package name here */

import java.util.*;

class   RightLeaveSum{
   
   static class Sum{
       
       int sum=0;
   }
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
        if(root==null){
            
            root=x;
            return;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node p=q.remove();
            
            if(p.left==null){
                
                p.left=x;
                return;
            }else q.add(p.left);
            
            if(p.right==null){
                p.right=x;
                return;
            }else q.add(p.right);
            
        }
        
    }
    
   int sum(Node root){
       
       if(root==null)
       return 0;
      
       int l=sum(root.left);
       int r=sum(root.right);
       int x=root.data;
       root.data=l+r;
       
      return l+r+x;
       
       
       
   }
    
    void inorder(Node root){
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }
	public static void main (String[] args) {
		
		RightLeaveSum x=new RightLeaveSum();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		x.insert(7);
	
		x.sum(x.root);
		x.inorder(x.root);
   
		
	}
}
