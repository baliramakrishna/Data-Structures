/*package whatever //do not write package name here */

import java.util.*;

class VerticalPrint{
    
    
    static class Node 
    { 
        int data; 
        Node left; 
        Node right; 
          
        // Constructor 
        Node(int data) 
        { 
            this.data = data; 
            left = null; 
            right = null; 
        } 
    } 
	public static void main (String[] args) {
	    
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
		printVertical(root);
	}
	
	static void printVertical(Node root){
	    
	    if(root==null)
	    return;
	    TreeMap<Integer,ArrayList<Integer> > t=new TreeMap<>();
	    store(root,t,0);
	    
	    for(int k:t.keySet()){
	        
	        ArrayList<Integer> q=t.get(k);
	        
	        for(int i:q)
	        System.out.print(i+" ");
	        System.out.println();
	        
	    }
	}
	
  static	void store(Node root,TreeMap<Integer,ArrayList<Integer>> t,int k){
	    
	    if(root==null)
	    return;
	    
	    if(!t.containsKey(k)){
	        
	        ArrayList<Integer> l=new ArrayList<>();
	        l.add(root.data);
	        t.put(k,l);
	    }else{
	        
	        ArrayList<Integer> l=t.get(k);
	        l.add(root.data);
	        t.put(k,l);
	    }
	    
	    store(root.left,t,k-1);
	    store(root.right,t,k+1);
	    
	}
}
