/*package whatever //do not write package name here */

import java.util.*;

class StringTree{
    
    static int sum(String s,int k){
        
        int l=-1;
        int sum=0;
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='(')
            l++;
            else if(s.charAt(i)==')')
            l--;
            else{
            if(l==k){
            String s1="";
            s1+=s.charAt(i);
            sum+=(Integer.parseInt(s1));
            }
            }
        }
        
        return sum;
    }
    
	public static void main (String[] args) {
	
	String s="(0(5(6()())(4()(9()())))(7(1()())(3()())))" ;
	int k=2;
	
	System.out.println(sum(s,k));
	}
}
