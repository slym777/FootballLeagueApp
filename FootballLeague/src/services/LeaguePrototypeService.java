package services;

import model.FootballClub;
import model.Stage;

public interface LeaguePrototypeService {
    int maxNrofClubs = 20;
//    void addClub();
//    void addStage();
//    void deleteClub();
//    void deleteStage();
//    FootballClub findClub(String clubName);
//    Stage findStage(int number);
//    void findClubStatistics();
//    void displayLeagueTeable();
//    void getCurrentClubs();
//    String getMostGoalsClub();
    String getLeagueLeader();

    default void getLeagueChampion(){
        System.out.println("The Champion of the season is " + getLeagueLeader());
    }

}
