import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static class Tree{
         
         int x;
         int y;
         
         Tree(int x,int y){
             this.x=x;
             this.y=y;
         }
         
         public String toString(){
             return this.x+" "+this.y+"    ";
         }
     }
     
     static Queue<Tree> q=new LinkedList<>();
     
     static boolean isValid(int x,int y,int n,int m){
         
         if(x>=0 && y>=0 && x<n && y<m)
         return true;
         else
         return false;
         
     }
     
     static boolean isDelimitter(Tree t){
         
         
         if(t.x==-1 && t.y==-1)
         return true;
         else
         return false;
     }
     
     static boolean check(int a[][],int n,int m){
         
         for(int i=0;i<n;i++){
             
             
             for(int j=0;j<m;j++){
                 
                 if(a[i][j]==1)
                 return true;
             }
         }
         return false;
         
     }
     static int time(int a[][],int n,int m){
         
         int ans=0,count=0;
         
         while(!q.isEmpty()){
             
             boolean flag=false;
             
            
             while(!isDelimitter(q.peek())){
                 
                Tree t=q.peek();
                
                if(isValid(t.x+1,t.y,n,m) && a[t.x+1][t.y]==1){
                    
                 if(flag==false){
                     ans++;
                     flag=true;
                 }    
                    
                 a[t.x+1][t.y]=2;
                 q.add(new Tree(t.x+1,t.y));
                    
                }
                 if(isValid(t.x-1,t.y,n,m) && a[t.x-1][t.y]==1){
                    
                 if(flag==false){
                     ans++;
                     flag=true;
                 }    
                    
                 a[t.x-1][t.y]=2;
                 q.add(new Tree(t.x-1,t.y));
                    
                }
                 if(isValid(t.x,t.y+1,n,m) && a[t.x][t.y+1]==1){
                    
                 if(flag==false){
                     ans++;
                     flag=true;
                 }    
                    
                 a[t.x][t.y+1]=2;
                 q.add(new Tree(t.x,t.y+1));
                    
                }
                 if(isValid(t.x,t.y-1,n,m) && a[t.x][t.y-1]==1){
                    
                 if(flag==false){
                     ans++;
                     flag=true;
                 }    
                    
                 a[t.x][t.y-1]=2;
                 q.add(new Tree(t.x,t.y-1));
                    
                }
                // System.out.println(q);
                q.poll(); 
                 
             }
             
            q.poll();
            // System.out.println(q.size());
             if(!q.isEmpty())
             q.add(new Tree(-1,-1));
             
         }
         
         return (check(a,n,m))?-1:ans;
         
     }
	public static void main (String[] args) throws IOException
	 {
	   q.clear();
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int m=s.nextInt();
           int a[][]=new int[n][m];
           
           for(int i=0;i<n;i++){
               
               for(int j=0;j<m;j++){
                   a[i][j]=s.nextInt();
                   if(a[i][j]==2)
                   q.add(new Tree(i,j));
               }
           }
          
          q.add(new Tree(-1,-1));
          System.out.println(time(a,n,m));
        
        }
	  
	  
	 }
}
