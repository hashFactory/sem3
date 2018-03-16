import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Triangular extends JPanel implements ActionListener
{
    JButton triangle;
    JTextField number;
    JTextArea result;
    JButton _100;

    public Triangular()
    {
        triangle = new JButton("Triangle Number?");
        number = new JTextField("", 20);
        result = new JTextArea(2, 20);
        _100 = new JButton("100");

        add(number);
        add(triangle);
        add(result);
        add(_100);

        triangle.addActionListener(this);
        _100.addActionListener(this);
    }

    public static void main(String [] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("ButtonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Create and set up the content pane.
                Triangular newContentPane = new Triangular();
                newContentPane.setOpaque(true); //content panes must be opaque
                frame.setContentPane(newContentPane);

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public boolean check_if_triangle(int num)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        int latest = 0;
        int iteration = 0;
        while (latest < num)
        {
            latest = 0;
            for (int i = 1; i < iteration; i++)
                latest+=i;
            numbers.add(latest);
            iteration++;
        }

        return numbers.contains((Integer)num);
    }

    public String divisors(int num)
    {
        String result = "";
        int number_of_divisors = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result += i + ", ";
                number_of_divisors++;
            }
        }
        String result2 = "";
        if (result.length() > 2)
            result2 = "Divisors: " + number_of_divisors + " ; " + result.substring(0, result.length() - 2);
        return result2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button_name = e.getActionCommand();

        if (button_name.equalsIgnoreCase("Triangle Number?"))
        {
            String number_field = number.getText();
            int num = Integer.parseInt(number_field);
            boolean value = check_if_triangle(num);
            String divisors_string = divisors(num);
            result.setText("Triangle number? " + Boolean.toString(value) + "\nDivisors = " + divisors_string);
            result.setSize(30 + divisors_string.length(), 2);
        }

        if (button_name.equalsIgnoreCase("100"))
        {
            System.out.println("Reached button");
            boolean condition = false;
            int tracker = 1;
            while (!condition)
            {
                tracker++;
                String divisor_string = "";
                if (check_if_triangle(tracker))
                {
                    divisor_string = divisors(tracker);
                    Scanner kb = new Scanner(divisor_string);
                    if (kb.hasNext())
                        kb.next();
                    int number_of_divisors = 0;
                    if (kb.hasNextInt())
                        if (kb.nextInt() >= 100)
                            condition = true;
                }
            }
            result.setText("Number: " + tracker);
        }
    }
}
