/*package whatever //do not write package name here */

import java.util.*;

class Graph{
    
    
    static void minimumPrims(int a[][],int n){
        
        
    HashMap<Integer,Integer> h1=new HashMap<>();
    PriorityQueue<Map.Entry<Integer,Integer>> q=new PriorityQueue<>((t1,t2)->{
        
        if(t1.getValue()>t2.getValue())
        return 1;
        else if(t1.getValue()<t2.getValue())
        return -1;
        else
        return 0;
        
    });
    
    HashMap<Integer,Integer> h2=new HashMap<>();
    
    for(int i=1;i<n;i++)
    h1.put(i,Integer.MAX_VALUE);
    h1.put(0,0);
    
    while(h1.size()!=0){
        
        q.addAll(h1.entrySet());
        
        String str[]=q.poll().toString().split("=");
        int v=Integer.parseInt(str[0]);
        
        if(h1.size()==n)
        h1.remove(v);
        else{
            
            System.out.println(h2.get(v)+" "+v+" "+h1.get(v));
            h1.remove(v);
        }
        
        q.clear();
      
      
      for(int i=0;i<n;i++){
          
          if(a[v][i]!=0 && h1.containsKey(i) && h1.get(i)>a[v][i]){
              
              h2.put(i,v);
              h1.put(i,a[v][i]);
          }
          
      }
        
    }
    
        
        
        
    }
    
	public static void main (String[] args) {
	
      int a[][] = {{0, 2, 0, 6, 0}, 
            {2, 0, 3, 8, 5}, 
            {0, 3, 0, 0, 7}, 
            {6, 8, 0, 0, 9}, 
            {0, 5, 7, 9, 0}}; 
  
      minimumPrims(a,a.length);
	}
}
