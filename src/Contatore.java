public class Contatore {
    private int count = 0;

    public synchronized void increment() {
        while (count < 5000) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}