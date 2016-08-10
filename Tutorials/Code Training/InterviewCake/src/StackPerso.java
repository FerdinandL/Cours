public class StackPerso {
	
	public class Node {
		Integer value;
		Node next;
		
		public Node(Integer value){
			this.value = value;
			this.next = null;
		}
	}
	
	Node top;
	
	Integer pop(){
		if(top != null){
			Integer n = top.value;
			top = top.next;
			return n;
			}
		return null;
	}
	
	void push(Integer n){
		Node newtop = new Node(n);
		newtop.next = this.top;
		this.top = newtop;
	}
	
	Integer peek(){
		if (top != null) {
			return top.value;
		}
		return null;
	}
	
}