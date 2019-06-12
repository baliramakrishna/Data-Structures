import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int k=s.nextInt();
           
       HashMap<Integer,Integer> h=new HashMap<>();
		PriorityQueue<Map.Entry<Integer,Integer>> q=new PriorityQueue<>((t1,t2)->{
		    
		    
		    if(t1.getValue()>t2.getValue())
		    return -1;
		    else if(t1.getValue()<t2.getValue())
		    return 1;
		    else{
		        
		        if(t1.getKey()<t2.getKey())
		        return -1;
		        else
		        return 1;
		    }
		});
		
		StringBuffer b=new StringBuffer("");
		for(int i=0;i<n;i++){
		   int p=s.nextInt();
		   if(h.containsKey(p))
		   h.put(p,h.get(p)+1);
		   else
		   h.put(p,1);
		   
		   q.clear();
		   q.addAll(h.entrySet());
		   int count=0;
		   while((!q.isEmpty()) && count<k){
		       
		       String str[]=q.poll().toString().split("=");
		       b.append(str[0]+" ");
		       count++;
		   }
		}
	System.out.println(b);
         
          
          
          
            
        }
	  
	  
	 }
}
