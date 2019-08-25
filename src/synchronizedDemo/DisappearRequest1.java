package synchronizedDemo;


//初步实现多线程编程
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();
    static int count = 0;

    DisappearRequest1(){

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //join方法会等待线程执行完再进行下一行
        //System.out.println("测试");
        t1.join();
        t2.join();
        //System.out.println("测试");

        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count ++ ;
        }
    }
}
