/*package whatever //do not write package name here */

{
    import java.util.*;
    class TestClass 
    {
        public static void main(String args[] ) throws Exception 
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while(T>0)
            {
            	int N = sc.nextInt();
            	
            	int x[] = new int[N];
       			int y[] = new int[N];
            	for(int i = 0; i < N; i++)
            		x[i] = sc.nextInt();
	for(int i = 0; i < N; i++)
            		y[i] = sc.nextInt();
            	System.out.println(new GfG(). noOfPoints(x,y,N));
            T--;
            }
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
class GfG{
    
    
   int count(int a[][],int n){
	    
	    if(n==1)
	    return 1;
	    
	    HashMap<Double,Integer> h;
	    
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
	               
	               //calculate slope
	               double s=(y*(1.0)/x);
	               
	               //if contains slope
	               //update current max(cm) 
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
	         
	         //current max is maximum of horizonatal,vertical,current max
	         cm=max(max(vp,hp),cm);
	         //current max+current point+overlapping points
	         mp=max(mp,cm+1+op);
	        
	    }
	    	return mp;
	   
	}
	
	  int max(int n1,int n2){
	    
	    return n1>=n2?n1:n2;
	}


   int noOfPoints(int X[],int Y[],int N) {
        //You are required to complete this method
        
         int a[][]=new int[N][2];
     
     for(int i=0;i<N;i++){
         a[i][0]=X[i];
         a[i][1]=Y[i];
     }
     
     return count(a,N);
   }
}
