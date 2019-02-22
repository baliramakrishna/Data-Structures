/*package whatever //do not write package name here */
/*package whatever //do not write package name here */
import java.util.*;

class   DiagnolSum{
   
   static class Sum{
       
       int level;
       int sum=0;
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
    
    
  void sum(Node root,Sum s,int sum,int l){
      
      if(root==null)
      return;
      sum+=root.data;
      
      //check sum and level at every leaf Node
      if(root.left==null && root.right==null){
          
          //if level is greater than the current,update level and sum
          if(l>s.level){
            s.level=l;
          s.sum=sum;
          }
          else{
              //if levels are equal ,update sum
              
              if(s.sum<sum)
              s.sum=sum;
          }
          
      }
      
      sum(root.left,s,sum,l+1);
      sum(root.right,s,sum,l+1);
      
      
      
  }
    
    
	public static void main (String[] args) {
		
		DiagnolSum x=new DiagnolSum();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.insert(5);
		x.insert(6);
		x.insert(7);
		x.insert(8);
		x.insert(9);
		Sum s=new Sum();
		x.sum(x.root,s,0,0);
	System.out.println(s.sum);
   
		
	}
}
