import java.util.Stack;

public class MaxStack {
	
	Stack<Integer> stack;
	Stack<Integer> maxStack;
	
	// Penser a inclure les constructeurs null de Stack dans le constructeur de MaxStack
	// Sinon, nullpointerexception
	MaxStack() {
		this.stack = new Stack<Integer>();
		this.maxStack = new Stack<Integer>();
	}
	
	// Overwriting pop
	int pop(){
		
		int n = this.stack.pop();
		if (n == (int) maxStack.peek())
			this.maxStack.pop();
		return n;
	}
	
	// Overwriting push
	void push(int n){
		
		stack.push(n);
		
		if (maxStack.empty() || n >= (int) maxStack.peek())
			this.maxStack.push(n);
		
		return;
	}
	
	//getMax
	int getMax(){
		return (int)this.maxStack.peek();
	}
	
	public static void main(String[] args) {
		MaxStack mstack = new MaxStack();
		mstack.push(1);
		mstack.push(4);
		mstack.push(5);
		mstack.push(3);
		mstack.push(6);
		mstack.push(2);
		mstack.push(6);
		
		System.out.println(mstack.getMax());
		mstack.pop(); mstack.pop(); mstack.pop();
		System.out.println(mstack.getMax());
	}

}
