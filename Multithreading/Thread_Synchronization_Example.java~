class Movie extends Thread
{
	int t=1, req;
	Movie(int req){
		req = this.req;
	}

	public synchronized void run(){
		if(req <= t){
			System.out.println("Ticket booked for " + Thread.currentThread().getName());
			try{
				Thread.sleep(100);
			}
			catch (Exception e){}
			t = t-req;
		}
		else {
			System.out.println("Tickets are Sold out!!" + Thread.currentThread().getName());
		}
	}
}

class Main
{
	public static void main(String[] args){
		Movie m = new Movie(1);
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);

		t1.setName("Jay");
		t2.setName("Veeru");
	}
}
