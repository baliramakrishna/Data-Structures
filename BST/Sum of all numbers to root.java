/*package whatever //do not write package name here */

import java.io.*;

class LeafSum{
    
   static Node root;
    
    class Node{
        
        Node left;
        Node right;
        int data;
        
        Node(int data){
            this.data=data;
        }
    }
    
   void insert(int x){
        
        Node p=new Node(x);
        if(root==null){
            root=p;
            
        }else{
            Node q=root;
            Node prev=q;
            
            while(q!=null){
                prev=q;
                if(x<=q.data)
                q=q.left;
                else q=q.right;
            }
            
            if(x<=prev.data)
            prev.left=p;
            else
            prev.right=p;
            
        }
        
    }
    static int leafSum(Node head,int x){
        
        if(head==null)
        return 0;
        if(head.left==null && head.right==null)
        return x*10+head.data;
        else {
        return leafSum(head.left,x*10+head.data)+leafSum(head.right,x*10+head.data);
        }
    }
    
	public static void main (String[] args) {
		
		LeafSum l=new LeafSum();
		l.insert(6);
		l.insert(4);
		l.insert(9);
		l.insert(7);
		l.insert(2);
		l.insert(8);
		l.insert(5);
		System.out.println(leafSum(LeafSum.root,0));
		
	}
}
