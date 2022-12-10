public class Main {
    public static Counter c = new Counter(getRandom(), getRandom());

    public static int getRandom() {
        return (int) (Math.random() * 10000);
    }

    public static void printInitialInfo(int x, int y) {
        System.out.println("value of the first parameter before execution = " + c.getFirst());
        System.out.println("value of the second parameter before execution = " + c.getSecond());
        System.out.println("expected value are :");
        System.out.println(c.getFirst() + x - y);
        System.out.println(c.getSecond() - x + y);
    }

    public static void operationWithoutSync(int x, int y) throws InterruptedException {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= x; i++)
                            c.firstProcessNotSynced();
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= y; i++)
                            c.secondProcessNotSynced();
                    }
                }
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("results without syncing :");
        System.out.println(c);
    }

    public static void operationWithSync(int x, int y) throws InterruptedException {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= x; i++) {
                            c.firstProcessSynced();
                        }
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= y; i++) {
                            c.secondProcessSynced();
                        }
                    }
                }
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("results with syncing:");
        System.out.println(c);
    }

    public static void main(String[] args) throws InterruptedException {
        int x = getRandom();
        int y = getRandom();
        int default1 = c.getFirst();
        int default2 = c.getSecond();
        printInitialInfo(x, y);
        operationWithoutSync(x, y);
        c = new Counter(default1, default2);
        operationWithSync(x, y);
    }
}