//205588940
/**
 * This class is the Counter object.
 */
public class Counter {
    private int count;

    /**
     * Counstructor(inisilizing counter to 0).
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * This is another constructor with a given counter.
     * @param count the count.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * this method adds number to the current count.
     * @param number - The number.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * This method substructs number from the current count.
     * @param number - The number.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * This method gets the current count(A getter).
     * @return the current count.
     */
    public int getValue() {
        return this.count;
    }
}