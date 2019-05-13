package persons;

import java.time.LocalDate;
import java.util.Scanner;

public class Player extends Person{
    private String position;
    private int number;
    private String footballClub;
    private String foot;

    public Player(String firstName, String lastName, LocalDate dateofBirth, double height, double weight, String position, int number, String footballClub, String foot) {
        super(firstName, lastName, dateofBirth, height, weight);
        this.position = position;
        this.number = number;
        this.footballClub = footballClub;
        this.foot = foot;
    }

    public Player(){
        position = "";
        number = 0;
        foot = "";
        footballClub = "";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(String footballClub) {
        this.footballClub = footballClub;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public void printInfo(){
    }

    public void addPersonInfo(){
        Scanner keyboard = new Scanner(System.in);
        super.addPersonInfo();
        System.out.println("Insert the Club: ");
        this.setFootballClub(keyboard.nextLine());
        System.out.println("Insert his position: ");
        this.setPosition(keyboard.nextLine());
        System.out.println("Insert his number");
        this.setNumber(keyboard.nextInt());
        System.out.println("Insert his foot");
        this.setFoot(keyboard.nextLine());

    }
}
