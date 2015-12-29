package demo2;
class Runner implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			System.out.println("Thread"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
public class App {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runner());
		t1.start();
		Thread t2=new Thread(new Runner());
		t2.start();
	}

}
