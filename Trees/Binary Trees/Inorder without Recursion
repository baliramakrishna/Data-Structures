/*package whatever //do not write package name here */

import java.util.*;

class InOrder {
    
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
    
    void inorder(){
        
        Node p=root;
        
        Stack<Node> s=new Stack<>();
        if(p==null)
        return;
        
        while(!s.isEmpty() || p!=null ){
           
           while(p!=null){
               
               s.push(p);
               p=p.left;
           }
           
           p=s.peek();
           s.pop();
           System.out.println(p.info+" ");
           p=p.right;
            
        }
    
        
        
        
    }
    
	public static void main (String[] args) {
		
		InOrder o=new InOrder();
		o.insert(100);
		o.insert(5);
		o.insert(67);
		o.insert(104);
		o.inorder();
		
	}
}
