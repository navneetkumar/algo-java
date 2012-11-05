import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Algorithm {
	int data = 1;

	public static void main(String[] args) {
		Algorithm algo = new Algorithm();
		algo.outputToReadMe();
		algo.binaryTree();
		algo.binarySearchTree();
		algo.LinkedList();
		algo.sorting();
		//algo.trie();
	}
	
	public void outputToReadMe(){
		File file = new File("README");  
		FileOutputStream fis = null;
		try {
			fis = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		PrintStream out = new PrintStream(fis);
		System.setOut(out);
		System.out.println("This is a generated README file which shows the output of this repo.\n");
	}
	
	public void binaryTree(){
		System.out.println("\n*****Binary Tree*********\n");
		int height = 3;
		BTNode root = new BTNode(0, null, null);
		BinaryTree bt = new BinaryTree(root,height);
		System.out.println("Sample BT of height " + Integer.toString(height) + " is:");
		bt.levelPrint();
		System.out.println("Summation of all leave nodes:" + Integer.toString(bt.sumLeaves(root)));
		
		System.out.println("T1 is subtree of T2: " + Boolean.toString(bt.hasSubTree(root, root.left.right)));
		
		System.out.println("\nSample tree is BST: " + Boolean.toString(bt.isBST(root)));
		
	}
	
	public void binarySearchTree(){
		System.out.println("\n*****Binary Search Tree*********\n");
		int height = 4 ;
		BinaryTree bt = new BinaryTree(height);
		System.out.println("Sample BST of height " + Integer.toString(height) + " is:");
		BTNode root = bt.generateBST(height);
		bt.levelPrint(root);
		
		System.out.println("\nSample tree is BST: " + Boolean.toString(bt.isBST(root)));
		BTNode node1 = root.left;
		BTNode node2 = root.left.right;
		
		System.out.println("\nLCA of the node " + node1.toString() + " and " + node2.toString() +" in the BST is: " + bt.findLCA(root, node1, node2).toString());
		
		System.out.println("\nBST after replacement\n");
		bt.replaceSum(root,0);
		bt.levelPrint(root);
		
	}
	
	
	public void LinkedList(){
		System.out.println("\n*****Linked List*********\n");
		int length = 10;
		LLNode head = new LLNode(2);
		LinkedList ll = new LinkedList(head,10);
		System.out.println("Random Linked list of length " + Integer.toString(length) + " is:");
		ll.print();
		System.out.println("\nLinked list after comparison sort:");
		ll.comparisnSort();
		ll.print();
	}
	
	public void sorting(){
		System.out.println("\n\n*****Sorting*********\n");
		int length=5;
		Sorting sorter = new Sorting();
		int[] array = sorter.generateArray(length);

		System.out.println("A sample random array of length " + Integer.toString(length) + " is:");
		sorter.print(array);
		
		System.out.println("\nArray after bubble sort is :");
		sorter.print(sorter.bubbleSort(array));
		
		System.out.println("\nArray after selection sort is :");
		sorter.print(sorter.selectionSort(array));
		
		System.out.println("\nArray after insertion sort is :");
		sorter.print(sorter.insertionSort(array));
	}
	
	public void trie(){
		Trie trie = new Trie("abc");
//		trie.insert();
		trie.print();
	}
	
	public void sum(BTNode root){
		
	}

}
