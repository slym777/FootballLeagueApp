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
        String head = "First Name, Last Name, Date of Birth, Height, Weight, Football CLub, Number, Postion, Foot";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Cristiano", "Ronaldo", "05-02-1985", "1.84", "87", "Juventus Torino", "7", "Forward", "Right"),
                Arrays.asList("Lionel", "Messi", "24-06-1987", "1.7", "78", "Real Madrid", "10", "Forward", "Right")
//                Arrays.asList("Paulo", "Dibala", "13-02-1993"), "1,74
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\PlayersCSV.csv", data, header);
    }

    public void createFootballCLubCSV() throws IOException {
        String head = "Club Name, Stadium, Established , Manager, Sponsor, League";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Real Madrid", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Juventus Torino", "Juventus Stadium", "22-06-1957", "Alegri", "Nike", "Premier League"),
                Arrays.asList("Bayern Munchen", "Juventus Stadium", "22-03-1967", "Alegri", "Nike", "Premier League"),
                Arrays.asList("Chelsea", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Arsenal", "Juventus Stadium", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Manchester United", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Manchester City", "Juventus Stadium", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Liverpool", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Totenham", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Milan", "Juventus Stadium", "14-12-1921", "Zidane", "Adidas", "Premier League"),
                Arrays.asList("Barcelona", "Santiago Bernabeu", "14-12-1921", "Zidane", "Adidas", "Premier League")

        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\FootballClubsCSV.csv", data, header);

    }

    public void createStadiumsCSV() throws IOException {
        String head = "Stadium Name, Address, City, Country, Capacity, Home Team, Open";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Santiago Bernabeu", "Corso Gaetano Scirea 50", "Madrid", "Spain", "91000", "Real Madrid", "14-12-1947"),
                Arrays.asList("Juventus Stadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Juventus Torino", "08-09-2011"),
                Arrays.asList("Juven Stadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Bayern Munchen", "08-09-2011"),
                Arrays.asList("Jtus Stadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Totenham", "08-09-2011"),
                Arrays.asList("Juven Stadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Arsenal", "08-09-2011"),
                Arrays.asList("JStadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Manchester United", "08-09-2011"),
                Arrays.asList("Juventus Stm", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Manchester City", "08-09-2011"),
                Arrays.asList("Juventuadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Milan", "08-09-2011"),
                Arrays.asList("JuventsStadium", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Liverpool", "08-09-2011"),
                Arrays.asList("bra", "Av. de Concha Espina 1", "Torino", "Italia", "45000", "Chelsea", "08-09-2011")


        );

        WriteToCSV("StadiumsCSV.csv", data, header);

    }

    public void createSponsorsCSV() throws IOException {
        String head = "Sponsor Name, Established makeDate.makeDate";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Adidas", "18-08-1949"),
                Arrays.asList("Nike", "25-01-1964")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\SponsorsCSV.csv", data, header);

    }

    public void createManagersCSV() throws IOException {
        String head = "First Name, Last Name, Date of Birth, Height, Weight, Football CLub";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Zinedine", "Zidane", "05-02-1985", "1.84", "87", "Real Madrid"),
                Arrays.asList("Mao", "Ari", "24-06-1957", "1.7", "78", "Juventus Torino"),
                Arrays.asList("liano", "Alegri", "24-06-1957", "1.7", "78", "Liverpool"),
                Arrays.asList("Masio", "Alegri", "24-06-1957", "1.7", "78", "Manchester City"),
                Arrays.asList("Masimiliano", "Alri", "24-06-1957", "1.7", "78", "Manchester United"),
                Arrays.asList("Masliano", "Al", "24-06-1957", "1.7", "78", "Barcelona"),
                Arrays.asList("Mjno", "Al", "24-06-1957", "1.7", "78", "Arsenal"),
                Arrays.asList("Mno", "Alri", "24-06-1957", "1.7", "78", "Totenham"),
                Arrays.asList("Bra", "Amu", "24-06-1957", "1.7", "78", "Bayern Munchen"),
                Arrays.asList("B", "Andu", "24-06-1957", "1.7", "78", "Chelsea")


            );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\ManagersCSV.csv", data, header);
    }

    public void createRefereesCSV() throws IOException {
        String head = "First Name, Last Name, Date of Birth, Height, Weight, Category";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("Howard", "Webb", "05-02-1985", "1.84", "87", "International Fifa"),
                Arrays.asList("Martin", "Atkinson", "24-06-1957", "1.7", "78", "Premier League")
        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\RefereesCSV.csv", data, header);
    }

    public void createMatchesCSV() throws IOException {
        String head = "Stage, Home Team, Guest Team, Home Team Score, Guest Team Score,  Date of Match, Referee";
        List<String> header = Arrays.asList(head.split(","));

        List<List<String>> data = Arrays.asList(
                Arrays.asList("1", "Real Madrid", "Juventus Torino", "2", "1", "13-05-2018", "Webb"),
                Arrays.asList("2", "Juventus Torino", "Chelsea", "2", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("1", "Arsenal", "Real Madrid", "1", "3", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Totenham", "Milan", "2", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("1", "Manchester United", "Manchester City", "2", "3", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Juventus Torino", "Liverpool", "2", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("3", "Barcelona", "Arsenal", "4", "1", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Bayern Munchen", "Totenham", "3", "2", "02-05-2018", "Atkinson"),
                Arrays.asList("4", "Milan", "Barcelona", "2", "5", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Manchester United", "Bayern Munchen", "2", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("1", "Barcelona", "Real Madrid", "2", "2", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Liverpool", "Arsenal", "3", "1", "02-05-2018", "Atkinson"),
                Arrays.asList("3", "Totenham", "Chelsea", "0", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("1", "Arsenal", "Real Madrid", "1", "3", "02-05-2018", "Atkinson"),
                Arrays.asList("4", "Juventus Torino", "Milan", "5", "0", "02-05-2018", "Atkinson"),
                Arrays.asList("2", "Juventus Torino", "Barcelona", "1", "1", "02-05-2018", "Atkinson")


        );

        WriteToCSV("C:\\Users\\sl1m\\Desktop\\FootballLeagueApp\\FootballLeague\\src\\filesCSV\\MatchesCSV.csv", data, header);
    }




}

