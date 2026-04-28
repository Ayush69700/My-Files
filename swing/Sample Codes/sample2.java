import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage extends JFrame implements ActionListener {
  Container c;
  JLabel lblUsrName, lblPass;
  JTextField txtUsrName;
  JPasswordField txtPass;
  JButton btnSubmit, btnClear, btnExit;
  String strUsrName, strPass;

  LoginPage() {
    c = getContentPane();
    c.setLayout(new FlowLayout());

    lblUsrName = new JLabel("User Name");
    lblPass = new JLabel("Password");
    txtUsrName = new JTextField(10);
    txtPass = new JPasswordField(10);
    txtPass.setEchoChar('*');

    btnSubmit = new JButton("Submit");
    btnClear = new JButton("Clear");
    btnExit = new JButton("Exit");

    c.add(lblUsrName);
    c.add(txtUsrName);
    c.add(lblPass);
    c.add(txtPass);
    c.add(btnSubmit);
    c.add(btnClear);
    c.add(btnExit);

    // Adding action listeners to buttons:
    btnSubmit.addActionListener(this);
    btnClear.addActionListener(this);
    btnExit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSubmit) {
      strUsrName = txtUsrName.getText();
      strPass = txtPass.getText();
      if (strUsrName.equals("Gengayyy") && strPass.equals("Anna")) {
        JOptionPane.showMessageDialog(c, "Successful Login!");
        System.exit(0);
      } else {
        JOptionPane.showMessageDialog(c, "Login Failed!");
        txtUsrName.setText("");
        txtPass.setText("");
        txtUsrName.requestFocus();
      }
    } else if (e.getSource() == btnClear) {
      txtUsrName.setText("");
      txtPass.setText("");
      txtUsrName.requestFocus();
    } else {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    LoginPage log1 = new LoginPage();
    log1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    log1.setBounds(200, 200, 300, 300);
    log1.setResizable(false);
    log1.setTitle("Login");
    log1.setVisible(true);
  }
}
