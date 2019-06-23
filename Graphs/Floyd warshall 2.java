import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { static int MAX=100000;
 
   static int check(int a[][],int v){
       
        
       for(int k=0;k<v;k++){
           
           for(int i=0;i<v;i++){
               
               for(int j=0;j<v;j++){
                   
                   if(a[i][k]==MAX || a[k][j]==MAX)
                   continue;
                   if(a[i][j]>a[i][k]+a[k][j])
                   a[i][j]=a[i][k]+a[k][j];
               }
           }
       }
       
       for(int i=0;i<v;i++){
       if(a[i][i]!=0)
       return 1;
       }
       return 0;
   }
 
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int v=s.nextInt();
           int e=s.nextInt();
           
           int a[][]=new int[v][v];
            
            for(int i=0;i<v;i++){
            Arrays.fill(a[i],MAX);
            a[i][i]=0;
            }
            
           for(int i=0;i<e;i++){
               int p=s.nextInt();
               int q=s.nextInt();
               if(p <v && q<v)
               a[p][q]=s.nextInt();
               else
               s.nextInt();
           }
           
           //for one edge 
           if(e==1 ){
               if(a[0][0]>=0)
              System.out.println(0);
              else
                System.out.println(1);
              continue;
           }
           
          
           System.out.println(check(a,v));
        
        }
	  
	  
	 }
}
