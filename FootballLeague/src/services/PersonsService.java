package services;

import persons.Manager;
import persons.Player;
import persons.Referee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PersonsService {

    private static ArrayList<Player> listOfPlayers = new ArrayList<>();
    private static ArrayList<Referee> listOfReferees = new ArrayList<>();
    private static ArrayList<Manager> listOfManagers = new ArrayList<>();

    private static PersonsService instance = new PersonsService();

    private PersonsService(){
    }

    public static PersonsService getInstance(){
        return instance;
    }

    static {
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\PlayersCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String firstname = info.get(0);
                String lastname = info.get(1);
                List<String> dateInfo = Arrays.asList(info.get(2).split("-"));
                Double height = Double.parseDouble(info.get(3));
                Double weight = Double.parseDouble(info.get(4));
                String footballClub = info.get(5);
                String position = info.get(7);
                int number = Integer.parseInt(info.get(6));
                String foot = info.get(8);
                Player player = new Player(firstname, lastname,LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), height, weight, position, number, footballClub, foot);
                listOfPlayers.add(player);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }

        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\ManagersCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String firstname = info.get(0);
                String lastname = info.get(1);
                List<String> dateInfo = Arrays.asList(info.get(2).split("-"));
                Double height = Double.parseDouble(info.get(3));
                Double weight = Double.parseDouble(info.get(4));
                String footballClub = info.get(5);
                Manager manager = new Manager(firstname, lastname,LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), height, weight, footballClub);
                listOfManagers.add(manager);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }

        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\RefereesCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String firstname = info.get(0);
                String lastname = info.get(1);
                List<String> dateInfo = Arrays.asList(info.get(2).split("-"));
                Double height = Double.parseDouble(info.get(3));
                Double weight = Double.parseDouble(info.get(4));
                String category = info.get(5);
                Referee referee = new Referee(firstname, lastname,LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))), height, weight, category);
                listOfReferees.add(referee);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }
    }


    public static List<Player> getListOfPlayers(){
        return listOfPlayers;
    }

    public static List<Referee> getListOfReferees(){
        return listOfReferees;
    }

    public static List<Manager> getListOfManagers(){
        return listOfManagers;
    }


    public static Player getPlayerByName(String name){
        for (Player player : listOfPlayers){
            if (player.getLastName().equals(name))
                return player;
        }
        return null;
    }

    public static Manager getManagerByName(String name){
        for (Manager manager : listOfManagers){
            if (manager.getLastName().equals(name))
                return manager;
        }
        return null;
    }

    public static Referee getRefereeByName(String name){
        for (Referee referee : listOfReferees) {
            if (referee.getLastName().equals(name))
                return referee;
        }
        return null;
    }

    public static void addPlayer(){
        Scanner keyboard = new Scanner(System.in);
        Player newPlayer = new Player();
        newPlayer.addPersonInfo();
        listOfPlayers.add(newPlayer);
    }

    public static void addReferee(){
        Scanner keyboard = new Scanner(System.in);
        Referee newReferee = new Referee();
        newReferee.addPersonInfo();
        listOfReferees.add(newReferee);
    }

    public static void addManager(){
        Scanner keyboard = new Scanner(System.in);
        Manager newManager = new Manager();
        newManager.addPersonInfo();
        listOfManagers.add(newManager);
    }

    public static void deletePlayerByName(String name){
        for (Player player : listOfPlayers) {
            if (player.getLastName().equals(name))
                listOfPlayers.remove(player);
        }
    }

    public static void deleteManagerByName(String name){
        for (Manager manager : listOfManagers){
            if (manager.getLastName().equals(name))
                listOfManagers.remove(manager);
        }
    }

    public static void deleteRefereeByName(String name){
        for (Referee referee : listOfReferees) {
            if (referee.getLastName().equals(name))
                listOfReferees.remove(referee);
        }
    }
}
