package synchronizedDemo;

//同时访问同步方法synchronized和非同步方法
public class SynchronizedYesAndNo6 implements Runnable {
    static SynchronizedYesAndNo6 instance1 = new SynchronizedYesAndNo6();
    static SynchronizedYesAndNo6 instance2 = new SynchronizedYesAndNo6();

    @Override
    public void run() {

        //同时访问两个方法的情况
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();

        //等待两个线程执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法：我叫" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");

    }

    public void method2() {
        System.out.println("我是没加锁的方法：我叫" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");

    }
}
