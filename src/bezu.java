import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;


class Surface extends JPanel implements ActionListener {
    int silnia(int i)
    {
        if (i==0)
            return 1;
        else
            return  i*silnia(i-1);
    }
    float do_potegi(float i, int j)
    {

        if (j==0)
        {
            return 1;
        }
        float zmienna=i;
        for (int z=1; z<j; z++)
        {
           zmienna*=i;
        }
        return  zmienna;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(14, 16, 19));
        g2d.fillRect(0, 0, 100000, 100000);
        g2d.setPaint(new Color(255, 255, 255));

        int[][] pkt=new int[3][2];
        int wynik_x;
        int wynik_y;

        pkt[0][0]=250;
        pkt[0][1]=150;
        pkt[1][0]=600;
        pkt[1][1]=350;
        pkt[2][0]=200;
        pkt[2][1]=550;
        for(float t=0; t<1; t+=0.00005f)
        {
            wynik_x=0;
            wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][1];

            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }
        pkt[0][0]=250;
        pkt[0][1]=150;
        pkt[1][0]=250;
        pkt[1][1]=400;
        pkt[2][0]=200;
        pkt[2][1]=550;
        for(float t=0; t<1; t+=0.0005f)
        {
            wynik_x=0;
            wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][1];

            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }
        pkt[0][0]=800;
        pkt[0][1]=150;
        pkt[1][0]=800;
        pkt[1][1]=400;
        pkt[2][0]=750;
        pkt[2][1]=550;
        for(float t=0; t<1; t+=0.0005f)
        {
            wynik_x=0;
            wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][1];

            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }
        pkt[0][0]=600;
        pkt[0][1]=100;
        pkt[1][0]=800;
        pkt[1][1]=200;
        pkt[2][0]=1000;
        pkt[2][1]=100;
        for(float t=0; t<1; t+=0.0005f)
        {
            wynik_x=0;
            wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*do_potegi(1-t, pkt.length-1-i)*do_potegi(t,i)*pkt[i][1];

            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class bezu extends JFrame {

    public bezu() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Inicjal");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                bezu ex = new bezu();
                ex.setVisible(true);
            }
        });
    }
}