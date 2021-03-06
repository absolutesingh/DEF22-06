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

	void leftViewUtil(Node root, int level) {
		if (root == null)
			return;

		if (level == levelToBePrinted) {
			System.out.print(root.data + " ");
			levelToBePrinted++;
		}

		leftViewUtil(root.left, level + 1);
		leftViewUtil(root.right, level + 1);
	}

	void leftView(Node root) {
		leftViewUtil(root, 0);

		// Preparing for the next time
		levelToBePrinted = 0;
		System.out.println();
	}

	// Nothing but BFS where we're printing the first level.
	void leftViewIterative(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			// find the number of nodes in current element
			int n = q.size();

			for (int i = 0; i < n; i++) // process these items
			{
				Node temp = q.poll();

				if (i == 0) // if it is the first element of current level
				{
					System.out.print(temp.data + " ");
				}
				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		System.out.println();
	}

	void rightViewUtil(Node root, int level) {
		if (root == null)
			return;

		if (level == levelToBePrinted) {
			System.out.print(root.data + " ");
			levelToBePrinted++;
		}

		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
	}

	void rightView(Node root) {
		rightViewUtil(root, 0);

		// Preparing for the next time
		levelToBePrinted = 0;
		System.out.println();
	}

//	--------------VERTICAL ORDER--------------

	int leftHD = 0; // leftmost horizontal distance
	int rightHD = 0; // rightmost horizontal distance

	void findHorizontalDistances(Node root, int hd) // hd -> Horizontal Distance
	{
		if (root == null)
			return;

		if (hd < leftHD) {
			leftHD = hd;
		}
		if (hd > rightHD) {
			rightHD = hd;
		}

		findHorizontalDistances(root.left, hd - 1);
		findHorizontalDistances(root.right, hd + 1);
	}

	void printVerticalLevel(Node root, int level, int hd) {
		if (root == null)
			return;

		if (level == hd) {
			System.out.print(root.data + " ");
		}

		printVerticalLevel(root.left, level, hd - 1);
		printVerticalLevel(root.right, level, hd + 1);
	}

	void verticalOrder(Node root) {
		findHorizontalDistances(root, 0); // To find the leftMost and rightMost horizontal distance from the root.

		for (int i = leftHD; i <= rightHD; i++) {
			printVerticalLevel(root, i, 0);
			System.out.println();
		}
	}

//	--------------ROOT TO LEAF PATH SUM--------------
//	https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1/
	boolean hasPathSum(Node root, int S) {
		if (root == null)
			return false;

		int pendingSum = S - root.data;

		if (pendingSum == 0 && root.left == null && root.right == null) {
			return true;
		}

		return hasPathSum(root.left, pendingSum) || hasPathSum(root.right, pendingSum);

		// boolean foundInLeft = false;
		// boolean foundInRight = false;

		// foundInLeft = hasPathSum(root.left, pendingSum);
		// foundInRight = hasPathSum(root.right, pendingSum);

		// return foundInLeft || foundInRight;
	}

//	--------------All Paths from root with a specified sum--------------
//	https://practice.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1/#
	public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> currentPath = new ArrayList<>();

		printPathsUtil(root, sum, currentPath, result);

		return result;
	}

	static void printPathsUtil(Node root, int sum, ArrayList<Integer> currentPath,
			ArrayList<ArrayList<Integer>> result) {
		if (root == null)
			return;

		currentPath.add(root.data);

		int pendingSum = sum - root.data;
		if (pendingSum == 0) {
			// Create a copy of currentPAth and store
			// To avoid unrequired updation of the same object as we're working with it
			result.add(new ArrayList<>(currentPath));
		}

		printPathsUtil(root.left, pendingSum, currentPath, result);

		printPathsUtil(root.right, pendingSum, currentPath, result);

		// Remove the last element and move back to parent
		currentPath.remove(currentPath.size() - 1);
	}

//  --------------Max Path Sum--------------
//  https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1/

	int maxPathSum = Integer.MIN_VALUE;

	// Function to return maximum path sum from any node in a tree.
	int findMaxSum(Node root) {
		findMaxSumUtil(root);
		return maxPathSum;
	}

	int findMaxSumUtil(Node root) {
		if (root == null)
			return 0;

		int leftMaxSum = findMaxSumUtil(root.left);
		int rightMaxSum = findMaxSumUtil(root.right);

		/*
		 * Cases: 1. Node only 2. Node + LST 3. Node + RST 4. Node + LST + RST
		 */

		int max_case123 = Math.max(root.data, root.data + Math.max(leftMaxSum, rightMaxSum));

		int maxAllCases = Math.max(max_case123, root.data + leftMaxSum + rightMaxSum);

		maxPathSum = Math.max(maxPathSum, maxAllCases);

		return max_case123;
	}

//  --------------DIAMETER--------------
//  https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1/
	int heightZeroWhenEmpty(Node root) {
		if (root == null)
			return 0;

		return 1 + Math.max(heightZeroWhenEmpty(root.left), heightZeroWhenEmpty(root.right));
	}

	// Function to return the diameter of a Binary Tree.
	int diameter(Node root) {
		if (root == null)
			return 0;

		// get the heights of LST and RST
		int lstHeight = heightZeroWhenEmpty(root.left);
		int rstHeight = heightZeroWhenEmpty(root.right);

		// get the left and right Diameter
		int lstDia = diameter(root.left);
		int rstDia = diameter(root.right);

		return Math.max(lstHeight + 1 + rstHeight, Math.max(lstDia, rstDia));
	}

	int maxDia;

	int heightForDiameter(Node root) {
		if (root == null)
			return 0;

		int leftHeight = heightForDiameter(root.left);
		int rightHeight = heightForDiameter(root.right);

		maxDia = Math.max(maxDia, leftHeight + 1 + rightHeight);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	int diameterOptimized(Node root) {
		maxDia = Integer.MIN_VALUE;
		if (root == null)
			return 0;
		heightForDiameter(root);
		return maxDia;
	}

//  --------------Binary Tree to Doubly Linked List--------------
//  https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
	Node prev = null;
	Node head = null;

	Node bToDLL(Node root) {
		bstToDLL(root);
		return head;
	}

	void bstToDLL(Node root) {
		if (root == null)
			return;

		// Inorder -> LVR
		bstToDLL(root.left); // L

		// Value
		if (prev == null) // For leftMost Node -> to be made new head
		{
			prev = root;
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
			prev = root;
		}

		bstToDLL(root.right);

	}

//  --------------Print all nodes at distance k from target--------------
//  https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1#	
	public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null || k < 0)
			return result; // empty list

		KDistanceNodesUtil(root, target, k, result); // this function will do the processing and fill the result list

		Collections.sort(result);
		return result;
	}

	static int KDistanceNodesUtil(Node root, int target, int k, ArrayList<Integer> result) {
		if (root == null)
			return -1;

		if (root.data == target) {
			KDistanceNodesInSubtree(root, k, result);
			return 0;
		}

		int leftDist = KDistanceNodesUtil(root.left, target, k, result);
		if (leftDist != -1) // we have found our target node in left subtree
		{
			if (leftDist + 1 == k)
				result.add(root.data); // this means our ancestor is at k distance
			else {
				KDistanceNodesInSubtree(root.right, k - 2 - leftDist, result);
			}

			return leftDist + 1; // we're going to parent
		}

		int rightDist = KDistanceNodesUtil(root.right, target, k, result);
		if (rightDist != -1) // we have found our target node in right subtree
		{
			if (rightDist + 1 == k)
				result.add(root.data); // this means our ancestor is at k distance
			else {
				KDistanceNodesInSubtree(root.left, k - 2 - rightDist, result);
			}

			return rightDist + 1; // we're going to parent
		}

		// element not found in both subtrees
		return -1;
	}

	static void KDistanceNodesInSubtree(Node root, int k, ArrayList<Integer> result) {
		if (root == null)
			return;

		if (k == 0)
			result.add(root.data);

		KDistanceNodesInSubtree(root.left, k - 1, result);
		KDistanceNodesInSubtree(root.right, k - 1, result);
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
