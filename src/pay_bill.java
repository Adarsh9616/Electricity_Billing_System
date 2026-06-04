import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;

public class pay_bill extends JFrame{
    pay_bill(){
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            Desktop.getDesktop().browse(
                    new URI("https://paytm.com/electricity-bill-payment")
            );
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>"+
                "<h2>Unable to load payment page</h2>"+
                    "<p>Please check your internet connection.</p>"+
                    "</html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        pack();
        setLocation(250,120);

    }
    public static void main(String[] args){
        new pay_bill().setVisible(true);
    }
}