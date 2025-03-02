package tdd;
import java.util.Stack;

public class SimpleMinMaxStack implements MinMaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public SimpleMinMaxStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.maxStack = new Stack<>();

    }

    @Override
    public void push(int value) {
        this.stack.push(value);
        if(this.minStack.isEmpty()) this.minStack.push(value);
        else if(this.getMin()>value){ //new value is smaller
            this.minStack.push(value);
        }
        if(this.maxStack.isEmpty()) this.maxStack.push(value);
        else if(this.getMax()<value){ //new value is bigger
            this.maxStack.push(value);
        }
    }

    @Override
    public int pop() {
        if(!this.stack.isEmpty()){
            if (this.getMin()==this.stack.peek()) this.minStack.pop();
            if (this.getMax()==this.stack.peek()) this.maxStack.pop();
            return this.stack.pop();
        }
        else throw new IllegalStateException("The stack is empty");
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        if(!this.minStack.isEmpty()) return this.minStack.peek();
        else throw new IllegalStateException("The stack is empty");
    }

    @Override
    public int getMax() {
        if(!this.maxStack.isEmpty()) return this.maxStack.peek();
        else throw new IllegalStateException("The stack is empty");
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
