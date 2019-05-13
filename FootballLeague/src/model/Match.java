package model;

import persons.Referee;

import java.time.LocalDate;

public class Match {
    private int stage;
    private FootballClub homeTeam;
    private FootballClub guestTeam;
    private int homeTeamScore;
    private int guestTeamScore;
    private LocalDate date;
    private Referee referee;

    public Match(int stage, FootballClub homeTeam, FootballClub guestTeam, int homeTeamScore, int guestTeamScore, LocalDate date, Referee referee) {
        this.stage = stage;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScore = guestTeamScore;
        this.date = date;
        this.referee = referee;
        this.updateTeamsStatistics();
    }

    public Match(){
    }

    public int getStage(){
        return stage;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public FootballClub getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballClub homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballClub getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(FootballClub guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public void updateTeamsStatistics(){
        homeTeam.changeStatistics(homeTeamScore, guestTeamScore);
        guestTeam.changeStatistics(guestTeamScore, homeTeamScore);
    }

    public void printMatch(){
        System.out.print("Stage " + stage + ": " + homeTeam.getName() + " " + homeTeamScore + " - " + guestTeamScore + " " + guestTeam.getName() + "\n");
    }
}
