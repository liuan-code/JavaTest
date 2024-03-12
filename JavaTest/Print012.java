public class Print012 {
    private static int state = 1;
    private final static Object lock = new Object();

    public static void main(String[] args) {
        Thread Print0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    synchronized (lock){
                        while(state % 2 != 1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(0);
                        state++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread Print1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++){
                    synchronized (lock){
                        while(state % 2 != 0 || state % 4 == 0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(state / 2);
                        state++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread Print2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++){
                    synchronized (lock){
                        while(state % 4 != 0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(state / 2);
                        state++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Print0.start();
        Print1.start();
        Print2.start();
    }
}
