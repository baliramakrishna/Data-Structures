/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   Difference{
  
    Node root;
    
    static class Sum{
        int esum;
        int osum;
    }
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
    
    
    
     void sum(Node root,Sum s,int l){
         
         if(root==null)
         return ;
         
        if(l%2==1)
        s.osum+=root.data;
         
         if(l%2==0)
         s.esum+=root.data;
         
         sum(root.left,s,l+1);
         sum(root.right,s,l+1);
         
         
        
     }
 
  
    
	public static void main (String[] args) {
		
		Difference x=new Difference();
		x.insert(5);
		x.insert(-10);
		x.insert(3);
		x.insert(9);
		x.insert(8);
		x.insert(-4);
		x.insert(7);
	    Sum s=new Sum();
	    x.sum(x.root,s,1);
	    System.out.println(s.esum-s.osum);
	    
	    
	  
	
   
		
	}
}
