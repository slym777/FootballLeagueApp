package persons;

import java.time.LocalDate;
import java.util.Scanner;

public class Referee extends Person{
    private String category;

    public Referee(String firstName, String lastName, LocalDate dateofBirth, double height, double weight, String category){
        super(firstName, lastName, dateofBirth, height, weight);
        this.category = category;
    }

    public Referee(){

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void printInfo(){

    }

   public void addPersonInfo(){
        Scanner keyboard = new Scanner(System.in);
        super.addPersonInfo();
        System.out.println("Insert his category: ");
        this.setCategory(keyboard.nextLine());
    }
}
