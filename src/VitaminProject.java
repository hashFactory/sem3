import java.util.Random;

public class VitaminProject
{
    public static int number_of_vitamins = 1000000000;

    public static void main(String [] args)
    {
        int vitamins_you_like = 0;
        Random r = new Random();

        for (int i = 0; i < (number_of_vitamins / 4); i++)
        {
            int vitamin = generate();
            if (vitamin > 1)
                vitamins_you_like+=2;
            else
                vitamins_you_like+=vitamin;
        }

        System.out.println("Took " + vitamins_you_like + " vitamins you like and " + ((number_of_vitamins / 2) - vitamins_you_like) + " you don't like");
        System.out.println("Or " + (double)(vitamins_you_like) / (double)((number_of_vitamins) / 2));
    }

    public static int generate()
    {
        int vitamin = (int)(Math.random() * 16);
        if (vitamin < 1)
            return 0;
        else if (vitamin < 5)
            return 1;
        else
            return 2;
    }
}
