import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MySqFinder extends JFrame implements ActionListener {
  Container c;
  JTextField txt1;
  JButton btn1;
  JLabel lbl1, lbl2;

  MySqFinder() {
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

  public void actionPerformed(ActionEvent e) {

  }
}

class Main {
  public static void main(String[] args) {
    MySqFinder frm = new MySqFinder();

    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setBounds(200, 200, 250, 150);
    frm.setVisible(true);
    frm.setTitle("Square Finder");
  }
}
