/*package whatever //do not write package name here */

import java.util.*;

class NthInorder{
   
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
    
    void nthInorder(Node root,int n,Count c){
        
        if(root==null)
        return ;
        
        nthInorder(root.left,n,c);
        (c.count)++;
        
         if(c.count==n){
        System.out.println(root.data);
        return;
         }
        nthInorder(root.right,n,c);
        
    }
	public static void main (String[] args) {
		
		NthInorder x=new NthInorder();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
// 		x.inorder(x.root);
      Count c=new Count();
		x.nthInorder(x.root,2,c);
		
	}
}
