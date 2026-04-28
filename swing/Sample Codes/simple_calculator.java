import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {

  private JTextField display;
  private double firstOperand = 0;
  private String operator = "";
  private boolean startNewInput = true;

  private static final String[] BUTTON_LABELS = {
      "C", "+/-", "%", "÷",
      "7", "8", "9", "×",
      "4", "5", "6", "−",
      "1", "2", "3", "+",
      "0", ".", "="
  };

  private static final Color COLOR_DARK_BG = new Color(28, 28, 30);
  private static final Color COLOR_FUNC = new Color(58, 58, 60);
  private static final Color COLOR_OPERATOR = new Color(255, 159, 10);
  private static final Color COLOR_NUMBER = new Color(44, 44, 46);
  private static final Color COLOR_DISPLAY_BG = new Color(28, 28, 30);
  private static final Color COLOR_TEXT = Color.WHITE;
  private static final Color COLOR_DARK_TEXT = new Color(28, 28, 30);

  public Calculator() {
    setTitle("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setBackground(COLOR_DARK_BG);

    JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
    mainPanel.setBackground(COLOR_DARK_BG);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 16, 16, 16));

    // ── Display ──
    display = new JTextField("0");
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setFont(new Font("SF Pro Display", Font.PLAIN, 52));
    display.setForeground(COLOR_TEXT);
    display.setBackground(COLOR_DISPLAY_BG);
    display.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
    display.setPreferredSize(new Dimension(340, 90));
    mainPanel.add(display, BorderLayout.NORTH);

    // ── Button Grid ──
    JPanel buttonPanel = new JPanel(new GridBagLayout());
    buttonPanel.setBackground(COLOR_DARK_BG);
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.weightx = 1;
    gbc.weighty = 1;

    int col = 0, row = 0;
    for (int i = 0; i < BUTTON_LABELS.length; i++) {
      String label = BUTTON_LABELS[i];

      gbc.gridx = col;
      gbc.gridy = row;
      gbc.gridwidth = (label.equals("0")) ? 2 : 1;

      JButton btn = createButton(label);
      buttonPanel.add(btn, gbc);

      if (label.equals("0")) {
        col += 2;
      } else {
        col++;
      }
      if (col >= 4) {
        col = 0;
        row++;
      }
    }

    mainPanel.add(buttonPanel, BorderLayout.CENTER);
    add(mainPanel);
    pack();
    setSize(360, 560);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private JButton createButton(String label) {
    JButton btn = new JButton(label) {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        g2.dispose();
        super.paintComponent(g);
      }
    };

    btn.setFont(new Font("SF Pro Display", Font.PLAIN, 26));
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setContentAreaFilled(false);
    btn.setOpaque(false);
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btn.setPreferredSize(new Dimension(70, 70));

    // Color assignment
    if (label.equals("÷") || label.equals("×") || label.equals("−") || label.equals("+") || label.equals("=")) {
      btn.setBackground(COLOR_OPERATOR);
      btn.setForeground(COLOR_TEXT);
    } else if (label.equals("C") || label.equals("+/-") || label.equals("%")) {
      btn.setBackground(COLOR_FUNC);
      btn.setForeground(COLOR_TEXT);
    } else {
      btn.setBackground(COLOR_NUMBER);
      btn.setForeground(COLOR_TEXT);
    }

    // Hover effect
    Color base = btn.getBackground();
    btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        btn.setBackground(base.brighter());
      }

      @Override
      public void mouseExited(MouseEvent e) {
        btn.setBackground(base);
      }
    });

    btn.addActionListener(this);
    return btn;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();

    switch (cmd) {
      case "C" -> {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewInput = true;
      }
      case "+/-" -> {
        double val = Double.parseDouble(display.getText());
        display.setText(format(-val));
      }
      case "%" -> {
        double val = Double.parseDouble(display.getText());
        display.setText(format(val / 100));
        startNewInput = true;
      }
      case "÷", "×", "−", "+" -> {
        firstOperand = Double.parseDouble(display.getText());
        operator = cmd;
        startNewInput = true;
      }
      case "=" -> {
        double second = Double.parseDouble(display.getText());
        double result = switch (operator) {
          case "+" -> firstOperand + second;
          case "−" -> firstOperand - second;
          case "×" -> firstOperand * second;
          case "÷" -> second != 0 ? firstOperand / second : Double.NaN;
          default -> second;
        };
        display.setText(Double.isNaN(result) ? "Error" : format(result));
        operator = "";
        startNewInput = true;
      }
      case "." -> {
        if (startNewInput) {
          display.setText("0.");
          startNewInput = false;
        } else if (!display.getText().contains("."))
          display.setText(display.getText() + ".");
      }
      default -> { // digit
        if (startNewInput) {
          display.setText(cmd);
          startNewInput = false;
        } else {
          String current = display.getText();
          display.setText(current.equals("0") ? cmd : current + cmd);
        }
      }
    }
  }

  /**
   * Format: drop ".0" for whole numbers, otherwise show up to 10 sig-fig decimal
   * places.
   */
  private String format(double val) {
    if (val == Math.floor(val) && !Double.isInfinite(val))
      return String.valueOf((long) val);
    return String.valueOf(val);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(Calculator::new);
  }
}
