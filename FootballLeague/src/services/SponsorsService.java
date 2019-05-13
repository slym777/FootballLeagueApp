package services;

import sponsors.Sponsor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SponsorsService {
    private static ArrayList<Sponsor> listOfSponsors = new ArrayList<>();

    private static SponsorsService instance = new SponsorsService();

    private SponsorsService(){
    }

    public static SponsorsService getInstance(){
        return instance;
    }

    static {
        try {
            List<List<String>> data;
            data = ServiceCSV.getInstance().ReadFromCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\SponsorsCSV.csv");
            data.remove(0);

            for (List<String> info : data) {
                String name = info.get(0);
                List<String> dateInfo = Arrays.asList(info.get(1).split("-"));
                Sponsor sponsor = new Sponsor(name, LocalDate.of(Integer.parseInt(dateInfo.get(2)), Integer.parseInt(dateInfo.get(1)), Integer.parseInt(dateInfo.get(0))));
                listOfSponsors.add(sponsor);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        }
    }


    public static ArrayList<Sponsor> getListOfSponsors(){
        return listOfSponsors;
    }

    public static Sponsor getSponsorByName(String name){
        for (Sponsor sponsor: listOfSponsors)
            if(sponsor.getName().equals(name))
                return sponsor;
        return null;
    }

    public static void addSponsor(){
        Sponsor sponsor = new Sponsor();
        sponsor.addSponsorInfo();
        listOfSponsors.add(sponsor);
    }

    public static void deleteSponsorbyName(String name){
        for (Sponsor sponsor: listOfSponsors)
            if(sponsor.getName().equals(name))
                listOfSponsors.remove(sponsor);
    }



}
