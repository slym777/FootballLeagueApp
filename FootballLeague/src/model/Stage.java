package model;

import persons.Referee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Stage {
    private int number;
    private ArrayList<Match> matches;

    public Stage(int number, ArrayList<Match> matches){
        this.number = number;
        this.matches = matches;
    }

    public Stage(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(FootballClub home, FootballClub guest){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insert stage number");
        int stage = keyboard.nextInt();

        System.out.println("Insert match date:\n Year: ");
        int year = keyboard.nextInt();
        System.out.println("Month: ");
        int month = keyboard.nextInt();
        System.out.println("Day: ");
        int day = keyboard.nextInt();
        LocalDate date = LocalDate.of(year, month, day);

        System.out.println("Insert home team goals");
        int homeTeamGoals = keyboard.nextInt();
        System.out.println("Insert guest team goals");
        int guestTeamGoals = keyboard.nextInt();

        Referee referee = new Referee();
        System.out.println("persons.Referee:");
//        referee.changeRefereeInfo();

        Match match = new Match(stage,home,guest,homeTeamGoals,guestTeamGoals,date,referee);
        match.updateTeamsStatistics();
        this.matches.add(match);
    }
}
