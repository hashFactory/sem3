package Intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class AverageFromFile
{
    public static void main(String [] args) throws FileNotFoundException
    {
        Scanner file = new Scanner("file.txt");
        int cumu = 0;
        while (file.hasNextInt())
            cumu += file.nextInt();
        LineNumberReader lmr = new LineNumberReader(new FileReader(new File("file.txt")));
        //System.out.println(cumu / );
    }
}
