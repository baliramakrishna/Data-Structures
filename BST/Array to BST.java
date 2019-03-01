/*package whatever //do not write package name here */

/*package whatever //do not write package name here */

import java.io.*;

class Array2BST{
    
     Node root;
     static int i=0;
    class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
        
    }
    
    Node array2Binary(int a[],int n){
        
        
        if(n<=0)
        return null;
        
        Node left=array2Binary(a,n/2);
        Node root=new Node(a[i]);
        root.left=left;
        i++;
        root.right=array2Binary(a,n-n/2-1);
        return root;
        
    }
    
    void inorder(Node root){
        
        if(root==null)
        return ;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
	public static void main (String[] args) {
		
		int a[]={1,2,3,4,5,6};
		Array2BST b=new Array2BST();
		Node root1=b.array2Binary(a,a.length);
		b.inorder(root1);
	}
}
