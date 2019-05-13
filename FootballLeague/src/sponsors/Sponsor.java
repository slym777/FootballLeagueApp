package sponsors;

import makeDate.MakeDate;

import java.time.LocalDate;
import java.util.Scanner;

public class Sponsor {
    private String name;
    private LocalDate established;

    public Sponsor(String name, LocalDate established) {
        this.name = name;
        this.established = established;
    }

    public Sponsor(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablished() {
        return established;
    }

    public void setEstablished(LocalDate established) {
        this.established = established;
    }

    public void addSponsorInfo(){
        Scanner keyboard = new Scanner(System.in);
        this.setName(keyboard.nextLine());
        this.setEstablished(MakeDate.insertDate());
    }
}


