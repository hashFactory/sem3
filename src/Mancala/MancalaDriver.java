package Mancala;

import java.util.Scanner;

public class MancalaDriver
{
    static Scanner kb = new Scanner(System.in);
    static int[] board;

    private static int prompt(boolean player_one)
    {
        print();
        System.out.println("Which pot would you like to sow? ");
        int position = kb.nextInt();
        push(player_one, position);

        return 0;
    }

    private static void push(boolean player_one, int position)
    {
        for (int i = position + 1; i < position + board[position] + 1; i++)
        {
            board[i % 14] += 1;
        }
    }

    private static void print()
    {
        System.out.println(board[6] + "|" + board[5] + " " + board[4] + " " + board[3] + " " + board[2] + " " + board[1] + " " + board[0] + "|" + board[13]);
        System.out.println(board[6] + "|" + board[7] + " " + board[8] + " " + board[9] + " " + board[10] + " " + board[11] + " " + board[12] + "|" + board[13]);
    }

    public static void main(String [] args)
    {
        board = new int[]{4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
        Mancala board = new Mancala();
        boolean player_one = true;
        while(true)
        {
            prompt(player_one);
            player_one = !player_one;
        }
    }
}
