/*package whatever //do not write package name here */

import java.util.*;

class InfextoPostfix{
    
    static boolean isOperand(char ch){
        
        
        if(ch>='0' && ch<='9')
        return true;
        
        if(ch>='a' && ch<='z')
        return true;
        
        if(ch>='A' && ch<='Z')
        return true;
        
        return false;
        
        
    }
    
    static boolean isOpenBracket(char ch){
        
        if(ch=='(' || ch=='{' || ch=='[')
        return true;
        else
        return false;
        
    }
    
    static int precedence(char  ch){
        
        
        if(ch=='^')
        return 5;
        
        if(ch=='*' || ch=='/' || ch=='%')
        return 4;
        
        if(ch=='+' || ch=='-')
        return 3;
        
        return 2;
        
        
    }
    
   static boolean isHigherPrecedenece(char ch1,char ch2){
       
       int k=precedence(ch1);
       int p=precedence(ch2);
       
       if(k>=p)
       return true;
       else
       return false;
   } 
    
    static boolean isOperator(char ch){
        
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%' || ch=='^')
        return true;
        else 
        return false;
        
    }
    
    static boolean isClosingBracket(char ch){
        
         
        if(ch==')' || ch=='}' || ch==']')
        return true;
        else
        return false;
    }
    static String toPostfix(char[] exp,int n){
        
        Stack<Character> s=new Stack<>();
        String res="";
        
        for(int i=0;i<n;i++){
            
            if(isOperand(exp[i])){
            res=res+exp[i];
            continue;
            }
            
            else if(exp[i]==' ' || exp[i]==',')
            continue;
            
            else if(isOperator(exp[i])){
                
                while(!s.isEmpty() && !isOpenBracket(s.peek()) && isHigherPrecedenece(s.peek(),exp[i]))
                   res=res+s.pop();
                
                s.push(exp[i]);
                
            }
            else if(isOpenBracket(exp[i]))
            s.push(exp[i]);
            
            else if(isClosingBracket(exp[i])){
                
                while(!s.isEmpty() && !isOpenBracket(s.peek()))
                res=res+s.pop();
                
                s.pop();
                
            }
            
        }
        
        while(!s.isEmpty())
        res=res+s.pop();
        
        return res;
    }
    
	public static void main (String[] args) {
	    
	    String str="((a+b)*c-d*e)*f";
	    int  n=str.length();
		System.out.println(toPostfix(str.toCharArray(),n));
	}
}
