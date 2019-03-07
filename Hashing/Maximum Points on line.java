/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		int N=6;
		int a[][] = {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, 
                    {3, 3}, {3, 4}}; 
        System.out.println(count(a,N));
	}
	
	static int count(int a[][],int n){
	    
	    if(n==1)
	    return 1;
	    
	    HashMap<String,Integer> h;
	    
	    int mp=0,vp,hp,cm,op; 
	    for(int i=0;i<n-1;i++){
	        
	        h=new HashMap<>();
	        vp=0;hp=0;op=0;cm=0;

	        for(int j=i+1;j<n;j++){
	            
	            if(a[i][1]-a[j][1]==0)
	            hp++;
	           else  if(a[i][0]-a[j][0]==0){
	            vp++;
	           }
	           else if( a[i][1]==a[j][1] && a[i][0]==a[j][0]){
	            op++;
	           }
	            else{
	                
	               int y=a[i][1]-a[j][1];
	               int x=a[i][0]-a[j][0];
	               int g=gcd(x,y);
	               y/=g;
	               x/=g;
	               String s=pair(y,x);
	                if(!(h.containsKey(s))){
	                h.put(s,1);
	                cm = max(cm,1);
	                }
	                else{
	                    h.put(s,h.get(s)+1);
	                    cm= max(cm,h.get(s));
	                }
	            }
	            
	           
	        }
	   
	         cm=max(max(vp,hp),cm);
	         mp=max(mp,cm+1+op);
	        
	    }
	    	return mp;
	   
	}
	
	static int max(int n1,int n2){
	    
	    return n1>=n2?n1:n2;
	}

	private static int gcd(int a,int b){
	  if(a==0){
		 return b; 
	  }
	  if(b==0){
		 return a; 
	  }
	  if(a<0){
		 return gcd(-1*a,b); 
	  }
	  if(b<0){
		 return gcd(a,-1*b); 
	  }
	  if(a>b){
		 return gcd(b,a); 
	  }
	  return gcd(b%a,a);
   }
	private static String pair(int a,int b){
	  return String.valueOf(a)+String.valueOf(b); 
   }

}
