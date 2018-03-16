import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader
{
    public Scanner filescan;
    public File file;
    //public ArrayList<ArrayList<Object>>

    public CSVReader()
    {

    }

    public CSVReader(String filename)
    {
        file = new File(filename);
        try{
        filescan = new Scanner(file); }
        catch (FileNotFoundException ex) {
            System.out.println("File not found exception");
            System.exit(12);
        }

        if (filescan.hasNext())
            parse();
    }

    public void parse()
    {
        ArrayList<String[]> file = new ArrayList<String[]>();

    }

}
