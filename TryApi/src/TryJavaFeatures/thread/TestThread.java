package TryJavaFeatures.thread;

public class TestThread {
	public static void main(String[] args) throws InterruptedException {
	       // 启动子进程
        new MyThread("new thread").start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
            	MyThread th = new MyThread("joined thread");
                th.start();
                //th.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}