public class Algorithm {
	int data = 1;

	public static void main(String[] args) {
		Algorithm algo = new Algorithm();
		algo.binaryTree();

	}
	
	public void binaryTree(){
		BTNode root = new BTNode(0, null, null);
		BinaryTree bt = new BinaryTree(root,4);
		bt.levelPrint();
	}

}
