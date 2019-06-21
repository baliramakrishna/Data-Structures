import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static class Pair{
         
         int x;
         int y;
         int d;
         Pair(int x,int y,int d){
             this.x=x;
             this.y=y;
             this.d=d;
         }
     }
     
     static int row[]={-1,-1,1,1,2,2,-2,-2,};
      static int coloumn[]={2,-2,2,-2,1,-1,1,-1};
     static int min(int i1,int j1,int i2,int j2,int n,int m,boolean visited[][]){
       
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i1,j1,0));
        visited[i1][j1]=true;
        while(!q.isEmpty()){
            
            
            Pair temp=q.poll();
            
            if(temp.x==i2 && temp.y==j2)
            return temp.d;
            
            for(int i=0;i<8 ;i++){
                
                int r=temp.x+row[i];
                int c=temp.y+coloumn[i];
                
                if(r>0 && c>0 && r<=n && c<=m && visited[r][c]==false){
                    visited[r][c]=true;
                    q.add(new Pair(r,c,temp.d+1));
                }
            }
            
        }
        
        return -1;
          
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int m=s.nextInt();
           int i1=s.nextInt();
           int j1=s.nextInt();
           int i2=s.nextInt();
           int j2=s.nextInt();
           
           boolean visited[][]=new boolean[n+1][m+1];
           System.out.println(min(i1,j1,i2,j2,n,m,visited));
        
        }
	  
	  
	 }
}
