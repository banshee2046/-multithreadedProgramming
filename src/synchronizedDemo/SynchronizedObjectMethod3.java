package synchronizedDemo;


//      对象锁示例2，方法锁
public class SynchronizedObjectMethod3 implements Runnable {

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

    public static void main(String[] args) {

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        //等待两个线程执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    @Override
    public void run() {

        method();
    }

    public synchronized void method() {
        System.out.println("对象锁的方法修饰符形式，我是" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
