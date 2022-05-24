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
		//When queue becomes empty means the BFS has completed.
		
		System.out.println();
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
	}

}
