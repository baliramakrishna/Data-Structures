/*package whatever //do not write package name here */
import java.io.*;

class InorderSuccessor{
    
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
        
        if(root==null)
        root=x;
        else{
           
           Node p=root;
           Node q=p;
           
           while(p!=null){
               q=p;
               if(data <=p.data)
               p=p.left;
               else
               p=p.right;
           }
            
            if(data<=q.data)
            q.left=x;
            else
            q.right=x;
        }
    }
    
  Node ancestor(Node root,int n1,int n2){
      
      if(root==null)
      return null;
      while(root!=null){
      if(root.data>n1 && root.data>n2)
      root=root.left;
      else if(root.data<n1 && root.data<n2)
      root=root.right;
      else  break;
      }
      return root;
  }




	public static void main (String[] args) {
		
		InorderSuccessor x=new InorderSuccessor();
		x.insert(20);
		x.insert(8);
		x.insert(22);
		x.insert(4);
		x.insert(12);
		x.insert(10);
		x.insert(14);
	   Node p=x.ancestor(x.root,8,14);
	   System.out.println(p.data);
	}
}
