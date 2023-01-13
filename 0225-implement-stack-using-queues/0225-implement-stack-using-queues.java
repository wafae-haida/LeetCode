class MyStack{
    Deque<Integer> deque;
    
    MyStack(){
        deque=new ArrayDeque<>();
    }
    void push(int x){
        deque.addLast(x);
    }
	int pop(){
	    int res=deque.getLast();
	    deque.removeLast();
        return res;
	}
    int top(){
	    return deque.getLast();
	}
    boolean empty(){
		return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */