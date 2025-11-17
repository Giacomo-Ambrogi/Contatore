public class Main {
    public static void main(String[] args) {
        //main senza classe contatore sincronizzata
        Contatore c = new Contatore();
        Thread t1 = new Thread(() -> c.increment());
        Thread t2 = new Thread(() -> c.increment());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Conteggio finale: " + c.getCount());

        //main con classe contatore sincronizzata
        ContatoreSyinchronized contSync = new ContatoreSyinchronized();

        // Create multiple threads to increment the counter
        Thread t3 = new Thread(() -> contSync.increment());
        Thread t4 = new Thread(() -> contSync.increment());

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Conteggio finale synchronized: " + contSync.getCount());
    }
}