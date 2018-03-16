import java.util.Scanner;

public class Hex
{
    static String[] hex_to_bin = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please insert hexadecimal number: ");
        String input = kb.next();


        int decimal = 0;
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            decimal += Math.pow(16, input.length() - i - 1) * hex_to_int(c);
        }

        System.out.println(decimal);

        String binary = "";
        for (int i = 0; i < input.length(); i++)
        {
            binary += hex_to_bin[hex_to_int(input.charAt(i))] + " ";
        }

        System.out.println(binary);
    }

    public static int hex_to_int(char c)
    {
        int value = 0;

        if ((int)c > 47 && (int)c < 58)
            value = (int)c - 48;

        if ((int)c > 64 && (int)c < 71)
            value = (int)c - 65 + 10;

        return value;
    }
}
