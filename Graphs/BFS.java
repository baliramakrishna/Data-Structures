
import java.util.*;

class Graph{
    
    static int v;
    static LinkedList<Integer> l[];
    
    Graph(int v){
        
        this.v=v;
        l=new LinkedList[v];
        
        for(int i=0;i<v;i++)
        l[i]=new LinkedList<>();
        
    }
    
    static void addEdge(int v,int e){
        
        l[v].add(e);
        
    }
    
    
    static void Bfs(int s){
        
       boolean visited[]=new boolean[v];
       Arrays.fill(visited,false);
       Queue<Integer> q=new LinkedList<>();
       q.add(s);
       while(!q.isEmpty()){
           
           
           int temp=q.poll();
           System.out.print(temp+" ");
           visited[temp]=true;
           for(int k:l[temp]){
               
               if(!visited[k])
               q.add(k);
               
               
           }
           
       }
       
        
        
    }
    
	public static void main (String[] args) {
		
		Graph g=new Graph(4);
		addEdge(0,1);
		addEdge(0,2);
		addEdge(1,2);
		addEdge(2,0);
		addEdge(2,3);
		addEdge(3,3);
		Bfs(2);
		
		
	}
}
