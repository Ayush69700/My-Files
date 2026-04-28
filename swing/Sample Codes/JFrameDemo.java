import java.awt.Color;
import javax.swing.*;

class JFrameDemo {
  public static void main(String z[]) {
    // JFrame = a GUI Window to add components to

    JFrame jf = new JFrame(); // Create a Frame / Window
    jf.setSize(800, 800); // Sets the size of the window
    jf.setLocation(100, 200); // Sets the location of the Jframe
    jf.setTitle("Swings Frame"); // Sets the title of the JFrame
    jf.setVisible(true); // Makes the Frame visible
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);

    // Changing the Logo of the window:
    ImageIcon icon = new ImageIcon("logo.jpg");
    jf.setIconImage(icon.getImage());
    jf.getContentPane().setBackground(Color.DARK_GRAY);
  }
}
