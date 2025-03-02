package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private SimpleMinMaxStack stack;
    @BeforeEach
    void beforeEach(){
        stack=new SimpleMinMaxStack();
    }
    @Test
    public void MinMaxTest() {
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertEquals(1,stack.getMin());
        assertEquals(3,stack.getMax());
        stack.pop();
        assertEquals(2,stack.getMin());
    }
}