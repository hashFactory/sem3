package Intro;

import java.util.ArrayList;
import java.util.Scanner;

class Task
{
    String name = "";
    int day_of_the_week = 0;
    int time_of_day = 0;
    boolean prioritize = false;

    public Task()
    {

    }

    public Task(String _name, int _day_of_the_week, int _time_of_day, boolean _prioritize)
    {
        name = _name;
        day_of_the_week = _day_of_the_week;
        time_of_day = _time_of_day;
        prioritize = _prioritize;
    }
}

public class Schedule
{
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    ArrayList<Task> list = new ArrayList<>();

    public void addEvent()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Name of event: ");
        String name = kb.nextLine();
        System.out.print("Day of the week: ");
        String _day_of_the_week = kb.next().toLowerCase();
        System.out.print("Time of day: ");
        int time_of_day = kb.nextInt();
        kb.nextLine();
        System.out.print("Prioritize? ");
        String _prioritize = kb.nextLine();

        int day_of_the_week = 0;
        switch (_day_of_the_week)
        {
            case "monday":
                day_of_the_week = 0;
                break;
            case "tuesday":
                day_of_the_week = 1;
                break;
            case "wednesday":
                day_of_the_week = 2;
                break;
            case "thursday":
                day_of_the_week = 3;
                break;
            case "friday":
                day_of_the_week = 4;
                break;
            case "saturday":
                day_of_the_week = 5;
                break;
            case "sunday":
                day_of_the_week = 6;
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        boolean prioritize = false;
        if (_prioritize.toLowerCase().contains("y"))
            prioritize = true;
        else if (_prioritize.toLowerCase().contains("n"))
            prioritize = false;

        Task task = new Task(name, day_of_the_week, time_of_day, prioritize);
        list.add(task);

        System.out.println("Added to calendar\t");
    }

    public void deleteEvent()
    {
        printSchedule();
        System.out.print("Select index of event you would like to delete: ");
        int index = new Scanner(System.in).nextInt();
        list.remove(index);
        System.out.println("Event deleted from calendar");
    }

    public void prioritizeEvent()
    { // TODO
    }

    public void printSchedule()
    {
        int[] indexes = new int[list.size()];
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            indexes[i] = i;
            values[i] = list.get(i).day_of_the_week * 24 + list.get(i).time_of_day;
        }

        int n = values.length;
        int temp;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(values[j-1] > values[j])
                {
                    temp = values[j-1];
                    values[j-1] = values[j];
                    values[j] = temp;
                    temp = indexes[j-1];
                    indexes[j-1] = indexes[j];
                    indexes[j] = temp;
                }
            }
        }

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.indexOf(list.get(indexes[i])) + "] " + list.get(indexes[i]).name + " on " + days[list.get(indexes[i]).day_of_the_week] + " at " + list.get(indexes[i]).time_of_day);
        }

    }

}
