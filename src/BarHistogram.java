import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Bar
{
    int value = 0;
    int position = 0;


    public Bar(int _value, int _position)
    {
        value = _value;
        position = _position;
    }
}

public class BarHistogram extends JApplet implements Runnable, MouseListener
{
    public Bar[] bars = new Bar[30];

    public void create_bars()
    {
        for (int i = 0; i < bars.length; i++)
        {
            int value = (int)(Math.random() * 256);
            int position = i;

            bars[i] = new Bar(value, position);
        }
    }

    public void init()
    {
        create_bars();

        setSize(1000, 700);
        setBackground(Color.BLACK);
        setFocusable(true);

        addMouseListener(this);
    }

    public void start()
    {
        Thread th = new Thread(this);
        th.start();
    }

    public void stop()
    {

    }

    public void paint(Graphics g)
    {
        g.clearRect(0, 0, getWidth(), getHeight());

        int y_offset = 600;

        Bar largest = new Bar(0, 0);

        for (int i = 0; i < bars.length; i++)
        {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.setColor(new Color(bars[i].value / 2 + 128, bars[i].value / 2 + 128, bars[i].value / 2 + 128));
            g.fillRect((getWidth() / bars.length) * i, y_offset - bars[i].value, (getWidth() / bars.length), bars[i].value);

            if (bars[i].value > largest.value)
                largest = bars[i];
        }

        g.setColor(Color.RED);

        g.fillRect((getWidth() / bars.length) * largest.position, y_offset - largest.value, (getWidth() / bars.length), largest.value);

    }

    public void run()
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        while (true)
        {
            repaint();

            try
            {
                Thread.sleep(200 / 30);
            }
            catch (InterruptedException ex)
            {

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = getX();
        int y = getY();
        if (150 < x && x < 250)
            create_bars();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
