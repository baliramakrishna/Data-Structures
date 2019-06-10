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
    static String toPrefix(char[] exp,int n){
        
        Stack<Character> s=new Stack<>();
        String res="";
        
        for(int i=n-1;i>=0;i--){
            
            if(isOperand(exp[i])){
            res=exp[i]+res;
            continue;
            }
            
            else if(exp[i]==' ' || exp[i]==',')
            continue;
            
            else if(isOperator(exp[i])){
                
                while(!s.isEmpty() && !isClosingBracket(exp[i]) && isHigherPrecedenece(s.peek(),exp[i]))
                   res=s.pop()+res;
                
                s.push(exp[i]);
                
            }
            else if(isClosingBracket(exp[i]))
            s.push(exp[i]);
            
            else if(isOpenBracket(exp[i])){
                
                while(!s.isEmpty() && !isClosingBracket(s.peek()))
                res=s.pop()+res;
                
                s.pop();
                
            }
            
        }
        
        while(!s.isEmpty()){
            
            if(isClosingBracket(s.peek()))
            s.pop();
            else
             res=s.pop()+res;
        }
       
        
        return res;
    }
    
	public static void main (String[] args) {
	    
	    String str="((a+b)*c-d*e)*f";
	    int  n=str.length();
		System.out.println(toPrefix(str.toCharArray(),n));
	}
}
