import java.util.List;
import java.util.Vector;

class vectors {
  public static void main(String[] args) {
    // General Vector
    Vector myVector = new Vector();

    // Specify initial Capacity
    Vector<Integer> vector = new Vector(20);
    // Specify initial Capacity and Increment
    Vector<Integer> vector2 = new Vector(20, 5);

    myVector.addElement("hello");
    myVector.addElement(4);
    myVector.add(true);

    vector.addElement(21);
    vector.addElement(20);

    System.out.println("myVector: " + myVector);
    System.out.println("vector: " + vector);
  }
}
