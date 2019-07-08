* How can N queens be placed on an NxN chessboard so that no two of them attack each other?
No two queens are on the same row, column, or diagonal.*/

/*package whatever //do not write package name here */

import java.io.*;

class NQUEEN {
    
    
    public static int[] findPositions(int n){
        
        int a[]=new int[n];
        boolean hasposition=findPositions(a,0,n);
        
        if(hasposition)
        return a;
        else
        return null;
        
    }
    
    public static boolean findPositions(int a[],int row,int n){
        
        if(n==row)
        return true;
        
        for(int col=0;col<n;col++){
            
            boolean safe=true;
            
            for(int queen=0;queen<row;queen++){
                
                
                if(a[queen]==col || queen-a[queen]==row-col || queen+a[queen]==row+col){
                    safe=false;
                    break;
                }
                
            }
            
            if(safe){
               a[row]=col;
                 if(findPositions(a,row+1,n))
                    return true;
            }
        }
        
        return false;
    }
    
    
    
	public static void main (String[] args) {
	  
	   int n=5;
	   int a[]=findPositions(n);
	   
	   if(a!=null){
	       System.out.println("positions of queens are: ");
	       for(int i=0;i<n;i++){
	           System.out.println(i+" "+a[i]);
	       }
	   }
	  
	}
}

