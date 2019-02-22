/*package whatever //do not write package name here */
import java.util.*;

class   LeftLeaveSum{
   
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
    
   void sum(Node root,Sum s){
       
       if(root==null)
       return;
       if(root.left!=null){
           
           if(root.left.left==null && root.left.right==null)
           s.sum+=root.left.data;
       }else
       return;
       
       sum(root.left,s);
       sum(root.right,s);
       
       
   }
    
    
	public static void main (String[] args) {
		
		LeftLeaveSum x=new LeftLeaveSum();
		x.insert(20);
		x.insert(9);
		x.insert(49);
		x.insert(23);
		x.insert(52);
		x.insert(50);
		x.insert(5);
		x.insert(12);
		x.insert(12);
		Sum s=new Sum();
		x.sum(x.root,s);
		System.out.println(s.sum);
   
		
	}
}
