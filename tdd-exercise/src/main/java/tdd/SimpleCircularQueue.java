package tdd;

import java.util.ArrayList;
import java.util.List;

public class SimpleCircularQueue implements CircularQueue {
    private List<Integer> queue;
    private final int capacity;

    public SimpleCircularQueue(int capacity) {
        this.capacity=capacity;
        this.queue = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        if(queue.size()>=capacity) {
            queue.remove(0); // we remove the oldest element
            queue.add(value);
        }
        else queue.add(value);
    }

    @Override
    public int pop() {
        return queue.remove(0);
    }

    @Override
    public int peek() {
        return queue.get(0);
    }
}
