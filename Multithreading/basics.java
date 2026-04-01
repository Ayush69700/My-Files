import java.util.*;

class Threads
{
	public static void main(String[] args){
		Thread t1 = Thread.currentThread();
		System.out.println(t1); // Output: [main,5,main] means:
					// main is the method
					// 5 is the thread priority
					// main is the group name

		// Thread life cycle:
		// Thread is born -----> | |Runnable State| and |Running State| | -----> Thread is dead
		// the unit | |Runnable State| and |Running State| | collectively is called the active state.	
	}
}

/*
class Five extends Thread
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("5* " + i + "= " + (5*i));
		}
	}
}

class Seven extends Thread
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("7* " + i + "= " + (7*i));
		}
	}
}

class Main
{
	public static void main(String[] args){
		Five f = new Five();
		Seven s = new Seven();
		f.start();
		// run is a method already there in the Thread parent class which we are overriding here.
		// start() method is used to bring a new born thread to a active state.
		s.start();
	}
}
*/


// Here we implement the Runnable class because it also contains the run() method that we want to override. 
//
class Five implements Runnable
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("5* " + i + "= " + (5*i));
		}
	}
}

class Seven implements Runnable
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("7* " + i + "= " + (7*i));
		}
	}
}

class Main
{
	public static void main(String[] args){
		Five f = new Five();
		Seven s = new Seven();

		Thread t1 = new Thread(f);
		Thread t2 = new Thread(s);

		t1.start();
		t2.start();
	}
}
