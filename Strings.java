class Strings {
  public static void main(String[] args) {
    // two ways to initialize a string
    String myName = "kumar ayush";
    String myNewName = new String("Ayush");

    // String Buffers: (To allow mutability in string)
    // StringBuffer creates strings of flexible length and can be modified
    StringBuffer sb = new StringBuffer(myName);
    sb.reverse();
    String newMyName = new String(sb);
    System.out.println(newMyName);
    // primary difference between string buffer and string builder is thread safety
    // and performance
    // String Buffer is thread safe

    // Substrings
    System.out.println(newMyName.substring(6)); // if no end index provided, then it prints till last
    System.out.println(myName.toUpperCase());
    System.out.println(myName);

    System.out.println(capFirstLetter(myName));
  }

  public static String capFirstLetter(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }

    StringBuffer sb = new StringBuffer(str);

    for (int i = 0; i < sb.length(); i++) {
      if (i == 0) {
        sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
      } else if (sb.charAt(i) == ' ' && (i + 1) < sb.length()) {
        sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
        i++;
      }
    }
    return sb.toString();
  }

  // WAP to convert string to uppercase
  public static String ToUpperCase(String str) {
    StringBuffer sb = new StringBuffer(str);

    String ans = new String(sb);
    return ans;
  }
}
