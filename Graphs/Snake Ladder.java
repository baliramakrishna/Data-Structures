import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { static class Node{
     
     int x;
     int d;
     
     Node(int x,int d){
         this.x=x;
         this.d=d;
     }
 }
    static int minThrows(HashMap<Integer,Integer> h){
        
        Queue<Node> q=new LinkedList();
        int min=100000;
        q.add(new Node(1,0));
      
         boolean visited[]=new boolean[31];
         visited[1]=true;
         
        while(!q.isEmpty()){
            
            Node p=q.poll();
            
            if(p.x==30){
             min=Math.min(p.d,min);
             continue;
            }
            
            for(int i=1;i<=6;i++){
                int x=p.x+i;
                
                if(x<=30 && visited[x]==false){

                  visited[x]=true; 
                  
                if(h.containsKey(x) ){
                x=h.get(x);
                if(visited[x]==false){
                visited[x]=true;
                q.add(new Node(x,p.d+1));
                }
                }
                
                else if(!h.containsKey(x))
                q.add(new Node(x,p.d+1));
                
                }
            }
            
        }
        
        if(min==100000)
        return -1;
        else
        return min;
        
    }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           HashMap<Integer,Integer> h=new HashMap<>();
           for(int i=0;i<n;i++)
           h.put(s.nextInt(),s.nextInt());
           
           System.out.println(minThrows(h));
        
        }
	  
	  
	 }
}
