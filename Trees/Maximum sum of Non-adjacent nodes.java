{
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
class MaxSum
{
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            Node root = null;
            int n = sc.nextInt();
            
            if(n==0){
                System.out.println(0);
                continue;
            }
            
            for(int i=0; i<n; i++){
                
                int a=sc.nextInt();
                int a1=sc.nextInt();
                
                char lr=sc.next().charAt(0);
                
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            System.out.println(new GFG().getMaxSum(root));
        }
    }
}
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/
class GFG
{
    static int getMaxSum(Node root)
    {
        if(root==null)
        return 0;
        
         int excl=getMaxSum(root.left)+getMaxSum(root.right);
         int incl=root.data;
         
         if(root.left!=null)
          incl+=getMaxSum(root.left.left)+getMaxSum(root.left.right);
          
          if(root.right!=null)
          incl+=getMaxSum(root.right.left)+getMaxSum(root.right.right);
          
          return Math.max(excl,incl);
         
    }
}
