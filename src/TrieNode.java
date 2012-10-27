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
	
	public void print(){
		System.out.println("{ "+ data + ":{");
		for(TrieNode child:childs){
			System.out.println("{ "+ child.data + " }");
		}
	}

}
