package synchronizedDemo;

/**
 * 方法抛弃异常后，是否会释放锁，展示不抛出异常前和抛出异常后的对比：
 * 一旦抛出了异常，第二个线程会立刻进入同步方法，意味着锁已经同步释放
 */
public class SynchronizedException9 {
}
