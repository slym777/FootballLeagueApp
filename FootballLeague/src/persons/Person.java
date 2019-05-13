package persons;

import makeDate.MakeDate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateofBirth;
    private double height;
    private double weight;

    public Person(String firstName, String lastName, LocalDate dateofBirth, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.height = height;
        this.weight = weight;
    }

    public Person(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge(){
        return Period.between(dateofBirth, LocalDate.now()).getYears();
    }

    public abstract void printInfo();

    public void addPersonInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insert First Name: ");
        this.setFirstName(keyboard.nextLine());
        System.out.println("Insert Last Name: ");
        this.setLastName(keyboard.nextLine());

        System.out.println("Insert birth date:");
        this.setDateofBirth(MakeDate.insertDate());

        System.out.println("Insert weight:");
        this.setWeight(keyboard.nextDouble());
        System.out.println("Insert height:");
        this.setHeight(keyboard.nextDouble());
        keyboard.nextLine();
        System.out.println("Insert referee's category");
    }
}
