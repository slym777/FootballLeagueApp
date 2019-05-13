package services;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceCSV {
    private static ServiceCSV instance = new ServiceCSV();

    public static ServiceCSV getInstance() {
        return instance;
    }

    private ServiceCSV() {
    }

    public List<List<String>> ReadFromCSV(String filePath) throws FileNotFoundException, IOException {
        List<List<String>> readResult = new ArrayList<>();
        String line;

        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
        while ((line = csvReader.readLine()) != null) {
            List<String> data = Arrays.asList(line.split(","));

            readResult.add(data);
        }

        csvReader.close();
        return readResult;
    }

    private void WriteToCSV(String filePath, List<List<String>> dataToInsert, List<String> header) throws IOException, FileNotFoundException {
        FileWriter csvWriter = new FileWriter(filePath);
        for (String head : header) {
            csvWriter.append(head);
            if (head.equals(header.get(header.size() - 1)) == false)
                csvWriter.append(',');
        }
        csvWriter.append("\n");

        for (List<String> rowData : dataToInsert) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }

    public void createPlayersCSV() throws IOException {
        String head = "First Name, Last Name, makeDate.makeDate of Birth, Height, Weight, Football CLub, Number, Postion, Foot";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Cristiano", "Ronaldo", "05-02-1985", "1.84", "87", "Juventus Torino", "7", "Forward", "Right"),
                Arrays.asList("Lionel", "Messi", "24-06-19857", "1.7", "78", "Real Madrid", "10", "Forward", "Right")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\PlayersCSV.csv", data, header);
    }

    public void createFootballCLubCSV() throws IOException {
        String head = "Club Name, Stadium, Established , Manager, Sponsor, League";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Real Madrid", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Juventus Torino", "Juventus Stadium", "22-06-1957", "Alegri", "Nike", "Premier League")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\FootballClubsCSV.csv", data, header);

    }

    public void createStadiumsCSV() throws IOException {
        String head = "Stadium Name, Address, City, Country, Capacity, Home Team, Open";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Santiago Bernabeu", "Corso Gaetano Scirea 50", "Madrid", "Spain", "91000", "Real Madrid", "14-12-1947"),
                Arrays.asList("Juventus Stadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Juventus Torino", "08-09-2011")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\StadiumsCSV.csv", data, header);

    }

    public void createSponsorsCSV() throws IOException {
        String head = "Sponsor Name, Established makeDate.makeDate";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Adidas", "18-08-1949"),
                Arrays.asList("Nike", "25-01-1964")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\SponsorsCSV.csv", data, header);

    }

    public void createManagersCSV() throws IOException {
        String head = "First Name, Last Name, Date of Birth, Height, Weight, Football CLub";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Zinedine", "Zidane", "05-02-1985", "1.84", "87", "Real Madrid"),
                Arrays.asList("Masimiliano", "Alegri", "24-06-19857", "1.7", "78", "Juventus Torino")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\ManagersCSV.csv", data, header);
    }

    public void createRefereesCSV() throws IOException {
        String head = "First Name, Last Name, Date of Birth, Height, Weight, Category";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Howard", "Webb", "05-02-1985", "1.84", "87", "International Fifa"),
                Arrays.asList("Martin", "Atkinson", "24-06-19857", "1.7", "78", "Premier League")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\RefereesCSV.csv", data, header);
    }

    public void createMatchesCSV() throws IOException {
        String head = "Stage, Home Team, Guest Team, Home Team Score, Guest Team Score,  Date of Match, Referee";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("1", "Real Madrid", "Juventus Torino", "2", "1", "13-05-2018", "Webb"),
                Arrays.asList("2", "Juventus Torino", "Real Madrid", "2", "0", "02-05-2018", "Atkinson")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\MatchesCSV.csv", data, header);
    }




}

