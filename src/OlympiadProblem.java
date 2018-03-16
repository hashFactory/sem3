import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OlympiadProblem
{
    private static int max = 0;
    private static int max_test = 40;

    private static int[] constant_powers = new int[max_test+1];
    private static int[][] value = new int[max_test+1][max_test+1];

    private static double n = 2;

    public static void main(String [] args)
    {
        populate_powers();

        for (var cap = 0; cap <= max_test; cap++)
        {
            var a = 0;
            var b = max;
            for (var i = max; i >= 0; i--)
            {
                var result = compute(a, b);

                var is_in_powers = false;
                var status = 0;

                for (var j = 0; j <= max_test; j++) {
                    if (result == constant_powers[j]) {
                        is_in_powers = true;
                        break;
                    }
                }
                if (result % 1 == 0 && is_in_powers)
                    status = 2;
                else if (result % 1 == 0)
                    status = 1;
                value[a][b] = status;
                a++;
                b--;
            }
            max++;
        }

        print();
        output_to_image();
    }

    private static double compute(int a, int b)
    {
        var a_double = (double)a;
        var b_double = (double)b;

        return (Math.pow(a_double, n) + Math.pow(b_double, n))/(Math.pow((a_double * b_double), n-1) + 1);
    }

    private static void populate_powers()
    {
        for (var i = 0; i <= max_test; i++)
        {
            constant_powers[i] = (int)Math.pow((double)i, (double)n);
        }
    }

    private static void print()
    {
        var prefix = "";
        var suffix = "";
        for (var i = 0; i <= max_test; i++)
        {
            for (var j = 0; j <= max_test; j++)
            {
                prefix = "";
                suffix = "";
                if (value[i][j] == 1)
                {
                    prefix = "\u001B[34m";
                    suffix = "\u001B[0m";
                }
                if (value[i][j] == 2)
                {
                    prefix = "\u001B[32m";
                    suffix = "\u001B[0m";
                }
                System.out.print(prefix + "\u2588" + suffix);
            }
            System.out.print("\n");
        }
    }

    private static void output_to_image()
    {
        BufferedImage image;
        image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        var g2 = (Graphics2D)image.getGraphics();

        var tile_width = (double)image.getWidth() / (double)(max_test + 1);
        var tile_height = (double)image.getHeight() / (double)(max_test + 1);

        for (var i = 0; i <= max_test; i++)
        {
            for (var j = 0; j <= max_test; j++)
            {
                if (value[i][j] == 2)
                    g2.setColor(Color.GREEN);
                else
                    g2.setColor(Color.lightGray);
                g2.fillRect((int)(tile_width * i), (int)(tile_height * j), (int)(tile_width) + 1, (int)(tile_height) + 1);
            }
        }

        var output = new File("saved.png");
        try {
            ImageIO.write(image, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
