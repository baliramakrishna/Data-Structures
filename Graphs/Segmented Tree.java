/*package whatever //do not write package name here */

import java.util.*;


class GFG {
    static int MAX=100000;
    
    
    static void constructTree(int a[],int segTree[],int l,int h,int pos){
        
        
        if(l==h){
            segTree[pos]=a[l];
            return;
        }
        
        int mid=(l+h)/2;
        
        constructTree(a,segTree,l,mid,2*pos+1);
        constructTree(a,segTree,mid+1,h,2*pos+2);
        segTree[pos]=Math.min(segTree[2*pos+1],segTree[2*pos+2]);
        
    }
    
    static int findMin(int segTree[],int ql,int qh,int l,int h,int pos){
        
        //totally overlapp
        if(ql<=l && qh>=h)
        return segTree[pos];
        
        else if(ql>h || qh<l)
        return MAX;
        
        int mid=(l+h)/2;
        return Math.min(findMin(segTree,ql,qh,l,mid,2*pos+1),findMin(segTree,ql,qh,mid+1,h,2*pos+2));
        
        
    }
    
	public static void main (String[] args) {
     
	 int a[]={-1,3,4,0,2,1};
	 int n=a.length;
	 int m;
	 double k=Math.sqrt(n);
	 int k1=(int)k;
	 
	 if(k==k1)
	 m=2*k1-1;
	 else{
	    k1=(int)Math.pow(2,k1+1);
	    m=2*k1-1;
	 }
	 System.out.println(m);
	 int segTree[]=new int[m];
	 Arrays.fill(segTree,MAX);
	 constructTree(a,segTree,0,n-1,0);
	 System.out.println(findMin(segTree,0,4,0,m-1,0));
	 
	  
	}
}
