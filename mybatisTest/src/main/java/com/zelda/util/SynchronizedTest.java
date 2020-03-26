package com.zelda.util;

/**
 * @author bu.han
 */
    public class SynchronizedTest {

    public static int num = 100;

    public static void main(String[] args) {
        Runner r = new Runner();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("name1 ");
        t2.setName("name2 ");

        t1.start();t2.start();
    }

    static class Runner implements Runnable {

        public  void run() {
            while (num > 0) {
                try {
                    synchronized(this) {
                        num -- ;
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+num);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}





