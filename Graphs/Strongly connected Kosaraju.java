/*package whatever //do not write package name here */

import java.util.*;

class Graph {
    
    LinkedList<Integer> l[];
    int v;
    Graph(int v){
        
        this.v=v;
        l=new LinkedList[v];
        
        for(int i=0;i<v;i++)
        l[i]=new LinkedList<>();
        
    }
    
    void addEdge(int s,int d){
        l[s].add(d);
    }
    
    void find(){
        
        
        boolean visited[]=new boolean[v];
        Stack<Integer> s=new Stack<>();
               
        for(int i=0;i<v;i++){
            
            if(visited[i]==false)
            dfs(i,visited,s);
        }
        
        LinkedList<Integer> r[]=new LinkedList[v];
        
        reverse(r);
        
        Arrays.fill(visited,false);
       
       
       
       while(!s.isEmpty()){
           
           
           if(visited[s.peek()]==false){
               ArrayList<Integer> m=new ArrayList<>();
               dfsReverse(m,visited,s,s.peek(),r);
               s.pop();
               System.out.println(m);
           }else
           s.pop();
           
       }
        
    }
    
  void dfsReverse( ArrayList<Integer> m,boolean visited[],Stack<Integer> s,int p,LinkedList<Integer> r[]){
      
      visited[p]=true;
      m.add(p);
      for(int k:r[p]){
          
          if(visited[k]==false)
          dfsReverse(m,visited,s,k,r);
      }
      
  }
    
    void reverse(LinkedList<Integer> r[]){
        
        
        for(int i=0;i<v;i++)
        r[i]=new LinkedList<>();
        
        for(int i=0;i<v;i++){
            
            for(int k:l[i])
            r[k].add(i);
        }
    }
    
    
    void dfs(int p,boolean visited[],Stack<Integer> s){
        
        visited[p]=true;
        
        for(int k:l[p]){
            
            if(visited[k]==false)
            dfs(k,visited,s);
        }
        
        s.push(p);
        
    }
	public static void main (String[] args) {
		
		Graph g=new Graph(11);
		
		g.addEdge(0,1);
		g.addEdge(2,0);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,3);
		g.addEdge(6,5);
		g.addEdge(6,7);
		g.addEdge(7,8);
		g.addEdge(8,9);
		g.addEdge(9,6);
		g.addEdge(9,10);
		
		g.find();
	}
}
