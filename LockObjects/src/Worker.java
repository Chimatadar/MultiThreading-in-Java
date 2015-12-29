import java.util.*;
import java.util.ArrayList;

public class Worker {
	public Random random=new Random();
	Object lock1=new Object();
	Object lock2=new Object();
	
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2=new ArrayList<>();
	public void stageOne(){
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100));	
		}
		
	}
	public void stageTwo(){
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list2.add(random.nextInt(100));	
		}
		
	}
	
	public void startMethod(){
		stageOne();
		stageTwo();
	}
	public void main(String[] args) {
		
		long start=System.currentTimeMillis();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				startMethod();				
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				startMethod();				
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("Time taken:"+ (end-start));
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}

}
