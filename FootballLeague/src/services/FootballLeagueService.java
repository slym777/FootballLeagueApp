package services;

import database.FootballMatchDatabase;
import database.SponsorDatabase;
import model.FootbalLeague;
import model.FootballClub;
import model.Match;
import model.SportsClub;
import persons.Referee;

import myComparator.FootballClubComparator;
import sponsors.Sponsor;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class FootballLeagueService implements LeaguePrototypeService{
    private static List<Match> listOfMatches = new ArrayList<>();
    private static Map<Integer,List<Match>> stages = new HashMap<>();
    private static FootbalLeague PremierLeague;

    private static FootballLeagueService instance = new FootballLeagueService();

    private FootballLeagueService(){
    }

    public static FootballLeagueService getInstance(){
        return instance;
    }

    static {
        readFootballMatchesDataFromDatabase();
    }

    public static void readFootballMatchesDataFromCSV(){
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\MatchesCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                int stage = Integer.parseInt(info.get(0));

                String homeTeamName = info.get(1);
                String guestTeamName = info.get(2);
                FootballClub homeTeam = FootballClubService.getFootballClubByName(homeTeamName);
                FootballClub guestTeam = FootballClubService.getFootballClubByName(guestTeamName);

                int homeTeamScore = Integer.parseInt(info.get(3));
                int guestTeamScore = Integer.parseInt(info.get(4));

                List<String> dateInfo = Arrays.asList(info.get(5).split("-"));

                String refereeName = info.get(6);
                Referee referee = PersonsService.getRefereeByName(refereeName);
                Match match = new Match(stage, homeTeam, guestTeam, homeTeamScore, guestTeamScore, LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), referee);
                listOfMatches.add(match);
            }
            createLeague();
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }
    }

    public static void readFootballMatchesDataFromDatabase(){
        listOfMatches = FootballMatchDatabase.selectAllFootballMatches();
        createLeague();
    }

    public static void createLeague(){
        for(Match match: listOfMatches){
            if(stages.containsKey(match.getStage())){
                List<Match> stageMatches = stages.get(match.getStage());
                stageMatches.add(match);
                stages.replace(match.getStage(),stageMatches);
            }
            else {
                List<Match> stageMatches = new ArrayList<>();
                stageMatches.add(match);
                stages.put(match.getStage(),stageMatches);
            }
        }
        PremierLeague = new FootbalLeague(FootballClubService.getListOfFootballClubs().size(), FootballClubService.getListOfFootballClubs(), stages);
    }


    public static List<Match> getListOfMatches(){
        return listOfMatches;
    }

    public static Map<Integer,List<Match>> getStages() {return stages;}

    public static FootbalLeague getFootballLeague() {
        return PremierLeague;
    }


        @Override
    public String getLeagueLeader(){
        Collections.sort(PremierLeague.getClubs(), new FootballClubComparator());
        return PremierLeague.getClubs().get(0).getName();
    }

    public static Object[][] displayLeagueTeable() {
        Object[][] table = new Object[PremierLeague.getNumberofClubs()][10];
        for (Integer i = 0 ; i < PremierLeague.getClubs().size(); i++){
            FootballClub club = PremierLeague.getClubs().get(i);
            table[i][0] = i+1;
            table[i][1] = club.getName();
            table[i][2] = club.getNrMatchesPlayed();
            table[i][3] = club.getNrWins();
            table[i][4] = club.getNrDraws();
            table[i][5] = club.getNrLoses();
            table[i][6] = club.getNrScoredGoals();
            table[i][7] = club.getNrRecievedGoals();
            table[i][8] = club.goalDifference();
            table[i][9] = club.getNrPoints();
//            System.out.println(i+1 + "." + PremierLeague.getClubs().get(i).getName() + ": " + PremierLeague.getClubs().get(i).getNrPoints() + "; Goal Diff: " + PremierLeague.getClubs().get(i).goalDifference());
        }
        return table;
    }

    public static void sortByPoints(){
        Collections.sort(PremierLeague.getClubs(), new FootballClubComparator());
    }

    public static void sortByWins(){
        PremierLeague.getClubs().sort(Comparator.comparing(FootballClub::getNrWins).reversed());
    }

    public static void sortByLoses(){
        PremierLeague.getClubs().sort(Comparator.comparing(FootballClub::getNrLoses).reversed());
    }

    public static void sortByScoredGoals(){
        PremierLeague.getClubs().sort(Comparator.comparing(FootballClub::getNrScoredGoals).reversed());
    }
    public static void sortByReceivedGoals(){
        PremierLeague.getClubs().sort(Comparator.comparing(FootballClub::getNrRecievedGoals).reversed());
    }
    public static void sortByGoalsDiff(){
        PremierLeague.getClubs().sort(Comparator.comparing(FootballClub::goalDifference).reversed());
    }

    public static List<String> getClubsNames(){
        List<String> clubsNames = new ArrayList<>();
        List<FootballClub> clubs = PremierLeague.getClubs();
        clubs.sort(Comparator.comparing(SportsClub::getName));
        for (FootballClub club: PremierLeague.getClubs())
            clubsNames.add(club.getName());
        return clubsNames;
    }
}

