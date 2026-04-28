import java.util.*;

class oop {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // System.out.print("Enter number of players: ");
    // int n = Integer.parseInt(scanner.nextLine());
    // Player[] Alpha = new Player[n];
    //
    // System.out.println("Start Entering names of players~");
    // for (int i = 0; i < n; i++) {
    // Alpha[i] = new Player(scanner.nextLine());
    // }
    // for (int i = 0; i < n; i++) {
    // System.out.println(Alpha[i].name + " has health " +
    // Alpha[i].currentHealth());
    // }
    // System.out.println("Total player count: " + Player.playerCount);

    Static_class class1 = new Static_class();
    scanner.close();
  }
}

class Player {
  String name;
  private float health = 100;
  public static int playerCount;

  Player(String name) {
    this.name = name;
    playerCount++;
  }

  // overloaded constructor
  Player(String name, float health) {
    this.name = name;
    this.health = health;
  }

  public void damage1() {
    health -= 10;
  }

  public void damage2() {
    health -= 20;
  }

  public float currentHealth() {
    return health;
  }
}

public static class Static_class {
  public void foo(int num) {

  }
}
