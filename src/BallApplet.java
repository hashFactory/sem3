import javax.swing.*;
import java.awt.*;

public class BallApplet extends JApplet implements Runnable
{
    Ball ball;
    int count;

    public void init()
    {
        ball = new Ball(50, 50);
        setSize(1000, 700);
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
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

        g.setColor(Color.BLUE);

        ball.setxLocation();
        ball.setyLocation();

        g.fillOval(ball.getxLocation(), ball.getyLocation(), ball.size, ball.size);

        count++;
        System.out.println(count);
    }

    public void run()
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        while (true)
        {
            ball.setxSpeed();
            ball.setySpeed();

            repaint();

            try
            {
                Thread.sleep(2);
            }
            catch (InterruptedException ex)
            {

            }
        }
    }
}
