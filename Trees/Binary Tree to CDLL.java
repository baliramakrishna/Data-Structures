class GfG
{ 
    
    Node head1=null;
    Node head2=null;
    Node prev=null;
    Node bTreeToClist(Node root)
    {
        
        circular( root);
        
        Node p=head1;
        
        while(p.right!=null)
        p=p.right;
        
        p.right=head1;
        head1.left=p;
        
        return head1;
        
    }
    
    void circular(Node root){
        
        if(root==null)
        return;
        
        circular(root.left);
        
        if(prev==null){
            head1=root;
        }
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        circular(root.right);
    }
    
}
    
