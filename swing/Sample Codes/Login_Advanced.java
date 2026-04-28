import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.text.JTextComponent;

class LoginPage extends JFrame {

    // ÄÄ Palette ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    private static final Color BG_TOP        = new Color(15,  23,  42);   // dark navy
    private static final Color BG_BOTTOM     = new Color(30,  41,  59);
    private static final Color CARD_BG       = new Color(30,  41,  59, 220);
    private static final Color ACCENT        = new Color(99, 102, 241);   // indigo
    private static final Color ACCENT_HOVER  = new Color(129, 140, 248);
    private static final Color FIELD_BG      = new Color(15,  23,  42);
    private static final Color FIELD_BORDER  = new Color(71,  85, 105);
    private static final Color FIELD_FOCUS   = new Color(99, 102, 241);
    private static final Color TEXT_PRIMARY  = new Color(248, 250, 252);
    private static final Color TEXT_MUTED    = new Color(148, 163, 184);
    private static final Color DANGER        = new Color(239,  68,  68);

    // ÄÄ Fields ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    private RoundedField  txtUsername;
    private RoundedField  txtPassword;
    private JLabel        lblError;
    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);                     // frameless window
        setSize(420, 520);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, 420, 520, 24, 24));

        GradientPanel root = new GradientPanel(BG_TOP, BG_BOTTOM);
        root.setLayout(new GridBagLayout());
        setContentPane(root);

        // ÄÄ Drag-to-move ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
        MouseAdapter drag = new MouseAdapter() {
            Point origin;
            public void mousePressed(MouseEvent e)  { origin = e.getPoint(); }
            public void mouseDragged(MouseEvent e)  {
                Point loc = getLocation();
                setLocation(loc.x + e.getX() - origin.x,
                            loc.y + e.getY() - origin.y);
            }
        };
        root.addMouseListener(drag);
        root.addMouseMotionListener(drag);

        // ÄÄ Card ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
        JPanel card = new JPanel() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(CARD_BG);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(40, 40, 40, 40));
        card.setPreferredSize(new Dimension(360, 440));

        // Avatar icon
        JLabel avatar = new JLabel() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                // Circle background
                g2.setColor(ACCENT);
                g2.fillOval(0, 0, 60, 60);
                // Simple person silhouette
                g2.setColor(TEXT_PRIMARY);
                g2.fillOval(18, 10, 24, 22);           // head
                g2.fillRoundRect(10, 36, 40, 24, 20, 20); // body
                g2.dispose();
            }
            @Override public Dimension getPreferredSize() { return new Dimension(60, 60); }
        };
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title
        JLabel title = new JLabel("Welcome back");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(TEXT_PRIMARY);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Sign in to your account");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_MUTED);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Error label (hidden by default)
        lblError = new JLabel(" ");
        lblError.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblError.setForeground(DANGER);
        lblError.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Fields
        txtUsername = new RoundedField("Username", false);
        txtPassword = new RoundedField("Password", true);

        // Submit button
        PillButton btnLogin = new PillButton("Sign In", ACCENT, ACCENT_HOVER, TEXT_PRIMARY);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bottom links row
        JPanel linkRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        linkRow.setOpaque(false);
        linkRow.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnClear = linkButton("Clear");
        JButton btnExit  = linkButton("Exit");
        linkRow.add(btnClear);
        linkRow.add(new JLabel("ú") {{ setForeground(TEXT_MUTED); }});
        linkRow.add(btnExit);

        // ÄÄ Assemble card ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
        card.add(avatar);
        card.add(Box.createRigidArea(new Dimension(0, 16)));
        card.add(title);
        card.add(Box.createRigidArea(new Dimension(0, 4)));
        card.add(subtitle);
        card.add(Box.createRigidArea(new Dimension(0, 24)));
        card.add(txtUsername);
        card.add(Box.createRigidArea(new Dimension(0, 12)));
        card.add(txtPassword);
        card.add(Box.createRigidArea(new Dimension(0, 8)));
        card.add(lblError);
        card.add(Box.createRigidArea(new Dimension(0, 16)));
        card.add(btnLogin);
        card.add(Box.createRigidArea(new Dimension(0, 16)));
        card.add(linkRow);

        root.add(card);

        // ÄÄ Listeners ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
        btnLogin.addActionListener(e -> handleLogin());
        btnClear.addActionListener(e -> clearFields());
        btnExit.addActionListener(e -> System.exit(0));

        // Enter key submits
        KeyAdapter enterKey = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) handleLogin();
            }
        };
        txtUsername.field.addKeyListener(enterKey);
        txtPassword.field.addKeyListener(enterKey);
    }

    // ÄÄ Login logic ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    private void handleLogin() {
        String user = txtUsername.getText();
        String pass = txtPassword.getText();
        if (user.equals("Gengayyy") && pass.equals("Anna")) {
            JOptionPane.showMessageDialog(this, "Successful Login! ??",
                    "Welcome", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            lblError.setText("Invalid username or password.");
            txtUsername.field.setBorder(errorBorder());
            txtPassword.field.setBorder(errorBorder());
            shake(this);
        }
    }

    private void clearFields() {
        txtUsername.clear();
        txtPassword.clear();
        lblError.setText(" ");
        txtUsername.field.setBorder(normalBorder());
        txtPassword.field.setBorder(normalBorder());
    }

    // ÄÄ Borders ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    static Border normalBorder() {
        return BorderFactory.createCompoundBorder(
            new RoundBorder(FIELD_BORDER, 10),
            new EmptyBorder(8, 12, 8, 12));
    }
    static Border focusBorder() {
        return BorderFactory.createCompoundBorder(
            new RoundBorder(FIELD_FOCUS, 10),
            new EmptyBorder(8, 12, 8, 12));
    }
    static Border errorBorder() {
        return BorderFactory.createCompoundBorder(
            new RoundBorder(DANGER, 10),
            new EmptyBorder(8, 12, 8, 12));
    }

    // ÄÄ Shake animation ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    private static void shake(JFrame frame) {
        Point origin = frame.getLocation();
        Timer t = new Timer(30, null);
        int[] steps = {-8, 8, -6, 6, -4, 4, -2, 2, 0};
        int[] idx = {0};
        t.addActionListener(e -> {
            if (idx[0] >= steps.length) { t.stop(); frame.setLocation(origin); return; }
            frame.setLocation(origin.x + steps[idx[0]++], origin.y);
        });
        t.start();
    }

    // ÄÄ Link-style button helper ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    private static JButton linkButton(String text) {
        JButton b = new JButton(text);
        b.setForeground(TEXT_MUTED);
        b.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { b.setForeground(TEXT_PRIMARY); }
            public void mouseExited(MouseEvent e)  { b.setForeground(TEXT_MUTED);   }
        });
        return b;
    }

    // ÄÄ Entry point ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
    public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ignored) {
    }
    SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
  }

  // =========================================================================
  // Inner components
  // =========================================================================

  /** Gradient background panel */
  static class GradientPanel extends JPanel {
    private final Color top, bottom;

    GradientPanel(Color top, Color bottom) {
      this.top = top;
      this.bottom = bottom;
      setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(new GradientPaint(0, 0, top, 0, getHeight(), bottom));
      g2.fillRect(0, 0, getWidth(), getHeight());
    }
  }

  /** Rounded text / password field with floating label feel */
  static class RoundedField extends JPanel {
    final JTextComponent field;

    RoundedField(String placeholder, boolean isPassword) {
      setOpaque(false);
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setAlignmentX(Component.CENTER_ALIGNMENT);
      setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

      JLabel lbl = new JLabel(placeholder);
      lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      lbl.setForeground(TEXT_MUTED);
      lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

      field = isPassword ? new JPasswordField() : new JTextField();
      field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      field.setForeground(TEXT_PRIMARY);
      field.setCaretColor(TEXT_PRIMARY);
      field.setBackground(FIELD_BG);
      field.setOpaque(true);
      field.setBorder(normalBorder());
      field.setAlignmentX(Component.LEFT_ALIGNMENT);
      field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

      field.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
          field.setBorder(focusBorder());
        }

        public void focusLost(FocusEvent e) {
          field.setBorder(normalBorder());
        }
      });

      add(lbl);
      add(Box.createRigidArea(new Dimension(0, 4)));
      add(field);
    }

    String getText() {
      if (field instanceof JPasswordField)
        return new String(((JPasswordField) field).getPassword());
      return ((JTextField) field).getText();
    }

    void clear() {
      if (field instanceof JPasswordField)
        ((JPasswordField) field).setText("");
      else
        ((JTextField) field).setText("");
      field.setBorder(normalBorder());
    }
  }

  /** Pill-shaped button with hover effect */
  static class PillButton extends JButton {
    private final Color normal, hover, fg;
    private Color current;

    PillButton(String text, Color normal, Color hover, Color fg) {
      super(text);
      this.normal = normal;
      this.hover = hover;
      this.fg = fg;
      current = normal;
      setFont(new Font("Segoe UI", Font.BOLD, 14));
      setForeground(fg);
      setFocusPainted(false);
      setBorderPainted(false);
      setContentAreaFilled(false);
      setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
      setPreferredSize(new Dimension(280, 44));
      addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
          current = hover;
          repaint();
        }

        public void mouseExited(MouseEvent e) {
          current = normal;
          repaint();
        }
      });
    }

    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(current);
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
      g2.dispose();
      super.paintComponent(g);
    }
  }

  /** Custom round border */
  static class RoundBorder extends AbstractBorder {
    private final Color color;
    private final int radius;

    RoundBorder(Color color, int radius) {
      this.color = color;
      this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g,
        int x, int y, int w, int h) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(color);
      g2.setStroke(new BasicStroke(1.5f));
      g2.drawRoundRect(x, y, w - 1, h - 1, radius * 2, radius * 2);
      g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
      return new Insets(radius, radius, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets i) {
      i.set(radius, radius, radius, radius);
      return i;
    }
  }
}
