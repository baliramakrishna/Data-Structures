/*package whatever //do not write package name here */

import java.util.*;

class Graph{
    
    class Edge 
    { 
        int src, dest, weight; 
        
        Edge(int src,int dest,int weight){
            
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
       Edge(){
           
       }
    }
    
    int v;
    int E;
    Edge edge [];
    Graph(int v,int E){
        this.v=v;
        this.E=E;
        edge=new Edge[E];
        
        for(int i=0;i<E;i++)
       edge[i]=new Edge();
    }
    
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
    
    
    
    void kruskal(){
        
        
        for(Edge e:edge){
            
            int p1=findSet(e.src);
            int p2=findSet(e.dest);
            
            if(p1==p2)
            continue;
            else{
                this.union(p1,p2);
                System.out.println("source : "+e.src+"  destination  : "+e.dest+"   weight : "+e.weight);
            }
            
        }
        
        
    }
    
	public static void main (String[] args) {
		
		Graph graph=new Graph(4,5);
		graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 4; 
        
        Arrays.sort(graph.edge,(t1,t2)->{
            return t1.weight-t2.weight;
        });
        
        for(int i=0;i<4;i++)
        graph.makeSet(i);
        
        graph.kruskal();
  
	}
}
