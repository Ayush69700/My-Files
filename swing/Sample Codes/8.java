import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int m;
    try {
      System.out.println("Enter a month number");
      m = Integer.parseInt(br.readLine());
      if (m < 1 || m > 12)
        throw new MonilException("valid numbers are 1-12");
      System.out.println("Month number is " + m);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid month number");
    }
  }
}

class MonilException extends Exception {
  MonilException(String s) {
    System.out.println(s);
  }
}
