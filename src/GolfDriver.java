import java.util.Scanner;

public class GolfDriver
{
    public static void main(String [] args)
    {
        Golfer[] golfer = new Golfer[5];
        for (int i = 0; i < golfer.length; i++)
            golfer[i] = new Golfer();

        Scanner kb = new Scanner(System.in);
        while (true)
        {
            System.out.println("Select player ");
            int player = kb.nextInt();
            System.out.println("Would you like to add a score Y/n ");
            boolean more = true;

        }
    }
}
