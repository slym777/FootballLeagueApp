package myComparator;

import model.FootballClub;

import java.util.Comparator;

public class FootballClubComparator implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub a, FootballClub b){
        if(a.getNrPoints() > b.getNrPoints())
            return -1;
        else {
            if (a.getNrPoints() < b.getNrPoints())
                return 1;
            else {
                int goalDifference1 = a.goalDifference();
                int goalDifference2 = b.goalDifference();
                if (goalDifference1 > goalDifference2)
                    return -1;
                else {
                    if(goalDifference1 < goalDifference2)
                        return 1;
                    else {
                        if(a.getNrScoredGoals() > b.getNrScoredGoals())
                            return -1;
                        else{
                            if(a.getNrScoredGoals() < b.getNrScoredGoals())
                                return 1;
                            else{
                                if(a.getNrRecievedGoals() > b.getNrScoredGoals())
                                    return -1;
                                else{
                                    if(a.getNrRecievedGoals() < b.getNrRecievedGoals())
                                        return 1;
                                    else return 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
