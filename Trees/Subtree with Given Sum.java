/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   HeightSum{
  
    Node root;
    
    static class Count{
        int count;
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
    
    
    
     int sum(Node root,int k,Count c){
         
         if(root==null)
         return 0;
         
         int l=sum(root.left,k,c);
         int r=sum(root.right,k,c);
         
         if(l+r+root.data==k)
         c.count++;
         
         return root.data+l+r;
        
     }
 
  
    
	public static void main (String[] args) {
		
		HeightSum x=new HeightSum();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		Count c=new Count();
	   x. sum(x.root,11,c);
	    if(c.count>0)
	    System.out.println(true);
	    else
	     System.out.println(false);
	    
	  
	
   
		
	}
}
