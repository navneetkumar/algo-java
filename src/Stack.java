public class Stack {
	public int[] dataArray;
	public int capacity=10;
	public int top=-1;
	
	public Stack(){
		this.dataArray = new int[capacity];
	}
	
	public void push(int data){
		doubleit();
		top++;
		dataArray[top] = data;
	}
	
	public int pop(){
		if(!isEmpty()){
			int topData = dataArray[top];
			dataArray[top] = 0;
			top--;
			return topData;
		}
		else return -1;
	}
	
	public boolean isEmpty(){
		return top<0;
	}
	public void print(){
		for(int i=top; i>=0 ;i--){
			System.out.println(Integer.toString(this.dataArray[i]));
			System.out.println("---");
		}
	}
	
	private void doubleit(){
		if(top >= capacity-1) {
			int[] tempArray = new int[this.capacity*2];
			System.arraycopy(this.dataArray, 0, tempArray, 0, capacity);
			this.dataArray = tempArray;
			this.capacity = capacity * 2;
		}
	}
	
	public void generateData(int depth){
		for(int i=1;i<=depth;i++){
			this.push(i);
		}
	}

}
