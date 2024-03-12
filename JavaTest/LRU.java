import jdk.dynalink.beans.StaticClass;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class LRU<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public LRU(int capacity){
        super(capacity);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return this.size() > capacity;
    }
}

class test1{
    static LRU<Integer, Integer> mylru = new LRU<>(2);
    public static void main(String[] args) {
        System.out.println("start");

        for(int i = 0; i < 100; i++){
            mylru.put(i % 5, i);
        }

        System.out.println("over");
    }

}

class test2{
    static LRU<Integer, Integer> mylru = new LRU<>(2);

    public static void main(String[] args) {
        System.out.println("start");

        Thread thread1 = new Thread(new Mytask(1, 2));
        Thread thread2 = new Thread(new Mytask(2, 5));
        Thread thread3 = new Thread(new Mytask(3, 10));

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("over");
    }
    public static class Mytask implements Runnable{
        private final int key;
        private final int value;
        public Mytask(int key, int value){
            this.key = key;
            this.value = value;
        }
        @Override
        public void run() {
            for (int i = 0; i < value; i++) {
                mylru.put(key, i);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


