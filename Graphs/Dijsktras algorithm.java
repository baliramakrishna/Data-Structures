/*package whatever //do not write package name here */

import java.util.*;

class Dijkstra{
    
    static void minimum(int g[][],int n,int s){
        
        //for storing initial vertices and distances
        HashMap<Integer,Integer> h1=new HashMap<>();
        
        //storing verices and its parents
        HashMap<Integer,Integer> h2=new HashMap<>();
        
        //storing vertes and its final distances from source
        HashMap<Integer,Integer> h3=new HashMap<>();
        
        PriorityQueue<Map.Entry<Integer,Integer>> p=new PriorityQueue<>((t1,t2)->{
            
            return t1.getValue()-t2.getValue();
        });
        
        
    for(int i=0;i<n;i++)
    h1.put(i,Integer.MAX_VALUE);
    h1.put(s,0);
    
    
    while(h1.size()!=0){
        
        p.addAll(h1.entrySet());
        
        String str[]=p.poll().toString().split("=");
        int v=Integer.parseInt(str[0]);
        p.clear();
        
        //get the minimum and put it in heap
        h2.put(v,h1.get(v));
        h1.remove(v);
        //distance till that vertex
        int d=h2.get(v);
        if(h3.size()==0)
        h3.put(v,-1);
        
        for(int i=0;i<n;i++){
            
            if( g[v][i]!=0 && h1.containsKey(i)&& h1.get(i)>d+g[v][i]){
                
                h1.put(i,d+g[v][i]);
                h3.put(i,v);
                
            }
            
        }
        
    }
    
    for(int k:h2.keySet())
    System.out.println(k+" "+h2.get(k));
    
        
    }
    
	public static void main (String[] args) {
		
		 int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                      {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                      {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                      {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                      {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                      {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                      {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                      {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                      {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                     }; 
        System.out.println("minimum distance from A(0) to  all is ");
        minimum(graph,graph.length,0);
	}
}
