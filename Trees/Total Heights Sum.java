/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   HeightSum{
  
    Node root;
    
    static class Sum{
        int sum;
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
    
    
    
     int height(Node root,Sum s){
         
         if(root==null)
         return 0;
         if(root.left==null && root.right==null)
         return 1;
         
        int l=height(root.left,s);
        int r=height(root.right,s);
        
        s.sum+=(l+r);
        //max of (left height and right height) +1
        return 1+Math.max(l,r);
         
     }
 
  
    
	public static void main (String[] args) {
		
		HeightSum x=new HeightSum();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		Sum s=new Sum();
		int p=x.height(x.root,s);
		
		System.out.println(p+s.sum);
	
	  
	
   
		
	}
}
