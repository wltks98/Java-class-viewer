class MyStack {
	private int size;
	private int top;
	private int[] data;
	
	public MyStack(int size) {
		data=new int[size];
		this.size=size;
		top=0;
	}

	public void push(int v) {
		if( !isFull()) data[top++]=v;
		else
			System.out.println("Stack is full");
	}
	
	public int pop() {
		if(!isEmpty()) return data[--top];
		else
			return-1;
	}
	
	public boolean isFull() {
		if(top>=size) return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(top==0) return true;
		else return false;
	}
	
}
