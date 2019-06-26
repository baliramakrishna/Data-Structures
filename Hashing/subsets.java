import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
   
    static  void print(int a[], LinkedHashSet<String> t,ArrayList<Integer> r,int p,int n){
        
        for(int i=p;i<n;i++){
            
            r.add(a[i]);
           String str="(";
           for(int k:r)
           str=str+k+" ";
           
           str=str.trim();
           str=str+")";
           t.add(str);
            print(a,t,r,i+1,n);
            r.remove(r.size()-1);
            
        }
        
        
    }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           
           Arrays.sort(a);
          LinkedHashSet<String> t1=new LinkedHashSet<>();
           ArrayList<Integer> r=new ArrayList<>();
           
           print(a,t1,r,0,n);
           
          StringBuffer b=new StringBuffer("()");
          
          for(String  k:t1)
          b.append(k);
          
          System.out.println(b);
           
        
        }
	  
	  
	 }
}
