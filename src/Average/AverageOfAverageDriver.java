package Average;

public class AverageOfAverageDriver
{
    public static void main(String [] args)
    {
        AverageOfAverage a = new AverageOfAverage();
        a.fillArray(0, 100);
        a.printArray();
        System.out.println();
        System.out.println(a.findSampleAverage(3, 10));
        System.out.println(a.findAverage());
    }
}
