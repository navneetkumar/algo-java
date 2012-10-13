public class Algorithm {
	int data = 1;

	public static void main(String[] args) {
		Algorithm algo = new Algorithm();
		algo.binaryTree();
		algo.LinkedList();

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

}
