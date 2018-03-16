import java.util.ArrayList;

public class Golfer
{
    public ArrayList<Integer> scores = new ArrayList<>();
    public int handicap;

    public void setScores() {}

    public void setScores(int[] input_scores)
    {
        for (int score: input_scores)
            scores.add(score);
    }

    public int getHandicap()
    {
        int total_scores = 0;
        for (Integer a: scores)
            total_scores += a;
        return (total_scores / scores.size());
    }
}
