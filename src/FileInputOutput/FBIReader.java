package FileInputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Year
{
    public Year()
    {

    }

    public int year = 0;
    public int population = 0;
    public int violent_crime = 0;
    public int murder = 0;
    public int rape = 0;
    public int robbery = 0;
    public int assault = 0;
    public int property_crime = 0;
    public int burglary = 0;
    public int larceny_theft = 0;
    public int motor_vehicle_theft = 0;
}


public class FBIReader
{

    public static void main(String [] args)
    {
        File stats_file = new File("/Users/charpentiert/IdeaProjects/sem3/src/FBIStats2.txt");
        Scanner stats_scanner = new Scanner(System.in);
        try {stats_scanner = new Scanner(stats_file);
        }
        catch (FileNotFoundException ex) { System.out.println("ERROR: FILE NOT FOUND"); }

        stats_scanner.nextLine();

        Year[] stats = new Year[22];
        while (stats_scanner.hasNextLine())
        {
            Year current_year = new Year();
            current_year.year = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.population = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.violent_crime = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.murder = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.rape = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.robbery = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.assault = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.property_crime = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.burglary = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.larceny_theft = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            current_year.motor_vehicle_theft = Integer.parseInt(stats_scanner.next().replace("\"", "").replace(",", ""));
            stats[current_year.year - 1994] = current_year;
        }

        Scanner kb = new Scanner(System.in);
        while (true)
        {
            System.out.println("What year would you like to select? ");
            int requested_year = kb.nextInt();
            kb.nextLine();
            System.out.println("What statistic would you like? ");
            String requested_stat = kb.nextLine().toLowerCase();
            if (requested_stat.contains("population"))
                System.out.println(requested_year + ", Population: " + stats[requested_year - 1994].population);
            else if (requested_stat.contains("violent crime"))
                System.out.println(requested_year + ", Violent Crime: " + stats[requested_year - 1994].violent_crime);
            else if (requested_stat.contains("murder"))
                System.out.println(requested_year + ", Murder: " + stats[requested_year - 1994].murder);
            else if (requested_stat.contains("rape"))
                System.out.println(requested_year + ", Rape: " + stats[requested_year - 1994].rape);
            else if (requested_stat.contains("robbery"))
                System.out.println(requested_year + ", Robbery: " + stats[requested_year - 1994].robbery);
            else if (requested_stat.contains("assault"))
                System.out.println(requested_year + ", Assault: " + stats[requested_year - 1994].assault);
            else if (requested_stat.contains("property crime"))
                System.out.println(requested_year + ", Property Crime: " + stats[requested_year - 1994].property_crime);
            else if (requested_stat.contains("burglary"))
                System.out.println(requested_year + ", Burglary: " + stats[requested_year - 1994].burglary);
            else if (requested_stat.contains("larceny-theft"))
                System.out.println(requested_year + ", Larceny-Theft: " + stats[requested_year - 1994].larceny_theft);
            else if (requested_stat.contains("motor vehicle theft"))
                System.out.println(requested_year + ", Motor Vehicle Theft: " + stats[requested_year - 1994].motor_vehicle_theft);
            else if (requested_stat.contains("exit"))
                System.exit(0);
        }
    }
}
