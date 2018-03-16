package Intro;

import java.util.Scanner;

public class SchedulerDriver
{
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        Schedule[] family = new Schedule[3];
        for (int i = 0; i < family.length; i++)
            family[i] = new Schedule();
        int choice = 0;
        do
        {
            int person_index = 0;
            System.out.println("Which person's schedule will you be managing? (0-2) ");
            person_index = kb.nextInt();
            System.out.println("Options for calendar " + person_index + ":\n\t1) Add event to calendar\n\t2) Delete event from calendar\n\t3) Prioritize an event\n\t4) Print out calendar\n\t5) Exit program");
            choice = kb.nextInt();
            if (choice == 1)
                family[person_index].addEvent();
            else if (choice == 2)
                family[person_index].deleteEvent();
            else if (choice == 3)
                family[person_index].prioritizeEvent();
            else if (choice == 4)
                family[person_index].printSchedule();
        } while (choice != 5);


    }
}
