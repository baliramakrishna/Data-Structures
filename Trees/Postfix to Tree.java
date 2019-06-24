{

import java.util.*;
import java.lang.*;
class Node
{
    char val;
    Node left, right;
    Node(char c)
    {
        val = c;
        left = right = null;
    }
}
class Construct
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            char postfix[] = str.toCharArray();
            GfG gfg = new GfG();
            Node et = gfg.constructTree(postfix);
            inorder(et);
            System.out.println();
        }
    }
    
    public static void inorder(Node et)
    {
        if(et != null)
        {
            inorder(et.right);
            System.out.print(et.val + " ");
            inorder(et.left);
        }
    }
    
    public static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
          return true;
          
        return false;
    }
}

}
/*This is a function problem.You only need to complete the function given below*/

class GfG
{
    
    public static Node constructTree(char postfix[])
    {
        Stack<Node> st = new Stack<Node>(); 
        Node t, t1, t2;
        
        Construct obj = new Construct(); 
        for(int i = 0; i < postfix.length; i++)
        {
            if(!obj.isOperator(postfix[i]))
              {
                  t = new Node(postfix[i]);
                  st.push(t);
              }
              else
              {
                  t = new Node(postfix[i]);
                  
                  t1 = st.peek();
                  st.pop();
                  
                  t2 = st.peek();
                  st.pop();
                  
                  
                  t.left = t1;
                  t.right = t2;
                  
                  st.push(t);
              }
        }
        
        t = st.peek();
        st.pop();
        
        return t;
    }
    
}
