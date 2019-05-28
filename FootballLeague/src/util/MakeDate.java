package util;

import java.time.LocalDate;
import java.util.Scanner;

public class MakeDate {
    public static LocalDate insertDate(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Day: ");
        int day = keyboard.nextInt();
        System.out.println("Month: ");
        int month = keyboard.nextInt();
        System.out.println("Year");
        int year = keyboard.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
}
