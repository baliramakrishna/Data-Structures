/*package whatever //do not write package name here */
import java.io.*;
class Element{
        int element=Integer.MIN_VALUE;
        int l=0;
        int prev;
    }
class BST{
    
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
 
void smallest(Node root,int k,Element e){
    
    if(root==null)
    return;
    
    smallest(root.left,k,e);
    
    //if two elements are same dont count
    if(e.prev!=root.data)
    e.l++;
    //store prev node data
    e.prev=root.data;
    
    //if lth element is equal to kth element
    if(e.l==k)
    e.element=root.data;
    smallest(root.right,k,e);
    
}



	public static void main (String[] args) {
		
		BST x=new BST();
		x.insert(20);
		x.insert(10);
		x.insert(22);
		x.insert(4);
		x.insert(12);
		x.insert(10);
		x.insert(14);
		Element e=new Element();
		x.smallest(x.root,3,e);
		System.out.println(e.element);
	 
	}
}
