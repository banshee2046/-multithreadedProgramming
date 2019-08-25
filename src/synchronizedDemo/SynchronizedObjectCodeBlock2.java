package synchronizedDemo;

//对象锁示例1 代码块模式
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    //新建两个对象，用以充当对象锁
    Object lock1 = new Object();
    Object lock2 = new Object();

    SynchronizedObjectCodeBlock2() {
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        //等待两个线程执行完毕
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        //保证了串行执行
//        synchronized (this) {
//            System.out.println("我是对象锁代码块形式。我叫" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"运行结束");
//        }
        synchronized (lock1) {
            System.out.println("我是对象锁代码块形式。我是lock1部分，叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
        //如果是两把锁的情况下，两个线程会拿到两个锁的情况
        //synchronized (lock2)
        synchronized (lock1) {
            System.out.println("我是对象锁代码块形式。我是lock2部分，叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}
