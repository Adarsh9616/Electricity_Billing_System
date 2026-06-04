import java.awt.*;
import javax.swing.*;
public class splash
{
    public static void main(String args[])
    {
        fframe f1=new fframe();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x++)
        {
            f1.setLocation(800-((i+x)/2),500-(i/2));
            f1.setSize((i+x),i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
    public static class fframe extends JFrame implements Runnable
    {
        private Thread splashThread;
        private static final int SPLASH_DURATION = 7000;
        fframe()
        {
            super("Electricity Billing System");
            setLayout(new FlowLayout());
            ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("images/splash.jpg"));
            Image i1=c1.getImage().getScaledInstance(720,550,Image.SCALE_SMOOTH);
            ImageIcon i2=new ImageIcon(i1);

            JLabel l1=new JLabel(i2);
            add(l1);
            splashThread=new Thread(this);
            splashThread.start();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void run()
        {
            try
            {
                Thread.sleep(SPLASH_DURATION);
                dispose();
                new login().setVisible(true);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Unable to load application.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

}
