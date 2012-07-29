
public class Algorithm {

	public static void main(String[] args) {
		
		BTNode left = new BTNode(2,null,null);
		BTNode right = new BTNode(3,null,null);
		BTNode root = new BTNode(1,left,right);
		System.out.println(root.right.data);
		
	}

}
