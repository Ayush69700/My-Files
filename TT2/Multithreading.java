class Main {
  public static void main(String[] args) throws InterruptedException {
    evenNumbers e = new evenNumbers();
    oddNumbers o = new oddNumbers();

    Thread t1 = new Thread(e);
    Thread t2 = new Thread(o);

    t1.start();
    t1.join();

    t2.start();
    t2.join();
  }
}

class evenNumbers implements Runnable {
  public void run() {
    for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
  }
}

class oddNumbers implements Runnable {
  public void run() {
    for (int i = 1; i <= 10; i++) {
      if (i % 2 != 0) {
        System.out.println(i);
      }
    }
  }
}
