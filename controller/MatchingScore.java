package controller;

import java.util.ArrayList;

public class MatchingScore {

    public static double calculateMatchingScore(ArrayList<String> keywordIds1, ArrayList<String> keywordIds2)
    {
        double matchingScore = 0;
        for (int i = 0; i < keywordIds1.size(); i++)
        {
            System.out.println("time is " + i);
            if (keywordIds2.contains(keywordIds1.get(i)))
            {
                matchingScore++;
                System.out.println(matchingScore);
            }
        }
        return matchingScore / keywordIds1.size();
    }

    public static void main(String[] args)
    {
        ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();

        al1.add("pizza");
        al1.add("fishing");
        al1.add("accounting");
        al2.add("pizza");
        al2.add("fast");
        double db = calculateMatchingScore(al1, al2);
        System.out.println(db);

    }
}
