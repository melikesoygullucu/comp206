import java.util.ArrayList;

public class LabStack {
    private ArrayList<Integer> stack;

    public LabStack() {
        stack = new ArrayList<Integer>(10);
    }
    public int size() {
        return stack.size();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        }
        int topValue = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return topValue;
    }

    public int top() {
        if (stack.isEmpty()) {
        	System.out.println("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public String toString() {
        return stack.toString();
    }
    public static void main(String[] args) {
    	LabStack stack1 = new LabStack();
		stack1.push(5);
		stack1.push(7);
		stack1.push(16);
		stack1.push(1);
		
		System.out.println(stack1);
		
		System.out.println(stack1.top());
		stack1.pop();
		stack1.pop();
		
		System.out.println(stack1);
	}
}
