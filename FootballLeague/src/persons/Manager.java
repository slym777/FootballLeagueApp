package persons;

import java.time.LocalDate;
import java.util.Scanner;

public class Manager extends Person{
    private String footballClub;

    public Manager(String firstName, String lastName, LocalDate dateofBirth, double height, double weight, String footballClub){
        super(firstName, lastName, dateofBirth, height, weight);
        this.footballClub = footballClub;
    }

    public Manager(){
    }

    public String getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(String footballClub) {
        this.footballClub = footballClub;
    }

    public void printInfo(){
    }

    public void addPersonInfo(){
        Scanner keyboard = new Scanner(System.in);
        super.addPersonInfo();
        System.out.println("Insert his Club: ");
        this.setFootballClub(keyboard.nextLine());
    }

}
