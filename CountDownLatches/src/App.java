import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Process implements Runnable {
	private CountDownLatch latch;
	public Process(CountDownLatch latch){
		this.latch=latch;
	}
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
		latch.countDown();
	}
}
public class App {

	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(3);
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executorService.submit(new Process(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
