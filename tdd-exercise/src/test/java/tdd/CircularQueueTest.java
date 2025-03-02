package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularQueueTest {

    private SimpleCircularQueue queue;

    @BeforeEach
    public void beforeEach() {
         queue = new SimpleCircularQueue(5);
    }

    @Test
    public void pushTest(){
        this.queue.push(1);
        this.queue.push(2);
        this.queue.push(3);
        this.queue.push(4);
        this.queue.push(5);
        this.queue.pop();
        assertEquals(2,this.queue.peek());
        this.queue.push(6);
        assertEquals(2,this.queue.peek());
        this.queue.push(7);
        this.queue.push(8);
        assertEquals(4,this.queue.peek());

    }
}
