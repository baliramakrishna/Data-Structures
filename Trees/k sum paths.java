/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

 class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
    }
    
class   Paths{
  
    Node root;
    
    
   
    
   
    
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
    
    //for every node call paths function
 
  void printPaths(Node root,ArrayList<Integer> l,int k,int sum){
      
      if(root==null)
      return;
      
    
      paths(root,l,k,sum);
      printPaths(root.left,l,k,sum);
       printPaths(root.right,l,k,sum);
      
      
      
      
      
  }
 
  
    
	public static void main (String[] args) {
		
		Paths x=new Paths();
	   Node root = new Node(1); 
       root.left = new Node(3); 
    root.left.left = new Node(2); 
    root.left.right = new Node(1); 
    root.left.right.left = new Node(1); 
    root.right = new Node(-1); 
    root.right.left = new Node(4); 
    root.right.left.left = new Node(1); 
    root.right.left.right = new Node(2); 
    root.right.right = new Node(5); 
    root.right.right.right = new Node(2); 
		
		ArrayList<Integer> l=new ArrayList<>();
		x.printPaths(root,l,5,0);
	  
	
   
		
	}
}
