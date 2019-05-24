import java.util.*;

class Sum{
    
    Node root;
    
    static class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
        
    }
    
    void inorder(Node root){
        
        if(root==null)
        return;
        else{
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        
    }
    
   
    
    void insert(int x){
        
        Node p=new Node(x);
        if(root==null){
            root=p;
            return;
        }
        
        Queue<Node> q=new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node temp=q.poll();
            
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

  
  
  
  static boolean sum(Node root,int k){
      
      if(root==null)
      return false;
      
      if(root.left==null && root.right==null){
      
      if(root.data>=k)
      return true;
      else
      return false;
      
      }
      
      boolean b1=sum(root.left,k-root.data);
      boolean b2=sum(root.right,k-root.data);
      
      if(b1==false)
      root.left=null;
      if(b2==false)
      root.right=null;
      
      return b1 || b2;
      
      
  }
	public static void main (String[] args) {
	  
    Sum s=new Sum();
   int k = 45;  
    Node root = new Node(1);  
    root.left = new Node(2);  
    root.right = new Node(3);  
    root.left.left = new Node(4);  
    root.left.right = new Node(5);  
    root.right.left = new Node(6);  
    root.right.right = new Node(7);  
    root.left.left.left = new Node(8);  
    root.left.left.right = new Node(9);  
    root.left.right.left = new Node(12);  
    root.right.right.left = new Node(10);  
    root.right.right.left.right = new Node(11);  
    root.left.left.right.left = new Node(13);  
    root.left.left.right.right = new Node(14);  
    root.left.left.right.right.left = new Node(15);
    
    if(!sum(root,k))
    s.root=null;
    

    s.inorder(root);
   
    
	}  
}
