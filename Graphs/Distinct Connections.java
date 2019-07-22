/*package whatever //do not write package name here */

import java.io.*;

class DistinctConnections{
    
    static int row[]={0,1,1,1};
    static int col[]={1,-1,0,1};
    static int distinct(int a[][],int n,int m){
        
        int count=0;
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
               if(a[i][j]==0)
               continue;
               
               for(int k=0;k<4;k++){
                   
                   int p=i+row[k];
                   int q=j+col[k];
                   
                   if(p>=0 && q>=0 && p<n && q<m && a[p][q]!=0)
                   count++;
               }
            }
        }
        return count;
        
    }  
	public static void main (String[] args) {
		
		int a[][]={
		    {1,0,0,1},
		    {0,1,1,1},
		    {1,0,0,1}
		};
		System.out.println(distinct(a,a.length,a[0].length));
	}
}
