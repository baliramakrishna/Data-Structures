/*package whatever //do not write package name here */

import java.util.*;

class NegativeCycleException extends RuntimeException{
    
    
    NegativeCycleException(){
        super("Negative Cycle Ecveption");
    }
}

public class BellmanFord{
    static int MAX=100000;
    static void minimum(int g[][],int v,int e,int s) throws Exception{
        
        //for storing vertex and min distance
        HashMap<Integer,Integer> h1=new HashMap<>();
        
        //for storing verex and parent vertex
        HashMap<Integer,Integer> h2=new HashMap<>();
        
        //intialize all the distances to infinity
        for(int i=0;i<v;i++){
            h1.put(i,MAX);
            h2.put(i,null);
        }
        
        //starting vetex distace is 0
        h1.put(s,0);
        
        //traverse v-1 times for all the edges
        for(int j=0;j<v-1;j++){
            
            
            for(int i=0;i<e;i++){
                
                //if relaxation condtion satisfies update distance and parent vertex
                if(h1.get(g[i][0])+g[i][2]< h1.get(g[i][1])){
                    
                    h1.put(g[i][1],h1.get(g[i][0])+g[i][2]);
                    h2.put(g[i][1],g[i][0]);
                }
            }
            
        }
        
      
        // if 
        for(int i=0;i<e;i++){
                
                if(h1.get(g[i][0])+g[i][2]< h1.get(g[i][1])){
                    
                    throw new NegativeCycleException();
                }
            }
        
       
       for(int k:h1.keySet()){
           System.out.println(k+" "+h1.get(k));
           
       }
       
    }
    
	public static void main (String[] args) {
	    
	    int v=5;
	    int e=8;
	  
	  int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 }, 
                       { 1, 2, 3 }, { 1, 3, 2 },  
                       { 1, 4, 2 }, { 3, 2, 5 },  
                       { 3, 1, 1 }, { 4, 3, -3 } };
         
         try{              
        minimum(graph,v,e,0); 
         }
         catch(Exception t){
             System.out.println(t);
         }
	  
	  
	}
}
