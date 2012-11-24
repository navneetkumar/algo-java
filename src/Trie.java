public class Trie {
	public Trie(){
	}
	
	public void print(TrieNode root){
		print(root,0);
	}
	
	public TrieNode generate(String[] words){
		TrieNode root = new TrieNode('*');
		for(String word:words){
			root.insert(word);
		}
		return root;
		
	}
	
	private void print(TrieNode root, int depth){
		for(int i=0;i<depth-1;i++){
			System.out.print("|  ");
		}
		if(depth>0) System.out.print("|__");
		System.out.println(root.data);
		for(TrieNode child: root.childs){
			print(child,depth+1);
		}
	}
	
}
