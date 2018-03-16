package Intro;

import java.util.ArrayList;

public class StringLength
{
    public static void main(String [] args) throws StringIndexOutOfBoundsException
    {
        String sentence_1 = "Houston floods floods".toLowerCase();
        String sentence_2 = " flows".toLowerCase();
        ArrayList<String> works = new ArrayList<>();

        for (int i = 0; i < sentence_1.length(); i++)
            for (int j = 0; j < ((sentence_1.length() < sentence_2.length()) ? sentence_2.length() : sentence_1.length()) && j - i < sentence_2.length(); j++)
                try {if (sentence_2.contains(sentence_1.substring(i, j)))
                    works.add(sentence_1.substring(i, j)); } catch (StringIndexOutOfBoundsException ex) {}

        String longest = "";
        for (int i = 0; i < works.size(); i++)
            if (works.get(i).length() > longest.length())
                longest = works.get(i);

        System.out.println("\"" + longest + "\" is the longest shared substring.");
    }
}
