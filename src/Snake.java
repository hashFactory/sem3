import javax.swing.*;
import java.awt.*;

public class Snake extends JApplet implements Runnable
{
    int count;

    int x_rectangles = 40;
    int y_rectangles = 40;

    int direction = 0; // 0 = up, 1 = down, 2 = right, 3 = left

    int[][] snake = new int[x_rectangles][y_rectangles];

    int x_apple = x_rectangles / 2;
    int y_apple = y_rectangles / 2;

    public void move()
    {
        // Find head




    }

    public void init()
    {
        snake[4][14] = 1;
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

        for (int i = 0; i < x_rectangles; i++)
        {
            for (int j = 0; j < y_rectangles; j++)
            {
                if (snake[i][j] != 0)
                {
                    g.setColor(Color.BLUE);
                    g.fillRect((int)(((double)getWidth() / (double)x_rectangles) * i), (int)(((double)getHeight() / (double)y_rectangles) * j), (int)((double)getWidth() / (double)x_rectangles), (int)((double)getHeight() / (double)y_rectangles));
                }

                g.setColor(Color.BLACK);
                g.drawLine((int)(((double)getWidth() / (double)x_rectangles) * i), 0, (int)(((double)getWidth() / (double)x_rectangles) * i), getHeight());
                g.drawLine(0, (int)(((double)getHeight() / (double)y_rectangles) * j), getWidth(), (int)(((double)getHeight() / (double)y_rectangles) * j));
            }
        }



        try
        {
            Thread.sleep(5);
        }
        catch (InterruptedException ex)
        { }

        count++;
        System.out.println(count);
    }

    public void run()
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        while (true)
        {
            repaint();

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ex)
            {

            }
        }
    }
}
