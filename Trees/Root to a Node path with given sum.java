/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   Paths{
  
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
    
    
    void paths(Node root,ArrayList<Integer> l,int k,int sum){
       
       if(root==null)
       return;
       
       l.add(root.data);
       sum+=root.data;
       if(sum==k){
           
               for(int i=0;i<l.size();i++)
               System.out.print(l.get(i)+" ");
               
               System.out.println();
           
           
       }
       
       paths(root.left,l,k,sum);
       paths(root.right,l,k,sum);
       
       l.remove(l.size()-1);
    }
 
  
 
  
    
	public static void main (String[] args) {
		
		Paths x=new Paths();
		x.insert(1);
		x.insert(3);
		x.insert(5);
		x.insert(2);
		x.insert(1);
		x.insert(4);
		x.insert(5);
		
		ArrayList<Integer> l=new ArrayList<>();
		x.paths(x.root,l,6,0);
	  
	
   
		
	}
}
