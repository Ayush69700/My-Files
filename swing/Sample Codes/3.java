import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Log2 extends JFrame implements ActionListener {
  Container c;
  JLabel lblUserName, lblPassWord;
  JTextField txtUserName;
  JPasswordField txtPassWord;
  JButton btnSubmit, btnClear, btnExit;
  String strUserName, strPassWord;

  Log2() {
    c = getContentPane();
    c.setLayout(new FlowLayout());

    lblUserName = new JLabel("User Name");
    lblPassWord = new JLabel("Password");
    txtUserName = new JTextField(10);
    txtPassWord = new JPasswordField(10);
    txtPassWord.setEchoChar('*');
    btnSubmit = new JButton("Submit");
    btnClear = new JButton("Clear");
    btnExit = new JButton("Exit");

    c.add(lblUserName);
    c.add(txtUserName);
    c.add(lblPassWord);
    c.add(txtPassWord);
    c.add(btnSubmit);
    c.add(btnClear);
    c.add(btnExit);

    btnSubmit.addActionListener(this);
    btnClear.addActionListener(this);
    btnExit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == btnSubmit) {
      strUserName = txtUserName.getText();
      strPassWord = txtPassWord.getText();
      if (strUserName.equals("KC") && strPassWord.equals("123")) {
        JOptionPane.showMessageDialog(c, "successful login");
        System.exit(0);
      } else {
        JOptionPane.showMessageDialog(c, "unsuccessful login");
        txtUserName.setText("");
        txtPassWord.setText("");
        txtUserName.requestFocus();
      }
    } else if (ae.getSource() == btnClear) {
      txtUserName.setText("");
      txtPassWord.setText("");
      txtUserName.requestFocus();
    } else {
      System.exit(0);
    }
  }

  public static void main(String z[]) {
    Log2 frm = new Log2();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setBounds(200, 200, 250, 300);
    frm.setVisible(true);
  }
}
