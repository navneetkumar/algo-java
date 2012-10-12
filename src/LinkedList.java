public class LinkedList {
	public LLNode head;
	public int length;

	public LinkedList(LLNode head, int length) {
		this.head = head;
		this.length = length;
		populate();

	}

	public void print() {
		for (LLNode iterator = head; iterator.next != null; iterator = iterator.next) {
			System.out.print(Integer.toString(iterator.data) + "-->");
		}
	}

	public void comparisnSort() {
		for (LLNode iterator = head; iterator.next != null; iterator = iterator.next) {
			for (LLNode iterator1 = iterator.next; iterator1.next != null; iterator1 = iterator1.next) {
				if (iterator.data > iterator1.data) swap(iterator, iterator1);
			}
			
		}
	}

	private void swap(LLNode source, LLNode target) {
		int tmp = target.data;
		target.data = source.data;
		source.data = tmp;
	}

	private void populate() {
		int i = 0;
		LLNode tmp = head;
		while (i < length) {
			tmp.next = new LLNode((int) (Math.random() * 100));
			tmp = tmp.next;
			i++;
		}
	}

}
