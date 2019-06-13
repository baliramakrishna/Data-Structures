/*package whatever //do not write package name here */

import java.util.*;

class Graph{
    
    LinkedList<Integer> l[];
    int n;
    
    Graph(int n){
        
    this.n=n;
    l=new LinkedList[n];
    
    for(int i=0;i<n;i++)
    l[i]=new LinkedList();
    
    }
    
  void addEdge(int s,int v ){
      
      l[s].add(v);
  }
     
  void topologicalSort(){
      
      Stack<Integer> s=new Stack<>();
      boolean visited[]=new boolean[n];
      
      for(int i=0;i<n;i++){
          
          if(visited[i])
          continue;
          
          calculate(i,visited,s);
      }
      
      System.out.println(s);
      
  }    
  
  void calculate(int v,boolean visited[], Stack<Integer> s){
      
      visited[v]=true;
      
      for(int i:l[v]){
          
          if(!visited[i])
          calculate(i,visited,s);
      }
      
      s.push(v);
  }
    
	public static void main (String[] args) {
		
	Graph g=new Graph(6);
	g.addEdge(5, 2); 
    g.addEdge(5, 0); 
    g.addEdge(4, 0); 
    g.addEdge(4, 1); 
    g.addEdge(2, 3); 
    g.addEdge(3, 1); 
    
   g. topologicalSort();
		
		
	}
}
