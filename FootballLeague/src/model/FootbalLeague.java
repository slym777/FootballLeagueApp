package model;

import java.util.*;

public class FootbalLeague{
    private int numberofClubs;
    private List<FootballClub> clubs;
    private Map<Integer,List<Match>> stages;

    public FootbalLeague(int numberofClubs, List<FootballClub> clubs, Map<Integer,List<Match>> stages) {
        this.numberofClubs = numberofClubs;
        this.clubs = clubs;
        this.stages = stages;
    }

    public FootbalLeague(){
        numberofClubs = 0;
        clubs = new ArrayList<>();
        stages = new HashMap<>();
    }

    public int getNumberofClubs() {
        return numberofClubs;
    }

    public void setNumberofClubs(int numberofClubs) {
        this.numberofClubs = numberofClubs;
    }

    public List<FootballClub> getClubs() {
        return clubs;
    }

    public void setClubs(ArrayList<FootballClub> clubs) {
        this.clubs = clubs;
    }

    public Map<Integer, List<Match>> getStages() {
        return stages;
    }

    public void setStages(Map<Integer, List<Match>> stages) {
        this.stages = stages;
    }

    //    @Override
//    public void addClub(){
//        if(clubs.size() == maxNrofClubs){
//            System.out.println("Can't add more clubs to the league");
//            return;
//        }
//        FootballClub club = new FootballClub();
//
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Insert club name: ");
//        club.setName(keyboard.nextLine());
//
//        System.out.println("Insert established date:\n Year: ");
//        int year = keyboard.nextInt();
//        System.out.println("Month: ");
//        int month = keyboard.nextInt();
//        System.out.println("Day: ");
//        int day = keyboard.nextInt();
//        LocalDate date = LocalDate.of(year,month,day);
//        club.setEstablished(date);
//
//        System.out.println("sportComplexes.Stadium:\n Insert name: ");
//        Stadium stadium = club.getStadium();
//        stadium.setName(keyboard.nextLine());
//        System.out.println("Insert address: ");
//        stadium.setAddress(keyboard.nextLine());
//        System.out.println("Insert city: ");
//        stadium.setCity(keyboard.nextLine());
//        System.out.println("Insert country: ");
//        stadium.setCountry(keyboard.nextLine());
//        System.out.println("Insert capacity: ");
//        stadium.setCapacity(keyboard.nextInt());
//        stadium.setHomeTeam(club.getName());
//        System.out.println("Insert opened date:\n Year: ");
//        year = keyboard.nextInt();
//        System.out.println("Month: ");
//        month = keyboard.nextInt();
//        System.out.println("Day: ");
//        day = keyboard.nextInt();
//        date = LocalDate.of(year,month,day);
//        stadium.setOpened(date);
//        club.setStadium(stadium);
//
//        System.out.println("sponsors.Sponsor:\n Insert sponsor name: ");
//        club.getSponsor();
//        System.out.println("Insert sponsor's established date:\n Year: ");
//        year = keyboard.nextInt();
//        System.out.println("Month: ");
//        month = keyboard.nextInt();
//        System.out.println("Day: ");
//        day = keyboard.nextInt();
//        date = LocalDate.of(year,month,day);
//        club.getSponsor().setEstablished(date);
//
//        System.out.println("Insert number of players: ");
//        int nrPlayers = keyboard.nextInt();
//        for(int i = 0; i < nrPlayers; i++){
//           club.addPlayer();
//        }
//        this.numberofClubs++;
//        this.clubs.add(club);
//    }
//
//    @Override
//    public void getCurrentClubs(){
//        int i = 0;
//        for(FootballClub club: clubs){
//            i++;
//            System.out.println("Club " + i + ": " + club.getName());
//        }
//        System.out.println("Total nr of clubs: " + this.numberofClubs);
//    }
//
//    public int getNumberofClubs() {
//        return numberofClubs;
//    }
//
//    public void setNumberofClubs(int numberofClubs) {
//        this.numberofClubs = numberofClubs;
//    }
//
//    public void setClubs(ArrayList<FootballClub> clubs) {
//        this.clubs = clubs;
//    }
//
//    public ArrayList<Stage> getStages() {
//        return stages;
//    }
//
//    public void setStages(ArrayList<Stage> stages) {
//        this.stages = stages;
//    }
//
//    public ArrayList<FootballClub> getClubs() {
//        return clubs;
//    }
//
//    @Override
//    public void deleteClub() {
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Insert club name to delete");
//        String name = keyboard.nextLine();
//        for(FootballClub club: clubs){
//            if(club.getName().equals(name)){
//                clubs.remove(club);
//                System.out.println("Club" + club.getName() + " has been removed");
//                return;
//            }
//        }
//        System.out.println("No such club in the league");
//    }
//
//    @Override
//    public FootballClub findClub(String clubName){
//        for(FootballClub club: clubs){
//            if(club.getName().equals(clubName)){
//                System.out.println("This club is in the league");
//                return club;
//            }
//        }
//        System.out.println("This club is not in the league");
//        return null;
//    }
//
//    @Override
//    public void findClubStatistics(){
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Insert club name");
//        String name = keyboard.nextLine();
//        FootballClub club = findClub(name);
//        if(club == null){
//            System.out.println("No such club in the league");
//            return;
//        }
//        club.printStatistics();
//    }
//
//    @Override
//    public void addStage(){
//        Stage stage = new Stage();
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Insert Number model.Stage");
//        stage.setNumber(keyboard.nextInt());
//        ArrayList<Match> matches = new ArrayList<>();
//        stage.setMatches(matches);
//        System.out.println("Insert number of matches in the stage");
//        int nrMatches = keyboard.nextInt();
//        for (int i = 0; i < nrMatches; i++){
//            keyboard.nextLine();
//            System.out.println("Insert Home Team name");
//            String homeTeam = keyboard.nextLine();
//            System.out.println("Insert Guest Team name");
//            String guestTeam = keyboard.nextLine();
//            FootballClub home = findClub(homeTeam);
//            FootballClub guest = findClub(guestTeam);
//            if (home == null || guest == null) {
//                System.out.println("You entered a wrong team, try again");
//                nrMatches++;
//                continue;
//            }
//            stage.addMatch(home, guest);
//            stages.add(stage);
//        }
//    }
//
//    @Override
//    public void deleteStage(){
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Insert stage number to delete");
//        int number = keyboard.nextInt();
//        for(Stage stage: stages){
//            if(stage.getNumber() == number){
//                stages.remove(stage);
//                System.out.println("model.Stage" + stage.getNumber() + " has been removed");
//                return;
//            }
//        }
//        System.out.println("No such stage number in the league");
//    }
//
//    @Override
//    public Stage findStage(int number){
//        for(Stage stage: stages){
//            if(stage.getNumber() == number){
//                System.out.println("This stage has benn played");
//                return stage;
//            }
//        }
//        System.out.println("Such stage has not been played yet");
//        return null;
//    }
//
//    @Override
//    public void displayLeagueTeable() {
//        Collections.sort(clubs, new FootballClubComparator());
//        for (int i = 0 ; i < clubs.size(); i++){
//            System.out.println(i+1 + "." + clubs.get(i).getName() + ": " + clubs.get(i).getNrPoints());
//        }
//    }
//
//    @Override
//    public String getMostGoalsClub(){
//        String mostScored = "";
//        int nrofGoals = 0;
//        for(FootballClub club:clubs){
//            if (club.getNrScoredGoals() > nrofGoals)
//                mostScored = club.getName();
//        }
//        return mostScored;
//    }
//
//    @Override
//    public String getLeagueLeader(){
//        Collections.sort(clubs, new FootballClubComparator());
//        return clubs.get(0).getName();
//    }

}

