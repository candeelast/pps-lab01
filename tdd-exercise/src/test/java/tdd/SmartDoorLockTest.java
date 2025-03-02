package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SimpleSmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        smartDoorLock = new SimpleSmartDoorLock();
    }

    @Test
    public void testLockUnlock() {
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked()); // must be locked
        smartDoorLock.unlock((1234));
        assertFalse(smartDoorLock.isLocked()); //must be unlocked
    }

    @Test
    public void testBlock() {
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        smartDoorLock.unlock((1111));
        assertEquals(2, smartDoorLock.getMaxAttempts()); // must have lost an attempt
        smartDoorLock.unlock((1111));
        smartDoorLock.unlock((1111));
        assertTrue(smartDoorLock.isBlocked()); //must be blocked
    }
}
