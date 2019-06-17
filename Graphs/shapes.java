import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static int row[]={1,-1,0,0};
     static int coloumn[]={0,0,-1,1};
     
     static boolean isValid(char ch[][],int i,int j,int n,int m){
         
         if(i>=0 && j>=0 && i<n && j<m && ch[i][j]=='X')
         return true;
         else
         return false;
         
         
     }
     
     static void dfs(char ch[][],int i,int j,int n,int m,boolean visited[][]){
         
         visited[i][j]=true;
         
         for(int v=0;v<4;v++){
             
            int r=i+row[v];
            int c=j+coloumn[v];
            
            if(isValid(ch,r,c,n,m) && visited[r][c]!=true)
            dfs(ch,r,c,n,m,visited);
         }
         
         
     }
     
     
     static int shapes(char ch[][],int n,int m){
         
         int count=0;
         boolean visited[][]=new boolean[n][m];
         for(int i=0;i<n;i++){
             
             for(int j=0;j<m;j++){
                 
                   if(ch[i][j]=='X' && visited[i][j]!=true){
                       
                       dfs(ch,i,j,n,m,visited);
                       count++;
                       
                   }
                 
             }
         }
         
         
       return count;  
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int t=Integer.parseInt(br.readLine());
  
        while (t-- > 0) { 
          
          String str1[]=br.readLine().trim().split("\\s+");
           int n=Integer.parseInt(str1[0]);
           int m=Integer.parseInt(str1[1]);
           
           char ch[][]=new char[n][m];
             String str[]=br.readLine().trim().split("\\s+");
           for(int i=0;i<n;i++){
               
             
               for(int j=0;j<m;j++){
                   
                  ch[i][j]=str[i].charAt(j);
                   
               }
             
           }
           
           System.out.println(shapes(ch,n,m));
        
        }
	  
	  
	 }
}
