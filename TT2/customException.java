import java.util.Scanner;

class MonthFormatException extends Exception {
  MonthFormatException(int month) {
    super(month + " is not a valid month. Please enter a number between 1-12.");
  }
}

class Main {
  public static void main(String[] args) throws MonthFormatException {
    System.out.println("Enter your birth-month");
    Scanner s = new Scanner(System.in);

    int month = s.nextInt();

    try {
      if (month < 1 || month > 12) {
        throw new MonthFormatException(month);
      }
    } catch (MonthFormatException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }

    s.close();
  }
}

// we can also make an un-checked exception class
class UncheckedMonthFormatException extends RuntimeException {

}

// Q2. Create a user defined exception InsufficientBalanceException for a bank
// account. Throw it when withdrawal amount exceeds balance.

class InsufficientBalanceException extends Exception {
  InsufficientBalanceException(int amount, int balance) {
    super("INSUFFICIENT BALANCE! \nBalance amount: " + balance + "\n" + "Withdrawal amount: " + amount);
  }
}

class Main_2 {
  public static void main(String[] args) throws InsufficientBalanceException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter withdrawal amount: ");
    int amount = scanner.nextInt();
    int balance = 10000;

    if (amount > balance) {
      throw new InsufficientBalanceException(amount, balance);
    } else
      System.out.println("Withdrawal successful! Current balance: " + (balance - amount));

    scanner.close();
  }
}
