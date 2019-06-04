package services;

import database.StadiumDatabase;
import sportComplexes.Stadium;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StadiumService {
    private static List<Stadium> listOfStadiums = new ArrayList<>();

    private static StadiumService instance = new StadiumService();

    private StadiumService(){
    }

    public static StadiumService getInstance(){
        return instance;
    }

    static {
        readStadiumsDataFromDatabase();
//        readStadiumsDataFromCSV();
    }

    public static void readStadiumsDataFromCSV(){
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\StadiumsCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String name = info.get(0);
                String address = info.get(1);
                String city = info.get(2);
                String country = info.get(3);
                int capacity = Integer.parseInt(info.get(4));
                String homeTeam = info.get(5);
                List<String> dateInfo = Arrays.asList(info.get(6).split("-"));
                Stadium stadium = new Stadium(name, address, city, country, capacity, homeTeam, LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))));
                listOfStadiums.add(stadium);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }
    }

    public static void readStadiumsDataFromDatabase(){
        listOfStadiums = StadiumDatabase.selectAllStadiums();
    }

    public static List<Stadium> getListOfStadiums(){
        return listOfStadiums;
    }

    public static Stadium getStadiumByName(String name){
        for (Stadium stadium: listOfStadiums){
            if(stadium.getName().equals(name))
                return stadium;
        }
        return null;
    }

    public static void addStadium(){
        Stadium stadium = new Stadium();
        stadium.addStadiumInfo();
        listOfStadiums.add(stadium);
    }

    public static void deleteStadiumByName(String name) {
        for (Stadium stadium : listOfStadiums) {
            if (stadium.getName().equals(name))
                listOfStadiums.remove(stadium);
        }
    }
}
