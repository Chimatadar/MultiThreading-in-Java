package demo1;

class Runner extends Thread{
	public void run(){
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
		Runner runner1=new Runner();
		runner1.start();
		Runner runner2=new Runner();
		runner2.start();
	}

}
