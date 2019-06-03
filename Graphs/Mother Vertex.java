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
    
    void Dfs(){
        
        for(int i=0;i<v;i++){
           dfs(i,new boolean[v]);
           if(count==v){
           System.out.println(i);
           return;
           }
           count=0;
        }
       
        
        
    }
    
    static int count=0;
    void dfs(int p,boolean visited[]){
        
      visited[p]=true;
      count++;
        for(int k:l[p]){
            if(!visited[k])
             dfs(k,visited);
        }
        
       
    }
    
    
	public static void main (String[] args) {
	  
	  Graph g = new Graph(7); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(4, 1); 
        g.addEdge(6, 4); 
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        
        // for(LinkedList<Integer> p:g.l){
            
        //     for(int k:p)
        //     System.out.print(k+" ");
            
        //     System.out.println();
        // }
        
          g.Dfs();
         //g.dfs(5,new boolean[g.v]); 
  
	}
}
