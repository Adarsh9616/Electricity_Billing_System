

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p2,p4;

    login()
    {
        super("Login Page");
        l1=new JLabel("User Name");
        l2=new JLabel("Password");
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);

        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
        Image i1=ic1.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        b1=new JButton("Login",new ImageIcon(i1));

        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
        Image i2=ic2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        b2=new JButton("Cancel",new ImageIcon(i2));

        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("images/pop.jpg"));
        Image i3=ic3.getImage().getScaledInstance(340,370,Image.SCALE_SMOOTH);
        ImageIcon icc3=new ImageIcon(i3);

        l3=new JLabel(icc3);

        setLayout(new BorderLayout());


        p2=new JPanel();

        p4=new JPanel();

        add(l3,BorderLayout.WEST);
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p2,BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);

        p2.setBackground(Color.WHITE);
        p4.setBackground(Color.WHITE);


        setSize(640,450);
        setLocation(600,400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b2){
            dispose();
            return;
        }

        try{
            conn c1 = new conn();
            String Username  = tf1.getText();
            String Password =  String.valueOf(pf2.getPassword());
            /*String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";*/

            PreparedStatement ps = c1.c.prepareStatement("SELECT * from login where userName=? and password=?");
            ps.setString(1,Username);
            ps.setString(2,Password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                new Project().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password."
                );

                pf2.setText("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                    this,
                    "Login failed.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args){
        new login().setVisible(true);
    }

}
