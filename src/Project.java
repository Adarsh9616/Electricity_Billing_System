import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;

public class Project extends JFrame implements ActionListener {
    Project(){
        super("Electricity Billing System");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        Color primary = new Color(25, 118, 210);
        Font menuFont = new Font("Segoe UI", Font.BOLD, 18);





        /* Adding background image */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("images/main.jpg"));
//        Image i3 = ic.getImage().getScaledInstance(1420, 720,Image.SCALE_SMOOTH);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        Image img = ic.getImage().getScaledInstance(
                screen.width,
                screen.height,
                Image.SCALE_SMOOTH
        );
        ImageIcon icc3 = new ImageIcon(img);
        JLabel l1 = new JLabel(icc3);
        add(l1);


        /* First Column */
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        master.setForeground(primary);
        mb.setFont(menuFont);
        master.setFont(menuFont);
        mb.setPreferredSize(new  Dimension(0,50));


        /* ---- Customer Details ---- */
        m1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/icon1.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('D');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        m1.setBackground(Color.WHITE);

        /* ---- Meter Details ---- */
        m2.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('M');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
        m2.setBackground(Color.WHITE);

        /* ---- Deposit Details  ----- */
        m3.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("images/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic('N');
        m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        m3.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        // --------------------------------------------------------------------------------------------


        /* Second Column */
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Calculate Bill");
        JMenuItem u3 = new JMenuItem("Last Bill");
        user.setForeground(primary);
        user.setFont(menuFont);

        /* ---- Pay Bill ---- */
        u1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("images/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('P');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        u1.setBackground(Color.WHITE);

        /* ---- Bill Details ---- */
        u2.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("images/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('B');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
        u2.setBackground(Color.WHITE);

        /* ---- Last Bill ----*/
        u3.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        u3.setIcon(new ImageIcon(image6));
        u3.setMnemonic('L');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        u3.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);


        // ---------------------------------------------------------------------------------------------

        /* Third Column*/
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        report.setForeground(primary);
        report.setFont(menuFont);

        /* ---- Report ---- */
        r1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("images/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        r1.setBackground(Color.WHITE);

        r1.addActionListener(this);

        // -----------------------------------------------------------------------------------------------

        /* Fourth Column*/
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(primary);
        utility.setFont(menuFont);

        /* ---- Calender ---- */
        ut1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("images/icon12.png"));
        Image image8 = icon8.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic('C');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        ut1.setBackground(Color.WHITE);

        /* ---- Calculator ---- */
        ut2.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("images/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic('X');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        ut2.setBackground(Color.WHITE);

        /* ---- Web Browser ---- */
        ut3.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("images/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic('W');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        ut3.setBackground(Color.WHITE);


        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        // ---------------------------------------------------------------------------------------

        /*Fifth Column */
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(primary);
        exit.setFont(menuFont);

        /* ---- Exit ---- */
        ex.setFont(new Font("Segoe UI",Font.PLAIN,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("images/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);


        // ---------------------------------------------------------------------------------------------


        master.add(m1);
        master.add(m2);
        master.add(m3);

        user.add(u1);
        user.add(u2);
        user.add(u3);

        report.add(r1);

        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        exit.add(ex);

        mb.add(master);
        mb.add(user);
        mb.add(report);
        mb.add(utility);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        switch (msg) {
            case "Customer Details":
                new customer_details().setVisible(true);
                break;

            case "New Customer":
                new new_customer().setVisible(true);
                break;

            case "Calculate Bill":
                new calculate_bill().setVisible(true);
                break;

            case "Pay Bill":
                new pay_bill().setVisible(true);
                break;

            case "Notepad":
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception e) {
                    showError("Unable to launch Notepad.\n" + e.getMessage());
                }
                break;

            case "Calculator":
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception e) {
                    showError("Unable to launch Calculator.\n" + e.getMessage());
                }
                break;

            case "Web Browser":
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://www.google.com")
                    );
                } catch (Exception e) {
                    showError("Unable to launch Browser.\n" + e.getMessage());
                }
                break;

            case "Generate Bill":
                new generate_bill().setVisible(true);
                break;

            case "Last Bill":
                new LastBill().setVisible(true);
                break;

            case "Exit":
                System.exit(0);
                break;

            default:
                showError("Unknown action: " + msg);
        }

    }


    public static void main(String[] args){
        new Project().setVisible(true);
    }

}