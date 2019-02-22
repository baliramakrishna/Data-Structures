/*package whatever //do not write package name here */
import java.util.*;

class   DiagnolSum{
   
   static class Sum{
       
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
    
    void sum(Node root,HashMap<Integer,Integer> h,int l){
        
        if(root ==null)
        return;
        if(h.containsKey(l)){
          int x=h.get(l);
          x+=root.data;
          h.put(l,x);
        }else
        h.put(l,root.data);
        
        //if you go right add nothing
        sum(root.right,h,l);
        //if you go left add 1
        sum(root.left,h,l+1);
        
    }
  void sumDiagnol(){
      
      HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
      sum(root,h,1);
      
      for(int i=1;;i++){
          
          if(h.containsKey(i))
          System.out.print(h.get(i)+" ");
          else
          break;
      }
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
		x.sumDiagnol();
	
   
		
	}
}
