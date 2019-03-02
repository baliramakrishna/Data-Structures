
// Check if each internal node of BST has only one child 

class BinaryTree { 

	boolean hasOnlyOneChild(int pre[], int size) { 
		// Initialize min and max using last two elements 
		int min, max; 
		if (pre[size - 1] > pre[size - 2]) { 
			max = pre[size - 1]; 
			min = pre[size - 2]; 
		} else { 
			max = pre[size - 2]; 
			min = pre[size - 1]; 
		} 

		// Every element must be either smaller than min or 
		// greater than max 
		for (int i = size - 3; i >= 0; i--) { 
			if (pre[i] < min) { 
				min = pre[i]; 
			} else if (pre[i] > max) { 
				max = pre[i]; 
			} else { 
				return false; 
			} 
		} 
		return true; 
	} 

	public static void main(String[] args) { 
		BinaryTree tree = new BinaryTree(); 
		int pre[] = new int[]{8, 3, 5, 7, 6}; 
		int size = pre.length; 
		if (tree.hasOnlyOneChild(pre, size) == true) { 
			System.out.println("Yes"); 
		} else { 
			System.out.println("No"); 
		} 
	} 
} 

// This code has been contributed by Mayank Jaiswal 
