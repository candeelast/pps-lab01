package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock {

    private final int totalAttempts = 3;
    private int pin;
    private int attempts;
    private boolean blocked;
    private boolean locked;

    public SimpleSmartDoorLock() {
        this.pin=-1; //pin has no value yet
        this.attempts = totalAttempts; //we give 3 attempts to write the pin correctly
        this.blocked = false;
        this.locked = false;
    }
    @Override
    public void setPin(int pin) {
        if( pin > 0 && pin < 9999 && !isBlocked() && !isLocked()) { // must have 4 digits and must not be blocked nor locked
            this.pin = pin;
        }

    }

    @Override
    public void unlock(int pin) {
        if( this.pin == pin ) this.locked = false;
        else if (attempts>0)
            attempts--;
            if(attempts==0) this.blocked = true;

    }

    @Override
    public void lock() {
        if (this.pin!=-1){
            this.locked = true;
        }
        else throw new IllegalStateException("The door cannot be locked without a pin");
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.attempts;
    }

    @Override
    public int getFailedAttempts() {
        return totalAttempts-this.attempts;
    }

    @Override
    public void reset() {
        this.pin=-1; //pin has no value yet
        this.attempts = totalAttempts; //we give 3 attempts to write the pin correctly
        this.blocked = false;
        this.locked = false;
    }


}
