class Five implements Runnable
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("5* " + i + "= " + (5*i));
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
			}
		}
	}
}

class Seven implements Runnable
{
	public void run(){
		for(int i=1; i<=10; i++){
			System.out.println("7* " + i + "= " + (7*i));

			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
			}
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

// Thread Control:
class Numbers extends Thread
{
	public synchronized void run(){
		for(int i=1; i<10; i++){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e){}
		}
	}
}

class Main2
{
	public static void main(String[] args){
		Numbers n = new Numbers();
		Thread t1 = new Thread(n);
		Thread t2 = new Thread(n);
		t1.start();
		t2.start();
	}
}
