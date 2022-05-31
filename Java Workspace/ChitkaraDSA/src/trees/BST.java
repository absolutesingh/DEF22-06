package trees;

import java.util.*;

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class BST {

	BSTNode root; // Root of the Binary Tree

	BST(int rootData) {
		this.root = new BSTNode(rootData);
	}

	BSTNode search(BSTNode root, int data) {
		if (root == null)
			return null;

		if (root.data == data)
			return root;

		if (data < root.data) // Search in LST
		{
			return search(root.left, data);
		} else { // Search in RST
			return search(root.right, data);
		}
	}

	boolean searchItr(BSTNode root, int data) {
		if (root == null)
			return false; // empty tree

		while (root != null) {
			if (data == root.data)
				return true; // value has been found
			else if (data < root.data) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		// We reach here -> root has become null.
		return false;
	}

	BSTNode insertRec(BSTNode root, int data) {
		if (root == null) // If tree is empty -> create a new node and return
			return new BSTNode(data);

		if (data <= root.data) {
			root.left = insertRec(root.left, data);
		} else {
			root.right = insertRec(root.right, data);
		}

		// Return the original root(this will be unchanged except in one case);
		return root;
	}

	int getMin(BSTNode root) {
		if (root == null) {
			System.out.println("Empty Tree, no min present.");
			return -1;
		}

		while (root.left != null) {
			root = root.left;
		}

		return root.data;
	}

	int getMax(BSTNode root) {
		if (root == null) {
			System.out.println("Empty Tree, no max present.");
			return -1;
		}

		while (root.right != null) {
			root = root.right;
		}

		return root.data;
	}

	BSTNode delete(BSTNode root, int data) {
		if (root == null)
			return null;

		if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else { // if root.data == data -> we've found the element to be deleted.
			if (root.left == null) // 1 Child case and 0 Child case.
			{
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// If we've reached this point means it is 2 child case.
			root.data = getMin(root.right); // Picking min element from RST
			root.right = delete(root.right, root.data); // Delete the min element from RST [Recursion]

			// We could have also done:
//			root.data = getMax(root.left); //Picking max element from LST
//			root.left = delete(root.left, root.data); //Delete the max element from LST [Recursion]
		}
		return root;
	}

//	https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/
	Node lcaBST(Node root, int n1, int n2) {
		if (root == null) // empty tree
		{
			return root;
		}

		if (n1 < root.data && n2 < root.data) {
			return lcaBST(root.left, n1, n2);
		}

		if (n1 > root.data && n2 > root.data) {
			return lcaBST(root.right, n1, n2);
		}

//		if root.data == n1
//		or, root.data == n2
//		or, one element is to the left and other element is to the right of root
//		So, in these three scenarios the LCA will be root
		return root;

	}
	
//	--------------Check if a tree is BST--------------
//	https://practice.geeksforgeeks.org/problems/check-for-bst/1/#
	boolean isBSTUtil(Node root, int min, int max)
    {
        if(root == null)
            return true;
            
        if(root.data < min || root.data > max)
            return false;
        
        return (isBSTUtil(root.left, min, root.data - 1) &&
                isBSTUtil (root.right, root.data + 1, max));
    }
    
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	public static void main(String[] args) {
		BST bst = new BST(15);
//		bst.root.left = new BSTNode(10);
//		bst.root.right = new BSTNode(20);
//		bst.root.left.left = new BSTNode(8);
//		bst.root.left.right = new BSTNode(12);
//		bst.root.right.left = new BSTNode(17);
//		bst.root.right.right = new BSTNode(25);
		// Sample tree has been created

		bst.root = bst.insertRec(bst.root, 10);
		bst.root = bst.insertRec(bst.root, 20);
		bst.root = bst.insertRec(bst.root, 8);
		bst.root = bst.insertRec(bst.root, 12);
		bst.root = bst.insertRec(bst.root, 17);
		bst.root = bst.insertRec(bst.root, 25);
		bst.root = bst.insertRec(bst.root, 3);
		bst.root = bst.insertRec(bst.root, 32);

		System.out.println(bst.search(bst.root, 17));
		System.out.println(bst.search(bst.root, 19));

		System.out.println(bst.searchItr(bst.root, 17));
		System.out.println(bst.searchItr(bst.root, 19));

		System.out.println(bst.getMin(bst.root));
		System.out.println(bst.getMax(bst.root));

		bst.root = bst.delete(bst.root, 3);
		System.out.println(bst.getMin(bst.root));
		System.out.println(bst.getMax(bst.root));

		bst.root = bst.delete(bst.root, 32);
		System.out.println(bst.getMin(bst.root));
		System.out.println(bst.getMax(bst.root));

		bst.root = bst.delete(bst.root, 15);

		System.out.println(bst.root.data);

	}

}
