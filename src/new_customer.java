import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    new_customer(){
        super("Add Customer");
        setLocation(350,200);
        setSize(650,600);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));

        p.setBackground(Color.WHITE);

        l1 = new JLabel("Name");
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        t2 = new JTextField();
        p.add(l2);
        p.add(t2);
        l3 = new JLabel("Address");
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField();
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("City");
        t5 = new JTextField();
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField();
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        t7 = new JTextField();
        p.add(l7);
        p.add(t7);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("images/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 280,Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole 
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            dispose();
            return;
        }
//        String a = t1.getText();
//        String c = t2.getText();
//        String d = t3.getText();
//        String e = t4.getText();
//        String f = t5.getText();
//        String g = t6.getText();
//        String h = t7.getText();

        String name=t1.getText().trim();
        String meterNo=t2.getText().trim();
        String address=t3.getText().trim();
        String state=t4.getText().trim();
        String city=t5.getText().trim();
        String email=t6.getText().trim();
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email."
            );
            return;
        }
        String phone=t7.getText().trim();

        if(name.isEmpty() || meterNo.isEmpty() || address.isEmpty() || state.isEmpty() || city.isEmpty() || email.isEmpty() || phone.isEmpty()){
            JOptionPane.showMessageDialog(
                    this,
                    "All fields are required."
            );
            return;
        }
//        String q1 = "insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";

        try{
            conn c1 = new conn();
            PreparedStatement ps = c1.c.prepareStatement("insert into emp values(?,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,meterNo);
            ps.setString(3,address);
            ps.setString(4,state);
            ps.setString(5,city);
            ps.setString(6,email);
            ps.setString(7,phone);
            ps.executeUpdate();
//            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog(this,"Customer created successfully!");
            dispose();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to create customer.\n" + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }


    public static void main(String[] args){
        new new_customer().setVisible(true);
    }
}