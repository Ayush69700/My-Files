import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SqFinder extends JFrame implements ActionListener {
  Container c;
  JTextField txt1;
  JButton btn1;
  JLabel lbl1, lbl2;

  SqFinder() {
    c = getContentPane();
    c.setLayout(new FlowLayout());

    lbl1 = new JLabel("Enter a number");
    txt1 = new JTextField(10);
    btn1 = new JButton("Answer");
    lbl2 = new JLabel();

    c.add(lbl1);
    c.add(txt1);
    c.add(btn1);
    c.add(lbl2);
    btn1.addActionListener(this);
  }

  // actionPerformed method is actually a part of ActionListener interface
  // that we are overriding

  // When SqFinder constructor is called, btn1.addActionListener(this) registers
  // the window to listen to the button
  // Later, when a user clicks the button, the Java Swing framework automatically
  // fires an event and calls the actionPerformed method on the registered
  // listener.

  public void actionPerformed(ActionEvent e) {
    int a = Integer.parseInt(txt1.getText());
    float s = a * a;
    lbl2.setText("Square = " + s);
  }

  public static void main(String z[]) {
    SqFinder frm = new SqFinder();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setBounds(200, 200, 300, 250);
    frm.setVisible(true);
    frm.setTitle("Square Finder");
  }
}
