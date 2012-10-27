
public class Trie {
	public TrieNode root;
	public Trie(String str){
		this.root = new TrieNode(' ');
	}
	
	public void insert(String str){
		TrieNode current = this.root;
		for(int i=0;i< str.length();i++){
			char c = str.charAt(i);
			if( current.childAt(c) == null) current.addChild(c);
			current = current.childAt(c);
			if(i == str.length()-1) current.is_end = true;
		}
	}
	
	public void print(){
		this.root = new TrieNode('a');
		this.root.childs.add(new TrieNode('b'));
		this.root.print();
	}

}
