/*package whatever //do not write package name here */

import java.io.*;

class NegativeCycleDetection extends RuntimeException{
    
    
    NegativeCycleDetection(){
        super("negative cycle detection");
    }
    
}
public class FloydWarshall {
    
    static int INF=100000;
    
    static void minimum(int graph[][]) throws Exception{
        
        int n=graph.length;
        int d[][]=new int[n][n];
        int path[][]=new int[n][n];
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                d[i][j]=graph[i][j];
                
                if(graph[i][j]==INF)
                path[i][j]=-1;
                else
                path[i][j]=i;
            }
        }
        
        
        for(int k=0;k<n;k++){
            
            for(int i=0;i<n;i++){
                
                for(int j=0;j<n;j++){
                    
                    if(d[i][j]>d[i][k]+d[k][j]){
                        d[i][j]=d[i][k]+d[k][j];
                        path[i][j]=path[k][i];
                    }
                    
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(d[i][i]<0)
            throw new NegativeCycleDetection();
        }
      
      for(int i=0;i<n;i++ ){
          
          for(int j=0;j<n;j++){
              
              System.out.print(d[i][j]+" ");
          }
          System.out.println();
      }
        
    }
    
	public static void main (String[] args) {
		
		int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
        
        try{
        minimum(graph);
        }
        catch(Exception e){
            System.out.println(e);
        }
		
	}
}
