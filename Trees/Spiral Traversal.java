/*package whatever //do not write package name here */

import java.util.*;

class NthPostOrder{
   
   static class Count{
       
       int count=0;
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
    
    void maxHeight(Node root,Count c,int h){
        
        if(root==null)
        return;
        
        ++h;
        if(h>c.count)
        c.count=h;
        maxHeight(root.left,c,h);
        maxHeight(root.right,c,h);
        
    }
    
    void spiralTraverse(int h){
        
       for(int i=1;i<=h;i++){
           
           if(i%2==1)
           printLeft(root,i,1);
           else
           printRight(root,i,1);
           
       }
    }
    void printLeft(Node root,int h,int c){
        
        if(root==null)
        return;
        if(c==h){
        System.out.println(root.data);
        return;
        }
    
         printLeft(root.right,h,c+1);
         printLeft(root.left,h,c+1);
        
        
        
        
    }
    void printRight(Node root,int h,int c){
        
        if(root==null)
        return;
        if(c==h){
        System.out.println(root.data);
        return;
        }
        
         printRight(root.left,h,c+1);
         printRight(root.right,h,c+1);
         
        
        
        
        
    }
	public static void main (String[] args) {
		
		NthPostOrder x=new NthPostOrder();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(7);
		x.insert(6);
		x.insert(5);
		x.insert(4);
		Count c=new Count();
		x.maxHeight(x.root,c,0);
		
	    x.spiralTraverse(c.count);
	   
		
	}
}
