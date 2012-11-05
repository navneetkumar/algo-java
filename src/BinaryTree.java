import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.sun.org.apache.xpath.internal.operations.And;


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
			printTree(root.right);
			System.out.println(root.data);
			printTree(root.left);
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
		
		Queue<BTNode> queue = new ArrayBlockingQueue<BTNode>(100);
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
		String[][] str = new String[2*height-1][max_breadth];
		
		int start,distance;
		for(int level=0;level<height;level++){
			start = (int)(Math.pow(2.0, (double)(height - level-1)) - 1);
			distance = (int)Math.pow(2.0, (double)(height-level));
			Iterator<Integer> values = data[level].iterator();
			int str_level = level*2;
			boolean should_print_dashes = true;
			for(int x=start;x< max_breadth; x=x+distance){
				str[str_level][x] = String.format("%03d",values.next().intValue());
				if(str_level>0) str[str_level-1][x] = should_print_dashes ? "|  " : "  |";
				if(str_level>1){
					if(should_print_dashes){
						for(int y=x; y<=x+distance && y<max_breadth; y++){
							if(str[str_level-2][y] == null) str[str_level-2][y] = "---";
						}	
					}
					should_print_dashes = !should_print_dashes;	
				}
				
			}
		}
		print(str);
	}
	
	private void print(String[][] str){
		for(int m=0; m<str.length; m++){
			for(int n=0; n<str[m].length; n++){
				String value = str[m][n];
				if(value==null) value = "   ";
				System.out.print(value);
			}
			System.out.println("");
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
	public int replaceSum(BTNode root,int sum){
		if(root.right!=null) sum = replaceSum(root.right, sum);
		int root_data = root.data;
		root.data = sum;
		sum = sum + root_data;
		if(root.left!=null) sum= replaceSum(root.left, sum);
		return sum;
	}
	public boolean isBST(BTNode root){
		if(root!=null) {
			boolean isBST = true;
			if(root.left!=null) isBST = root.data > root.left.data;
			if(root.right!=null) isBST = isBST && root.data < root.right.data;
			return isBST(root.left) && isBST(root.right) && isBST;
		}
		else return true;
	}
	
	
	public BTNode findLCA(BTNode root, BTNode node1, BTNode node2){
		while(true && root!= null){
			if((root.data > node1.data && root.data < node2.data) || (root.data > node2.data && root.data < node1.data)) return root;
			if(root.data > node1.data) root = root.left;
			else root = root.right;
		}
		return new BTNode(-1, null, null);
	}
	private int random(){
		int result = (int)(Math.random()*10);
		if(result == 0) return random();
		else return result;
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
