import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class basics {
  public static void main(String[] args) {
    // Taking inputs:
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your name");
    String myName = scanner.nextLine();

    // Taking input using BufferedReader object
    System.out.println("Enter a number: ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String brInput = br.readLine();
    int num = Integer.parseInt(brInput);

    // Strings and String functions
    String name = "kumar ayush";

    int length = name.length();
    char letter = name.charAt(0);
    int index = name.indexOf(" ");
    int lastIndex = name.lastIndexOf("a");

    name = name.toUpperCase();

    // We can compare two strings using .equals(string_to_compare) function

    if (name.equals("kumar ayush")) {
      System.out.println("welcome");
    } else {
      System.out.println("access denied");
    }
    // we also have .equalsIgnoreCase("") function

    scanner.close();

  }

  // public int maxProfit(int[] prices){
  //
  // }
}
