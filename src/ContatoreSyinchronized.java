public class ContatoreSyinchronized {
    private final Object lock = new Object();
    private int count = 0;

    public void increment() {
        synchronized (lock) {
            while (count < 5000) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}