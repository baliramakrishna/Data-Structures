import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {   static class Pair{
     
     int x;
     int y;
     Pair(int x,int y){
         this.x=x;
         this.y=y;
     }
     
     }
     
     static int row[]={1,1,1,0,0,-1,-1,-1};
     static int coloumn[]={1,0,-1,1,-1,1,0,-1};
     
     static boolean check(String str,int N,char ch[][],int m,int n,boolean visited[][],int i,int j){
         
        
         if(N==0)
         return true;
         
         
         
         visited[i][j]=true;
         for(int v=0;v<8 ;v++){
             
             int r=i+row[v];
             int c=j+coloumn[v];
             
             if(r>=0 && c>=0 && r<m && c<n && str.charAt(0)==ch[r][c] &visited[r][c]==false && check(str.substring(1),N-1,ch,m,n,visited,r,c)){
                 visited[i][j]=false;
                 return true;
             }
            
    
         }
         
         visited[i][j]=false;
                 return false; 
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
          HashMap<String,Boolean> h=new HashMap<>();
           int N=s.nextInt();
           String str[]=new String[N];
           
          
           for(int i=0;i<N;i++){
           str[i]=s.next();
        
           h.put(str[i],false);
           }
          
           int m=s.nextInt();
           int n=s.nextInt();
           
           char ch[][]=new char[m][n];
          
           HashMap<Character,ArrayList<Pair>> h1=new HashMap<>();
          for(int i=0;i<m;i++){
              
              for(int j=0;j<n;j++){
              ch[i][j]=s.next().charAt(0);
              
              if(h1.containsKey(ch[i][j])){
                  ArrayList<Pair> l=h1.get(ch[i][j]);
                  l.add(new Pair(i,j));
                  h1.put(ch[i][j],l);
                 
              }else{
                  
                  ArrayList<Pair> l=new ArrayList<>();
                  l.add(new Pair(i,j));
                  h1.put(ch[i][j],l);
              }
              }
          }
          
          StringBuffer b=new StringBuffer("");
         
         
         TreeSet<String> p=new TreeSet<>();
             
             
          for(int i=0;i<N;i++){
              
              if(h.get(str[i]))
              p.add(str[i]);
              else{
                 
                  
                  if(h1.containsKey(str[i].charAt(0))){
                      
                      ArrayList<Pair> l =h1.get(str[i].charAt(0));
                      int k=l.size();
                      for(int j=0;j<k;j++){
                           
                          boolean visited[][]=new boolean[m][n];
                          String str2=str[i].substring(1);
                          int x=l.get(j).x;
                          int y=l.get(j).y;
                          
                          
                          
                          
                          if(check(str2,str2.length(),ch, m,n,visited,x,y)){
                          p.add(str[i]);
                          h.put(str[i],true);
                          break;
                         }
                          
                          
                      }
                      
                      
                      
                  }
                 
              }
              
          }
          
        if(p.size()!=0){
        for(String v:p)
        b.append(v+" ");
        
        System.out.println(b);
        }
        else
        System.out.println(-1);
        }
	  
	  
	 }
}
