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
    
   void sum(Node root,Sum s){
       
       if(root==null)
       return;
       if(root.right!=null){
           
           if(root.right.left==null && root.right.right==null){
           s.sum+=root.right.data;
           //System.out.println(root.right.data);
           }
       }
       
       sum(root.left,s);
       sum(root.right,s);
       
       
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
		x.insert(8);
		x.insert(9);
		Sum s=new Sum();
		x.sum(x.root,s);
		System.out.println(s.sum);
   
		
	}
}
