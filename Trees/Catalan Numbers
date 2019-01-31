/*package whatever //do not write package name here */
//catalan numbers-->1 1 2 5 14 42 132 429 1430 4862;
//catalan numbers represent no of unlabelled trees formed with respectives nodes ..0->1,1->1,2->2,3->5 respectively
import java.util.*;

class CatalanNumbers{
    
	public static void main (String[] args) {
		
		int a[]=new int[10];
		a[0]=1;
		a[1]=1;
		for(int i=2;i<9;i++){
		    int x=0;
		    for(int j=0;j<i;j++){
		        
		      x+=a[j]*a[i-j-1] ;
		        
		    }
		    a[i]=x;
		}
		
		for(int p:a)
		System.out.println(p);
	}
}
