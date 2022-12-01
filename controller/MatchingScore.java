package controller;

import model.Keyword;

import java.util.ArrayList;

public class MatchingScore {

    public static double calculateMatchingScore(ArrayList<Keyword> keywordIds1, ArrayList<Keyword> keywordIds2)
    {//takes two keyword lists (in string form)
        double matchingScore = 0;
        for (int i = 0; i < keywordIds1.size(); i++)
        { // for each item in  list1, it checks if this exists in list2
            System.out.println("time is " + i);
            if (keywordIds2.contains(keywordIds1.get(i)))
            {
                matchingScore++; //if yes, the matching score is incremented
                System.out.println(matchingScore);
            }
        }
        return matchingScore / keywordIds1.size(); //finally, the matching score is normalised against the size of the list
    }

    public static void main(String[] args)
    {
        ArrayList<Keyword> al1 = new ArrayList<Keyword>();
        ArrayList<Keyword> al2 = new ArrayList<Keyword>();
        Keyword kw1 = new Keyword(1, "category", "fishing");
        Keyword kw2 = new Keyword(2, "category", "accounting");
        Keyword kw3 = new Keyword(3, "category", "pizza");
        Keyword kw4 = new Keyword(4, "category", "test");

        al1.add(kw1);
        al1.add(kw2);
        al1.add(kw3);
        al2.add(kw1);
        al2.add(kw3);

        double db = calculateMatchingScore(al1, al2);
        System.out.println(db);

    }
}
