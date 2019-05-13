package services;

import model.FootbalLeague;
import model.FootballClub;
import model.Match;
import persons.Referee;

import myComparator.FootballClubComparator;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class FootballLeagueService implements LeaguePrototypeService{
    private static ArrayList<Match> listOfMatches = new ArrayList<>();
    private static Map<Integer,List<Match>> stages = new HashMap<>();
    private static FootbalLeague PremierLeague;

    private static FootballLeagueService instance = new FootballLeagueService();

    private FootballLeagueService(){
    }

    public static FootballLeagueService getInstance(){
        return instance;
    }

    static {
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\MatchesCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                int stage = Integer.parseInt(info.get(0));

                String homeTeamName = info.get(1);
                String guestTeamName = info.get(2);
                FootballClub homeTeam = null;
                FootballClub guestTeam = null;
                for (FootballClub footballClub : FootballClubService.getListOfFootballClubs()) {
                    if (footballClub.getName().equals(homeTeamName))
                        homeTeam = footballClub;
                    if (footballClub.getName().equals(guestTeamName))
                        guestTeam = footballClub;
                }

                int homeTeamScore = Integer.parseInt(info.get(3));
                int guestTeamScore = Integer.parseInt(info.get(4));

                List<String> dateInfo = Arrays.asList(info.get(5).split("-"));

                String refereeName = info.get(6);
                Referee referee = null;
                for(Referee it_referee: PersonsService.getListOfReferees()){
                    if(it_referee.getLastName().equals(refereeName))
                        referee = it_referee;
                }
                Match match = new Match(stage, homeTeam, guestTeam, homeTeamScore, guestTeamScore, LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), referee);
                listOfMatches.add(match);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }

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

    public static ArrayList<Match> getListOfMatches(){
        return listOfMatches;
    }


        @Override
    public String getLeagueLeader(){
        Collections.sort(PremierLeague.getClubs(), new FootballClubComparator());
        return PremierLeague.getClubs().get(0).getName();
    }

        @Override
    public void displayLeagueTeable() {
        Collections.sort(PremierLeague.getClubs(), new FootballClubComparator());
        for (int i = 0 ; i < PremierLeague.getClubs().size(); i++){
            System.out.println(i+1 + "." + PremierLeague.getClubs().get(i).getName() + ": " + PremierLeague.getClubs().get(i).getNrPoints() + "; +/-: " + PremierLeague.getClubs().get(i).goalDifference());
        }
    }

}

