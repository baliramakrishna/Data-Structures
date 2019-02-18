/*package whatever //do not write package name here */

import java.util.*;

class NthPostOrder{
   
   static class Count{
       
       int count=0;
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
    
    void inorder(Node root){
        
        if(root==null)
        return;
        
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
    
    void nthPostOrder(Node root,int n,Count c){
        
        if(root==null)
        return ;
        
        nthPostOrder(root.left,n,c);
        
        nthPostOrder(root.right,n,c);
        (c.count)++;
        
         if(c.count==n){
        System.out.println(root.data);
        return;
         }
        
    }
	public static void main (String[] args) {
		
		NthPostOrder x=new NthPostOrder();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
// 		x.inorder(x.root);
      for(int i=1;i<=6;i++)
		x.nthPostOrder(x.root,i,new Count());
		
	}
}
