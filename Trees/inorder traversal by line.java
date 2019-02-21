/*package whatever //do not write package name here */

import java.util.*;

class Traverse {
   
    
   class Key{
       
       Node head;
       int height;
       
       Key(Node head,int height){
           this.head=head;
           this.height=height;
       }
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
    
    
    
    
   void traversal(){
       
       Queue<Key> q=new LinkedList<>();
       
       if(root!=null)
       q.add(new Key(root,1));
       
       double k=0;
       while(!q.isEmpty()){
           
           Key n=q.remove();
           Node p=n.head;
           int h=n.height;
           System.out.print(p.data+" ");
            k++;
            //after printing elemnets in a line ,go to next line
           if(k==Math.pow(2,h-1)){
               System.out.println();
               k=0;
           }
           
           if(p.left!=null)
           q.add(new Key(p.left,h+1));
           if(p.right!=null)
           q.add(new Key(p.right,h+1));
           
       }
       
   }
	public static void main (String[] args) {
		
		Traverse x=new  Traverse();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(7);
		x.insert(6);
		x.insert(5);
		x.insert(4);
		x.traversal();
		
	   
		
	}
}
