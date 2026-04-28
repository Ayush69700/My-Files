public class Arrays {
  public static void main(String[] args) {
    // Write a program to create a static array of 5 inetgers and multiply it with
    // constant value static variable. Multiplication should be done in multiply
    // method
    // and display final array in display method.

    int[] arr = new int[] { 1, 2, 3, 4, 5 };
    multiply(arr, 3);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void multiply(int[] arr, int constant) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] * constant;
    }
  }
}
