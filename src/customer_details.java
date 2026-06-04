import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class customer_details extends JFrame implements ActionListener{

    JTable t1;
    JButton b1;
    String x[] = {"Emp Name","Meter No","Address","State","City","Email","Phone"};
    String y[][] = new String[20][7];
    DefaultTableModel model = new DefaultTableModel(x, 0);
    customer_details(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,200);

        try{
            conn c1  = new conn();
            String s1 = "select * from emp";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("meter_number"),
                        rs.getString("address"),
                        rs.getString("state"),
                        rs.getString("city"),
                        rs.getString("email"),
                        rs.getString("phone")
                });
            }

            t1 = new JTable(model);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load customer data.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }


        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args){
        new customer_details().setVisible(true);
    }

}