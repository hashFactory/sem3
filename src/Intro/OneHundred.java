package Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class OneHundred
{
    private static int goal = 100;

    private static int calculate(String input)
    {
        int result = 0;

        try {
            ProcessBuilder ps = new ProcessBuilder("awk" + "\"BEGIN {print "+input+"}\"");
            ps.redirectErrorStream(true);

            Process pr = ps.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                System.out.println(line);
            }
            pr.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(input + "=" + result);
        return result;
    }

    public static void main(String [] args)
    {

        ArrayList<String> permutations = new ArrayList<String>();

        boolean done = false;
        while (!done)
        {
            StringBuilder combination = new StringBuilder();
            for (int i = 1; i < 9; i++)
            {
                combination.append(i);
                int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                switch(random)
                {
                    case 1:
                        combination.append(" + ");
                        break;
                    case 2:
                        combination.append(" - ");
                        break;
                    case 3:
                        break;
                }
            }
            combination.append("9");
            if (!permutations.contains(combination.toString()))
            {
                System.out.println(permutations.size() + ": " + combination.toString());
                permutations.add(combination.toString());
            }
            if (permutations.size() == (int)Math.pow(3,8))
                done = true;

        }

        for (int i = 0; i < permutations.size(); i++)
        {
            calculate(permutations.get(i));
        }
    }
}
