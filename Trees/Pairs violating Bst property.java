{

/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
class GFG {
    
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static void po(Object o){
        System.out.println(o);
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    HashMap<Integer, Node> map = new HashMap<>();
		    
		    int n = sc.nextInt();
             
            Node root = null;
            Node parent;
		    while(n-- > 0){
		        int p = sc.nextInt();
		        if(!map.containsKey(p)){
		            root = new Node(p);
		            map.put(root.data, root);
		        }
		        parent = map.get(p);
		        
		        int ch = sc.nextInt();
		        Node child = new Node(ch);
		        
		        char c = sc.next().charAt(0);
		        if(c == 'L')
		            parent.left = child;
		        else if(c == 'R')
		            parent.right = child;
		            
		        map.put(ch, child);
		    }
		    
		    //inorder(root);
		    //System.out.println();
		    Solution obj = new Solution();
			po(obj.pairs(root));
		}
	}
}

}
/*This is a function problem.You only need to complete the function given below*/
class Index{
    int p=0;
}
class Solution {
    /*
    The structure of the node class is:
    class Node {
    int data;
    Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    */
 
    int Length(Node root){
        
        if(root==null)
        return 0;
        
        return Length(root.left)+Length(root.right)+1;
    }
    
    int mergeSort(int a[],int n){
        
        if(n>1){
            
            int mid=n/2;
            int left[]=new int[mid];
            int right[]=new int[n-mid];
            
            for(int i=0;i<mid;i++)
            left[i]=a[i];
            
            for(int i=0;i<right.length;i++)
            right[i]=a[i+mid];
            
            int count=mergeSort(left,mid);
            count+=mergeSort(right,n-mid);
            
            count+=merge(a,left,right,mid,n-mid);
            
            return count;
        }
        else{
            return 0;
        }
    }
    
    int merge(int a[],int left[],int right[],int l,int r){
        
        
        int i=0,j=0,k=0,count=0;
        
        while(i<l && j<r){
            
            if(left[i]>right[j]){
                count+=l-i;
                a[k++]=right[j++];
            }else
            a[k++]=left[i++];
            
        }
        
        while(i<l)
        a[k++]=left[i++];
        
        while(j<r)
        a[k++]=right[j++];
        
        return count;
        
    }
    
    void add(Node root,Index i,int a[]){
        
        if(root==null)
        return;
        add(root.left,i,a);;
        a[i.p]=root.data;
        i.p=i.p+1;
        add(root.right,i,a);
    }
    
    public int pairs(Node root){
       
        int len=Length(root);
        int a[]=new int[len];
        Index i=new Index();
        add(root,i,a);
        
        return mergeSort(a,len);
     }
}
