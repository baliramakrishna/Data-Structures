/*package whatever //do not write package name here */

import java.util.*;

class InsertionLevelOrderTree{
    
    Node root;
    
    class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int  data){
            this.data=data;
            left=null;
            right=null;
        }
        
    }
    
    void insert(int x){
        
        Node p=new Node(x);
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        if(root==null)
        root=p;
        else{
            Node temp;
            while(!q.isEmpty()){
                
                temp=q.peek();
                q.remove();
                
                if(temp.left==null){
                    temp.left=p;
                    return;
                }else
                 q.add(temp.left);
                 
                 
                 if(temp.right==null){
                     temp.right=p;
                     return;
                 }else
                 q.add(temp.right);
            }
            
        }
        
    }
    
    void levelOrderTraversal(){
        
        Node p=root;
        int h=0;
        while(p!=null){
            h++;
            p=p.left;
        }
        for(int i=1;i<=h;i++)
        printAtLevel(root,i);
    }
    
    void printAtLevel(Node head,int l){
        
        if(head==null)
        return;
        if(l==1)
        System.out.println(head.data);
        else{
            
            printAtLevel(head.left,l-1);
            printAtLevel(head.right,l-1);
        }
    }
	public static void main (String[] args) {
	   
	   InsertionLevelOrderTree l=new InsertionLevelOrderTree();
	   l.insert(1);
	   l.insert(2);
	   l.insert(3);
	   l.insert(4);
	   l.insert(5);
	   l.insert(6);
	   l.levelOrderTraversal();
	
	
	}
}
