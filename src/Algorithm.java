public class Algorithm {
	int data = 1;

	public static void main(String[] args) {
		Algorithm algo = new Algorithm();
		algo.binaryTree();
		algo.LinkedList();

	}
	
	public void binaryTree(){
		BTNode root = new BTNode(0, null, null);
		BinaryTree bt = new BinaryTree(root,4);
		bt.levelPrint();
	}
	
	public void LinkedList(){
		LLNode head = new LLNode(2);
		LinkedList ll = new LinkedList(head,10);
		System.out.println("Linked list is:");
		ll.print();
		System.out.println("\nLinked list after comparison sort:");
		ll.comparisnSort();
		ll.print();
	}

}
