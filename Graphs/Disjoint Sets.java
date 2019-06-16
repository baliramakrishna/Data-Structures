/*package whatever //do not write package name here */

import java.util.*;

class DisjointSet{
    
    class Node{
        
        int data;
        int rank;
        Node parent;
        
        Node(int data){
        this.data=data;
        }
        
    }
    
    HashMap<Integer,Node> h=new HashMap<>();
    
    void makeSet(int x){
        
        Node p=new Node(x);
        p.rank=0;
        p.parent=p;
        h.put(x,p);
        
    }
    
    void union(int x,int y){
        
        Node p1=findSet(h.get(x));
        Node p2=findSet(h.get(y));
        
        if(p1.data==p2.data)
        return;
        
        if(p1.rank>=p2.rank){
            
            p1.rank=(p1.rank==p2.rank)?p1.rank+1:p1.rank;
            p2.parent=p1;
        }
        else{
            p1.parent=p2;
        }
    }
    
    int findSet(int x){
        return findSet(h.get(x)).data;
    }
    
    Node findSet(Node node){
        
        Node parent=node.parent;
        
        if(parent==node)
        return parent;
        
        node.parent= findSet(node.parent);
        return node.parent;
    }
    
	public static void main (String[] args) {
		
		DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
		
		
		System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
	}
}
