package sportComplexes;

import makeDate.MakeDate;

import java.time.LocalDate;
import java.util.Scanner;

public class Stadium {
    private String name;
    private String address;
    private String city;
    private String country;
    private int capacity;
    private String homeTeam;
    private LocalDate opened;

    public Stadium(String name, String address, String city, String country, int capacity, String homeTeam, LocalDate opened) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.capacity = capacity;
        this.homeTeam = homeTeam;
        this.opened = opened;
    }

    public Stadium(){
        name = "";
        address = "";
        city = "";
        country = "";
        capacity = 0;
        homeTeam = "";
        opened = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public LocalDate getOpened() {
        return opened;
    }

    public void setOpened(LocalDate opened) {
        this.opened = opened;
    }

    public void addStadiumInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insert stadium's name: ");
        this.setName(keyboard.nextLine());
        System.out.println("Insert stadium's address: ");
        this.setAddress(keyboard.nextLine());
        System.out.println("Insert stadium's city: ");
        this.setCity(keyboard.nextLine());
        System.out.println("Insert stadium's country: ");
        this.setCountry(keyboard.nextLine());
        System.out.println("Insert stadium's capacity: ");
        this.setCapacity(keyboard.nextInt());
        System.out.println("Insert stadium's hometeam: ");
        this.setHomeTeam(keyboard.nextLine());

        System.out.println("Insert open date:");
        this.setOpened(MakeDate.insertDate());
    }
}
