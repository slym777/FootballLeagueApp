package model;

import util.MakeDate;
import sponsors.Sponsor;
import sportComplexes.Stadium;
import persons.Manager;
import persons.Player;
import services.PersonsService;
import services.StadiumService;

import java.time.LocalDate;
import java.util.*;

public abstract class SportsClub {  /// pot sa o fac abstracta
    private String name;
    private Stadium stadium;
    private LocalDate established;
    private Manager manager;
    private List<Player> players;
    private Sponsor sponsor;
//    private Set<sponsors.Sponsor> sponsors;
//    private List<model.Match> lastMatches;


    public SportsClub(String name, Stadium stadium, LocalDate established, Manager manager, List<Player> players, Sponsor sponsor) {
        this.name = name;
        this.stadium = stadium;
        this.established = established;
        this.manager = manager;
        this.players = players;
        this.sponsor = sponsor;
    }

    public SportsClub(){
        manager = new Manager();
        sponsor = new Sponsor();
        players = new ArrayList<>();
        stadium = new Stadium();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public LocalDate getEstablished() {
        return established;
    }

    public void setEstablished(LocalDate established) {
        this.established = established;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public abstract void printStatistics();

//    public abstract void addPlayer();

    public void addClubInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insert Club Name: ");
        this.setEstablished(MakeDate.insertDate());
        System.out.println("Insert Stadium Name: ");
        String stadiumName = keyboard.nextLine();
        StadiumService stadiumservice = StadiumService.getInstance();
        this.stadium = stadiumservice.getStadiumByName(stadiumName);
        if(this.stadium == null) {
            System.out.println("This stadium name does not exist. Please insert his personal data");
            this.stadium.addStadiumInfo();
        }
        System.out.println("Insert Manager Name: ");
        String managerName = keyboard.nextLine();
        PersonsService managerService = PersonsService.getInstance();
        this.manager = managerService.getManagerByName(managerName);
        if(this.manager == null) {
            System.out.println("This manager name does not exist. Please insert it");
            this.manager.addPersonInfo();
        }


    }
}
