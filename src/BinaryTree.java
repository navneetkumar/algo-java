import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class BinaryTree {
	public BTNode root;
	public int height;
	int data = 1;
	
	public BinaryTree(BTNode root,int height){
		this.root = root;
		this.height	= height;
		populateTree(root,1);
		
	}
	
	public BinaryTree(int height){
		this.height = height;
		this.root = null;
	}
	
	public void printTree(){
		printTree(root);
	}
	
	public void levelPrint(){
		levelPrint(root);
	}
	
	private void populateTree(BTNode root, int level) {
		if (level < height) {
			insertNodes(root);
			populateTree(root.left, level + 1);
			populateTree(root.right, level + 1);
		}
	}
	
	public BTNode generateBST(int height){
		int length = (int)Math.pow(2,height) -1;
		int[] sortedArray = generateSortedArray(length);
		return midNode(sortedArray,0,length-1);
	}
	
	private BTNode midNode(int[] array,int start,int end){
		if(start == end) return new BTNode(array[start], null, null);
		else if(start < end) {
			int mid = (int)((start + end)/2);
			return new BTNode(array[mid], midNode(array, start, mid-1), midNode(array, mid+1, end)); 
		}
		else return null;
	}
	
	private int[] generateSortedArray(int length){
		int[] array = new int[length];
		array[0] = random();
		for(int i=1; i < array.length; i++){
			array[i] = array[i-1] + random();
		}
		return array;
	}

	private void insertNodes(BTNode root) {
		root.left = new BTNode(data++, null, null);
		root.right = new BTNode(data++, null, null);
	}

	private void printTree(BTNode root) {
		if (root != null) {
			System.out.println(root.data);
			printTree(root.left);
			printTree(root.right);
		}

	}
   /**
    * Prints a binary tree in level order traversal.
    * @param root
    */
	@SuppressWarnings("unchecked")
	public void levelPrint(BTNode root) {
		BTNode temp;
		LinkedList<Integer>[] data = (LinkedList<Integer>[])new LinkedList[height];
		data[0] = new LinkedList<Integer>();
		data[1] = new LinkedList<Integer>();
		
		Queue<BTNode> queue = new ArrayBlockingQueue<BTNode>(50);
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			data[level] = new LinkedList<Integer>();
			int size = queue.size();
			int i = 0;
			Integer.toString(i);
			while (i < size) {
				temp = queue.remove();
				data[level].add(temp.data);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				i++;
			}
			level++;
		}
		print(data);
	}
	
	public void print(LinkedList<Integer>[] data){
		int height = data.length;
		int max_breadth= (int)(Math.pow(2.0, (double)height) -1);
		String[][] str = new String[height][max_breadth];
		
		int start,distance;
		for(int level=0;level<height;level++){
			start = (int)(Math.pow(2.0, (double)(height - level-1)) - 1);
			distance = (int)Math.pow(2.0, (double)(height-level));
			Iterator<Integer> values = data[level].iterator();
			
			for(int x=start;x< max_breadth; x=x+distance){
				str[level][x] = String.format("%02d",values.next().intValue());
			}
		}
		print(str);
	}
	
	private void print(String[][] str){
		for(int m=0; m<str.length; m++){
			for(int n=0; n<str[m].length; n++){
				String value = str[m][n];
				if(value==null) value = "  ";
				System.out.print(value + " ");
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * Finds summation of all leaf nodes
	 * @param root
	 * @return
	 */
	public int sumLeaves(BTNode root){
		if(root.left == null && root.right == null) return root.data;
		else return sumLeaves(root.left) + sumLeaves(root.right);
	}
	
	public void sum(BTNode root){
//		root.data = Sum(root.left) + sum(root.right);
	}
	public int replaceSum(BTNode root){
		int root_data = root.data;
		if(root.right == null){
			root.data = 0;
			return root_data;
		}
		else {
			int right_sum = replaceSum(root.right);
			root.data = right_sum;
			root.left.data = right_sum + root_data;
			return right_sum + root_data + replaceSum(root.left);
		}
		
	}
	private int random(){
		return (int)(Math.random()*10);
	}
	/**
	 * Checks if T1 is a subTree of T2 or vice-versa.
	 * @param T1
	 * @param T2
	 * @return
	 */
	public boolean hasSubTree(BTNode T1, BTNode T2){
		return isSubTree(T1,T2) || isSubTree(T2,T1);
	}
	/**
	 * Find if whether supertree contains subtree or not
	 * @return
	 */
	public boolean isSubTree(BTNode superTree, BTNode subTree){
		if(superTree == subTree) return true;
		else if(superTree.left != null || superTree.right !=null) return (isSubTree(superTree.left,subTree) || isSubTree(superTree.right,subTree));
		else return false;
	}

}
