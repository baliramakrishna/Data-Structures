{
import java.util.*;
import java.lang.*;
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
class ReverseInSize
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            int k = sc.nextInt();
            GfG gfg = new GfG();
            Node res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

}
/*This is a function problem.You only need to complete the function given below*/
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class GfG
{  
    static class Abc{
        
        static Node prev;
        static Node current;
    }
    
    static Abc first(Node head,int k){
        
        Node prev=null;
        Node next=null;
        Node current=head;
        int count=0;
        while(current!=null && count!=k){
            
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
            
        }
        
        Abc a=new Abc();
        a.prev=prev;
        a.current=current;
        
        return a;
        
    }
   
    static Node reverseList(Node current,Node start,int k){
        
        
        Node prev=null;
        Node next=null;
        int count=0;
        while(current!=null && count!=k){
            
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
            
        }
        
        start.next=prev;
        
        return current;
    }
    public static Node reverse(Node node, int k)
    {
        
        Node start=node;
        Abc a=first(node,k);
        node=a.prev;
        Node current=a.current;
        while(current!=null){
            
            Node temp=current;
            current=reverseList(current,start,k);
            start=temp;
        }
        
         return node;
    }
    
   
}
