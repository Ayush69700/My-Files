import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class KB extends JFrame implements KeyListener {
  Container c;
  JTextArea txt1;

  KB() {
    c = getContentPane();
    txt1 = new JTextArea(10, 20);
    c.add(txt1);
    txt1.addKeyListener(this);
  }

  public void keyPressed(KeyEvent ke) {
    txt1.append("Key Pressed\n");
  }

  public void keyReleased(KeyEvent ke) {
    txt1.append("Key Released\n");
  }

  public void keyTyped(KeyEvent ke) {
    txt1.append("Key Typed\n");
  }

  public static void main(String z[]) {
    KB frm = new KB();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setBounds(700, 300, 300, 200);
    frm.setVisible(true);
    frm.setTitle("KeyBoard Events");
  }
}
