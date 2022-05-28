package trees;

import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class BinaryTree {

	Node root; // Root of the Binary Tree

	BinaryTree(int rootData) {
		this.root = new Node(rootData);
	}

//	https://practice.geeksforgeeks.org/problems/sum-of-binary-tree/1/#
	int treeSum(Node root) {
		if (root == null)
			return 0;

		return root.data + treeSum(root.left) + treeSum(root.right);
	}

	int countNodes(Node root) {
		if (root == null)
			return 0;

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	int leafNode(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) // if it is a leafNode
		{
			return 1;
		}

		return leafNode(root.left) + leafNode(root.right);
	}

	public int sumOfLeafNodes(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) // if it is a leafNode
		{
			return root.data;
		}

		return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
	}

	// This is where the main processing happens
	void printAtLevelHelper(Node root, int pendingSteps) {
		if (root == null)
			return;

		if (pendingSteps == 0) {
			System.out.print(root.data + " ");
		}

		printAtLevelHelper(root.left, pendingSteps - 1);
		printAtLevelHelper(root.right, pendingSteps - 1);
	}

	// Creating helper function so that we can leave a line after printing a level.
	void printAtLevel(Node root, int pendingSteps) {
		printAtLevelHelper(root, pendingSteps);
		// All processing is done.

		// Now leave a line as desired.
		System.out.println();
	}

	int height(Node root) {
		if (root == null)
			return -1;

		return 1 + Math.max(height(root.left), height(root.right));
	}

	void bfsRecursive(Node root) {
		int levelCount = height(root) + 1;

		for (int i = 0; i < levelCount; i++) {
			printAtLevel(root, i); // Print all levels from [0 to height]
		}
	}

	void bfsIterative(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node current = q.poll();

			System.out.print(current.data + " ");

			if (current.left != null) {
				q.add(current.left);
			}

			if (current.right != null) {
				q.add(current.right);
			}
		}
		// When queue becomes empty means the BFS has completed.

		System.out.println();
	}

//	https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1/
	Node lca(Node root, int n1, int n2) {
		if (root == null) // empty tree
		{
			return root;
		}

		if (root.data == n1 || root.data == n2) {
			return root; // element found
		}

		// Find where are the two nodes
		Node leftLCA = lca(root.left, n1, n2);
		Node rightLCA = lca(root.right, n1, n2);

		// If one node lies on left and one node lies on right,
		// then our current node is the LCA

		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		else if (leftLCA == null) // Means both nodes are on right side
		{
			return rightLCA;
		}

		else // (rightLCA == null) //Means both nodes are on left side
		{
			return leftLCA;
		}

	}
	
//	--------------LEFT and RIGHT View--------------
	
	int levelToBePrinted = 0;
	
	void leftViewUtil(Node root, int level)
	{
		if(root == null)
			return;
		
		if(level == levelToBePrinted)
		{
			System.out.print(root.data + " ");
			levelToBePrinted++;
		}
		
		leftViewUtil(root.left, level + 1);
		leftViewUtil(root.right, level + 1);
	}
	
	void leftView(Node root)
	{
		leftViewUtil(root, 0);
		
		//Preparing for the next time
		levelToBePrinted = 0;
		System.out.println();
	}
	
	//Nothing but BFS where we're printing the first level.
	void leftViewIterative(Node root)
	{
		if(root == null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			//find the number of nodes in current element
			int n = q.size();
			
			for(int i=0;i<n;i++) //process these items
			{
				Node temp = q.poll();
				
				if(i==0) //if it is the first element of current level
				{
					System.out.print(temp.data + " ");
				}
				if(temp.left != null)
				{
					q.add(temp.left);
				}
				
				if(temp.right != null)
				{
					q.add(temp.right);
				}
			}
		}
		System.out.println();
	}
	
	void rightViewUtil(Node root, int level)
	{
		if(root == null)
			return;
		
		if(level == levelToBePrinted)
		{
			System.out.print(root.data + " ");
			levelToBePrinted++;
		}
		
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
	}
	
	void rightView(Node root)
	{
		rightViewUtil(root, 0);
		
		//Preparing for the next time
		levelToBePrinted = 0;
		System.out.println();
	}
	
//	--------------VERTICAL ORDER--------------
	
	int leftHD = 0; //leftmost horizontal distance
	int rightHD = 0; //rightmost horizontal distance
	
	void findHorizontalDistances(Node root, int hd) //hd -> Horizontal Distance
	{
		if(root == null)
			return;
		
		if(hd < leftHD)
		{
			leftHD = hd;
		}
		if(hd > rightHD)
		{
			rightHD = hd;
		}
		
		findHorizontalDistances(root.left, hd - 1);
		findHorizontalDistances(root.right, hd + 1);
	}
	
	void printVerticalLevel(Node root, int level, int hd)
	{
		if(root == null)
			return;
		
		if(level == hd)
		{
			System.out.print(root.data + " ");
		}
		
		printVerticalLevel(root.left, level, hd - 1);
		printVerticalLevel(root.right, level, hd + 1);
	}
	
	void verticalOrder(Node root)
	{
		findHorizontalDistances(root, 0); //To find the leftMost and rightMost horizontal distance from the root.
		
		for(int i = leftHD; i<= rightHD;i++)
		{
			printVerticalLevel(root, i, 0);
			System.out.println();
		}
	}
	
//	--------------ROOT TO LEAF PATH SUM--------------
//	https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1/
	boolean hasPathSum(Node root, int S) {
        if(root == null)
            return false;
            
        int pendingSum = S - root.data;
        
        if(pendingSum == 0 && root.left == null && root.right == null)
        {
            return true;
        }
        
        return hasPathSum(root.left, pendingSum) || hasPathSum(root.right, pendingSum);
        
        // boolean foundInLeft = false;
        // boolean foundInRight = false;
        
        // foundInLeft = hasPathSum(root.left, pendingSum);
        // foundInRight = hasPathSum(root.right, pendingSum);
        
        // return foundInLeft || foundInRight;
    }

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(2); // Create a Binary Tree with 2 as the root.
		bt.root.left = new Node(3);
		bt.root.right = new Node(5);
		bt.root.left.right = new Node(9);
		bt.root.right.left = new Node(7);
		// Sample tree has been created

		System.out.println(bt.treeSum(bt.root));
		System.out.println(bt.countNodes(bt.root));
		System.out.println(bt.leafNode(bt.root));
		System.out.println(bt.sumOfLeafNodes(bt.root));

		bt.printAtLevel(bt.root, 0);
		bt.printAtLevel(bt.root, 2);

		bt.bfsRecursive(bt.root);
		bt.bfsIterative(bt.root);
		
		System.out.println("====LEFT VIEW====");
		bt.leftView(bt.root);
		bt.leftView(bt.root);
		bt.leftViewIterative(bt.root);
		
		System.out.println("====RIGHT VIEW====");
		bt.rightView(bt.root);
		bt.rightView(bt.root);
		
		System.out.println("====VERTICAL ORDER====");
		bt.verticalOrder(bt.root);
	}

}
