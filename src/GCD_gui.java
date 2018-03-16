import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class GCD_gui extends JPanel implements ActionListener
{
    JButton gcd_button;
    JTextField number;
    JTextArea result;

    ArrayList<Integer> gcd = new ArrayList<>(), factor = new ArrayList<>();

    public GCD_gui()
    {
        gcd_button = new JButton("GCD");
        number = new JTextField("", 20);
        result = new JTextArea(2, 20);

        add(number);
        add(gcd_button);
        add(result);

        gcd_button.addActionListener(this);
    }

    public static void main(String [] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("ButtonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Create and set up the content pane.
                GCD_gui newContentPane = new GCD_gui();
                newContentPane.setOpaque(true); //content panes must be opaque
                frame.setContentPane(newContentPane);

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public String get_gcd(String input_)
    {
        String[] input = input_.split(",");
        String output = "";
        int[] n = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        int iterations = -1, latest = n[0], _latest = n[1];
        do {
            iterations++;
            factor.add(latest / _latest);
            gcd.add(latest - (factor.get(iterations) * _latest));
            System.out.println(latest + " = " + _latest + " x " + factor.get(iterations) + " + " + (char) 27 + "[33m" + gcd.get(iterations) + (char) 27 + "[0m");
            latest = _latest;
            _latest = gcd.get(iterations);
        }
        while (gcd.get(iterations) != 0);
        output = "GCD(" + n[0] + "," + n[1] + ") = " + gcd.get(iterations - 1);
        return output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button_name = e.getActionCommand();

        if (button_name.equalsIgnoreCase("GCD"))
        {
            String output = get_gcd(number.getText());
            result.setText(output);
        }
    }
}
