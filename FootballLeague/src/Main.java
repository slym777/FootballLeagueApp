import model.FootballClub;
import model.Match;
import persons.Player;
import services.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = null;

    public static void main(String[] args) throws IOException, FileNotFoundException {

//        --- delete content from logger.csv file---
        PrintWriter writer = new PrintWriter("C:\\Users\\sl1m\\Desktop\\PAO\\Laboratoare\\PAO_Project\\src\\filesCSV\\logger.csv");
        writer.print("");
        writer.close();

        try {
            logger = LoggerCSV.getInstance();
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String stackTrace = sw.toString();

            logger.severe("Program termination with stack trace:\n" + stackTrace);
            ex.printStackTrace();
        }

        try {
            logger.info("Premiere FootbalLeague app started");

            logger.info("Create all CSV Files");
//            #### Create CSV Files ###
            ServiceCSV servicecsv = ServiceCSV.getInstance();
            servicecsv.createFootballCLubCSV();
            servicecsv.createPlayersCSV();
            servicecsv.createSponsorsCSV();
            servicecsv.createStadiumsCSV();
            servicecsv.createManagersCSV();
            servicecsv.createRefereesCSV();
            servicecsv.createMatchesCSV();

//             ########################

            logger.info("Activating services");
            FootballLeagueService LeagueS = FootballLeagueService.getInstance();
            FootballClubService ClubS = FootballClubService.getInstance();
            PersonsService PersonS = PersonsService.getInstance();
            SponsorsService SponsorS = SponsorsService.getInstance();
            StadiumService StadiumS = StadiumService.getInstance();

            logger.info("Printing all clubs available in app");
            for (FootballClub footballClub: ClubS.getListOfFootballClubs())
                System.out.println(footballClub.getName());
            System.out.println();

            logger.info("Printing all players available in app");
            for (Player player: PersonS.getListOfPlayers())
                System.out.print(player.getLastName() + " " + player.getFirstName() + ", ");
            System.out.println();

            logger.info("Printeding all played matches in Premiere League");
            for (Match match: FootballLeagueService.getListOfMatches())
                match.printMatch();
            System.out.println();

            logger.info("Calling display league table method");
            LeagueS.displayLeagueTeable();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getCause() + "\n" + e.getLocalizedMessage());
        }
    }

}
