import java.util.LinkedList;
public class TrieNode {
	public char data;
	public boolean is_end;
	public LinkedList<TrieNode> childs;
	
	public TrieNode(char data){
		this.data = data;
		this.is_end	= false;
		this.childs = new LinkedList<TrieNode>();
	}
	
	public TrieNode childAt(char c){
		if(this.childs != null){
			for(TrieNode child:childs){
				if(child.data == c) return child;
			}
		}
		return null;
	}
	
	public void addChild(char c){
		this.childs.add(new TrieNode(c));
	}
	
	public TrieNode insert(String str){
		TrieNode current = this;
		for(int i=0;i< str.length();i++){
			char c = str.charAt(i);
				if( current.childAt(c) == null) current.addChild(c);
				current = current.childAt(c);	
			if(i == str.length()-1) current.is_end = true;
		}
		return this;
	}

}
