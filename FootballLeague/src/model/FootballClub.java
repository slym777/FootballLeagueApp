package model;

import sponsors.Sponsor;
import sportComplexes.Stadium;
import persons.Manager;
import persons.Player;

import java.time.LocalDate;
import java.util.List;

public class FootballClub extends SportsClub {
    private String League;
    private int nrWins;
    private int nrDraws;
    private int nrLoses;
    private int nrScoredGoals;
    private int nrRecievedGoals;
    private int nrPoints;
    private int nrMatchesPlayed;

    public FootballClub(String name, Stadium stadium, LocalDate established, Manager manager, List<Player> players, Sponsor sponsor, String League, int nrWins, int nrDraws, int nrLoses, int nrScoredGoals, int nrRecievedGoals) {
        super(name, stadium, established, manager, players, sponsor);
        this.League = League;
        this.nrWins = nrWins;
        this.nrDraws = nrDraws;
        this.nrLoses = nrLoses;
        this.nrScoredGoals = nrScoredGoals;
        this.nrRecievedGoals = nrRecievedGoals;
        this.calculate_nrPoints();
        this.calculate_nrMatchesPlayed();

    }

    public FootballClub(String name, Stadium stadium, LocalDate established, Manager manager, List<Player> players, Sponsor sponsor, String League) {
        super(name, stadium, established, manager, players, sponsor);
        this.League = League;
        this.nrRecievedGoals = this.nrScoredGoals = this.nrDraws = this.nrLoses = this.nrWins = this.nrPoints = this.nrMatchesPlayed = 0;
    }

    public FootballClub() {

    }

    public int getNrWins() {
        return nrWins;
    }

    public void setNrWins(int nrWins) {
        this.nrWins = nrWins;
    }

    public int getNrDraws() {
        return nrDraws;
    }

    public void setNrDraws(int nrDraws) {
        this.nrDraws = nrDraws;
    }

    public int getNrLoses() {
        return nrLoses;
    }

    public void setNrLoses(int nrLoses) {
        this.nrLoses = nrLoses;
    }

    public int getNrScoredGoals() {
        return nrScoredGoals;
    }

    public void setNrScoredGoals(int nrScoredGoals) {
        this.nrScoredGoals = nrScoredGoals;
    }

    public int getNrRecievedGoals() {
        return nrRecievedGoals;
    }

    public void setNrRecievedGoals(int nrRecievedGoals) {
        this.nrRecievedGoals = nrRecievedGoals;
    }

    public int getNrPoints() {
        return nrPoints;
    }

    public void setNrPoints(int nrPoints) {
        this.nrPoints = nrPoints;
    }

    public int getNrMatchesPlayed() {
        return nrMatchesPlayed;
    }

    public void setNrMatchesPlayed(int nrMatchesPlayed) {
        this.nrMatchesPlayed = nrMatchesPlayed;
    }

    public int goalDifference() {
        return this.nrScoredGoals - this.nrRecievedGoals;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public void calculate_nrPoints(){
        this.nrPoints = 3*nrWins + nrDraws;
    }

    public void calculate_nrMatchesPlayed() {
        this.nrMatchesPlayed = nrDraws + nrWins + nrLoses;
    }
//    public void addPlayer() {
//        Scanner keyboard = new Scanner(System.in);
//        Player player = new Player();
//        System.out.println("persons.Player " + ":\n");
//        System.out.println("Insert First Name: ");
//        player.setFirstName(keyboard.nextLine());
//        System.out.println("Insert Last Name: ");
//        player.setLastName(keyboard.nextLine());
//
//        System.out.println("Insert birth date:");
//        player.setDateofBirth(makeDate.insertDate());
//
//        System.out.println("Insert weight:");
//        player.setWeight(keyboard.nextDouble());
//        System.out.println("Insert height:");
//        player.setHeight(keyboard.nextDouble());
//        System.out.println("Insert foot:");
//        player.setFoot(keyboard.nextLine());
//        System.out.println("Insert position: ");
//        player.setPosition(keyboard.nextLine());
//        System.out.println("Insert number: ");
//        player.setNumber(keyboard.nextInt());
//        player.setFootballClub(this.getName());
//        List<Player> players = this.getPlayers();
//        players.add(player);
//        this.setPlayers(players);
//    }

    public void printStatistics(){
        System.out.println(this.getName() + " statistics:");
        System.out.println("Points - " + this.nrPoints);
        System.out.println("Matches played - " + this.nrMatchesPlayed);
        System.out.println("Wins - " + this.nrWins);
        System.out.println("Draws - " + this.nrDraws);
        System.out.println("Loses - " + this.nrLoses);
        System.out.println("Scored Goals - " + this.nrScoredGoals);
        System.out.println("Received Goals - " + this.nrRecievedGoals);
        System.out.println("'+/-' - " + this.goalDifference());
    }

    public void changeStatistics(int scored, int received){
        if (scored > received) {
            this.nrWins++;
            this.nrPoints += 3;
        }
        else if (scored < received)
            this.nrLoses++;
        else {
            this.nrDraws++;
            this.nrPoints++;
        }

        this.nrScoredGoals += scored;
        this.nrRecievedGoals += received;
        this.nrMatchesPlayed++;
    }
}