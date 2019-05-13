package services;

import sponsors.Sponsor;
import sportComplexes.Stadium;
import model.FootballClub;
import persons.Manager;
import persons.Player;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballClubService {
    private static ArrayList<FootballClub> listOfFootballClubs = new ArrayList<>();

    private static FootballClubService instance = new FootballClubService();

    private FootballClubService() {
    }

    static {
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\FootballClubsCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String name = info.get(0);

                Stadium stadium = null;
                String stadiumName = info.get(1);
                for (Stadium it_stadium: StadiumService.getListOfStadiums()) {
                    if (it_stadium.getName().equals(stadiumName)) {
                        stadium = it_stadium;
                        break;
                    }
                }

                List<String> dateInfo = Arrays.asList(info.get(2).split("-"));

                Manager manager = null;
                String managerName = info.get(3);
                for (Manager it_manager: PersonsService.getListOfManagers()){
                    if(it_manager.getLastName().equals(managerName)){
                        manager = it_manager;
                        break;
                    }
                }

                Sponsor sponsor = null;
                String sponsorName = info.get(4);
                for (Sponsor it_sponsor: SponsorsService.getListOfSponsors()){
                    if(it_sponsor.getName().equals(sponsorName)){
                        sponsor = it_sponsor;
                        break;
                    }
                }

                String League = info.get(5);
//                int nrWins = Integer.parseInt(info.get(6));
//                int nrDraws = Integer.parseInt(info.get(7));
//                int nrLoses = Integer.parseInt(info.get(8));
//                int nrScored = Integer.parseInt(info.get(9));
//                int nrReceived = Integer.parseInt(info.get(10));
//                int nrPoints = Integer.parseInt(info.get(11));
//                int nrMatches = Integer.parseInt(info.get(12));

                List<Player> players = new ArrayList<>();;
                for (Player player: PersonsService.getListOfPlayers()){
                    if(player.getFootballClub().equals(name)){
                        players.add(player);
                    }
                }

                FootballClub footballClub = new FootballClub(name, stadium, LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), manager, players, sponsor, League); //nrWins, nrDraws, nrLoses, nrScored, nrReceived, nrPoints, nrMatches);
                listOfFootballClubs.add(footballClub);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }
    }



    public static FootballClubService getInstance(){
        return instance;
    }

    public static ArrayList<FootballClub> getListOfFootballClubs(){
        return listOfFootballClubs;
    }

    public static FootballClub getFootballClubByName(String name){
        for (FootballClub footballClub: listOfFootballClubs)
            if(footballClub.getName().equals(name))
                return footballClub;
        return null;
    }

    public static void FootBallClub(){
        FootballClub footballClub = new FootballClub();
        footballClub.addClubInfo();
        listOfFootballClubs.add(footballClub);
    }

    public static void deleteFootballClubbyName(String name){
        for (FootballClub footballClub: listOfFootballClubs)
            if(footballClub.getName().equals(name))
                listOfFootballClubs.remove(footballClub);
    }

    public static void addFootballClub(){
        FootballClub footballClub = new FootballClub();
        footballClub.addClubInfo();
    }

}
