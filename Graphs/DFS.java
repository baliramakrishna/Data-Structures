/*package whatever //do not write package name here */

import java.util.*;

class Graph{
    
    int v;
    LinkedList<Integer> l[];
    
    Graph(int  v){
        
        this.v=v;
        l=new LinkedList[v];
        
        for(int i=0;i<v;i++)
        l[i]=new LinkedList<>();
    }
    
   void addEdge(int p,int e){
        
        l[p].add(e);
    }
    
    void Dfs(int p){
        
        boolean visited[]=new boolean[v];
        dfs(p,visited);
        
    }
    
    void dfs(int p,boolean visited[]){
        
       visited[p]=true;
       System.out.print(p+" ");
       
        for(int k:l[p]){
            if(!visited[k])
             dfs(k,visited);
        }
        
        
    }
    
    
	public static void main (String[] args) {
	  
	  Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.Dfs(2);
  
	}
}
