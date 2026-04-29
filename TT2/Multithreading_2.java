
class Main {
  public static void main(String[] args) {
    java.util.Scanner s = new java.util.Scanner(System.in);
    System.out.print("How many times should each symbol print? ");
    int count = s.nextInt();

    Printer p = new Printer(count);

    AtThread t1 = new AtThread(p);
    DollarThread t2 = new DollarThread(p);

    t1.start();
    t2.start();

    s.close();
  }
}

class Printer {
  private boolean atTurn = true; // true = @'s turn, false = $'s turn
  private int count;

  Printer(int count) {
    this.count = count;
  }

  // Called by the @ thread
  public synchronized void printAt() {
    for (int i = 0; i < count; i++) {
      while (!atTurn) { // not my turn — wait
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("Thread interrupted!");
        }
      }
      System.out.print("@ ");
      atTurn = false; // hand the baton to $
      notify(); // wake up the $ thread
    }
  }

  // Called by the $ thread
  public synchronized void printDollar() {
    for (int i = 0; i < count; i++) {
      while (atTurn) { // not my turn — wait
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("Thread interrupted!");
        }
      }
      System.out.print("$ ");
      atTurn = true; // hand the baton back to @
      notify(); // wake up the @ thread
    }
  }
}

class AtThread extends Thread {
  Printer p;

  AtThread(Printer p) {
    this.p = p;
  }

  public void run() {
    p.printAt();
  }
}

class DollarThread extends Thread {
  Printer p;

  DollarThread(Printer p) {
    this.p = p;
  }

  public void run() {
    p.printDollar();
  }
}
