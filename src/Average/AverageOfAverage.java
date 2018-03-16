package Average;

import java.util.ArrayList;
import java.util.Random;

public class AverageOfAverage
{
    int[] values = new int[100];

    public AverageOfAverage()
    {

    }

    public void fillArray(int lowestNumber, int highestNumber)
    {
        // Randomly pick numbers between those values and fill up the array
        Random r = new Random();
        for (int i = 0; i < values.length; i++)
        {
            values[i] = r.nextInt(highestNumber + 1 - lowestNumber) + lowestNumber;
        }

    }

    public void printArray()
    {
        for (int i: values)
        {
            System.out.print(i + " ");
        }
    }

    public int findSampleAverage(int sampleSize, int numberOfSamples)
    {
        double totalAverage = 0;

        Random r = new Random();
        for (int i = 0; i < numberOfSamples; i++)
        {
            ArrayList<Integer> spots = new ArrayList<>(sampleSize);
            boolean done = false;
            while (!done)
            {
                Integer spot = r.nextInt(values.length);
                if (!spots.contains(spot))
                    spots.add(spot);

                if (spots.size() == numberOfSamples)
                    done = true;
            }

            int sum = 0;
            for (int k = 0; k < sampleSize; k++)
                sum += values[spots.get(k)];

            totalAverage += ((double)sum / (double)sampleSize);
        }

        return (int)(totalAverage / (double)numberOfSamples);
    }

    public int findAverage()
    {
        int sum = 0;
        for (int i = 0; i < values.length; i++)
        {
            sum += values[i];
        }

        return (int)((double)sum / (double)(values.length));
    }
}
