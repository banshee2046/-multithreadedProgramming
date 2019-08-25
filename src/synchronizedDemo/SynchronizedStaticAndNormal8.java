package synchronizedDemo;

//访问同一个类的静态synchronized方法和普通同步方法
public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 instance1 = new SynchronizedStaticAndNormal8();

    @Override
    public void run() {

        //同时访问两个方法的情况
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    //加了static之后实际上是类锁，不是一般的this的对象锁，所以该锁跟普通的对象锁不同，所以是两个不同的锁，执行可以并行执行
    public static void main(String[] args) {

        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance1);

        t1.start();
        t2.start();

        //等待两个线程执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    public static synchronized void method1() {
        System.out.println("我是静态加锁的方法1：我叫" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");

    }

    public synchronized void method2() {
        System.out.println("我是加锁的方法2：我叫" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");

    }
}
