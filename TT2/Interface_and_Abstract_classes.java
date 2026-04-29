abstract class Animal {
  String name; // instance variable

  Animal(String name) { // constructor
    this.name = name;
  }

  abstract void makeSound(); // subclass MUST implement this

  void breathe() { // concrete method, inherited as-is
    System.out.println(name + " is breathing.");
  }
}

class Dog extends Animal {
  Dog(String name) {
    super(name);
  }

  @Override
  void makeSound() {
    System.out.println(name + " says: Woof!");
  }
}

// --------------------Interfaces----------------------//

interface Swimmable {
  void swim(); // implicitly public and abstract

  default void float_() { // default method (Java 8+)
    System.out.println("Floating on water.");
  }
}

interface Fetchable {
  void fetch(String item);
}

// A class can implement MULTIPLE interfaces
class Labrador extends Animal implements Swimmable, Fetchable {
  Labrador(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println("Woof!");
  }

  @Override
  public void swim() {
    System.out.println(name + " is swimming!");
  }

  @Override
  public void fetch(String item) {
    System.out.println(name + " fetched the " + item + "!");
  }
}
