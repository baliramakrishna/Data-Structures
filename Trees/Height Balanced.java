


class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
}

class Height{
	
	boolean b=true;
}

public class HeightBalanced {
	
		Node root;
	
	
		int heightBalanced(Node root,Height h) {
			
			if(root==null)
				return 0;
			
				
			int lh=heightBalanced(root.left,h);
			int rh=heightBalanced(root.right,h);
			
			if(Math.abs(lh-rh)<=1)
				h.b=(h.b)&true;
			else
				h.b=(h.b)&false;
			
			return Math.max(lh,rh)+1;
				
			
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeightBalanced t=new HeightBalanced();
		t.root=new Node(1);
		t.root.left=new Node(2);
		t.root.right=new Node(3);
		t.root.right.right=new Node(4);
		t.root.right.right.right=new Node(7);
		t.root.left.right=new Node(4);
	    t.root.left.right.right=new Node(5);
   		t.root.left.right.right.right=new Node(6);
		Height h=new Height();
		t.heightBalanced(t.root, h);
		System.out.println(h.b);
	
		

	}

}
