/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   MaxSumRoot2Leaf{
   
   static class Sum{
       
       int sum=Integer.MIN_VALUE;
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
    
    
  int sum(Node root,Sum s){
      
      if(root==null)
      return 0;
      
      if(root.left==null && root.right==null)
      return root.data;
      
     int lm=sum(root.left,s);
     int rm=sum(root.right,s);
     
     s.sum=Math.max(s.sum,lm+rm+root.data);
     
     return lm+rm+root.data;
     
      
  }
  
 
  
    
	public static void main (String[] args) {
		
		MaxSumRoot2Leaf x=new MaxSumRoot2Leaf();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(-4);
		x.insert(5);
		x.insert(6);
		x.insert(7);
		x.insert(-8);
		x.insert(-9);
	   Sum s=new Sum();
       x.sum(x.root,s);
       System.out.println(s.sum);
	
   
		
	}
}
