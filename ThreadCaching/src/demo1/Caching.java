package demo1;

import java.util.Scanner;

class Runner extends Thread{
	private volatile boolean running=true;
	public void run() {
		while (running) {
			System.out.println("Thread Running");
			try {
				Thread.sleep(100);	
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
	
	public void shutDown(){
		running=false;
	}
}
public class Caching {

	public static void main(String[] args) {
		Runner runner=new Runner();
		runner.start();
		
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		
		runner.shutDown();
	}

}
