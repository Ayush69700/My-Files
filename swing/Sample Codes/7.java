import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class QB extends JFrame implements ActionListener {
  Container c;
  JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
  JRadioButton rb1, rb2, rb3, rb4;
  ButtonGroup bg1;
  JButton btn1;

  QB() {
    c = getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

    lbl1 = new JLabel("Which is not the feature of Java");
    lbl2 = new JLabel("A. Object Oriented");
    lbl3 = new JLabel("B. Machine Dependent");
    lbl4 = new JLabel("C. Secured");
    lbl5 = new JLabel("D. Distributed");

    rb1 = new JRadioButton("A");
    rb2 = new JRadioButton("B");
    rb3 = new JRadioButton("C");
    rb4 = new JRadioButton("D");

    btn1 = new JButton("Submit");
    bg1 = new ButtonGroup();
    bg1.add(rb1);
    bg1.add(rb2);
    bg1.add(rb3);
    bg1.add(rb4);

    c.add(lbl1);
    c.add(lbl2);
    c.add(lbl3);
    c.add(lbl4);
    c.add(lbl5);

    c.add(rb1);
    c.add(rb2);
    c.add(rb3);
    c.add(rb4);
    c.add(btn1);
    btn1.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == btn1) {
      if (rb2.isSelected())
        JOptionPane.showMessageDialog(c, "Correct Answer");
      else
        JOptionPane.showMessageDialog(c, "Incorrect Answer");
    }
  }

  public static void main(String z[]) {
    QB frm = new QB();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setBounds(200, 200, 400, 400);
    frm.setVisible(true);
    frm.setTitle("MCQ");
  }
}
