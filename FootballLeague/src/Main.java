import database.*;
import model.FootballClub;
import model.Match;
import persons.Manager;
import persons.Person;
import persons.Player;
import services.*;
import sponsors.Sponsor;

import javax.swing.*;
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
//            ServiceCSV servicecsv = ServiceCSV.getInstance();
//            servicecsv.createFootballCLubCSV();
//            servicecsv.createPlayersCSV();
//            servicecsv.createSponsorsCSV();
//            servicecsv.createStadiumsCSV();
//            servicecsv.createManagersCSV();
//            servicecsv.createRefereesCSV();
//            servicecsv.createMatchesCSV();
////
////             ########################

            logger.info("Activating services");
            FootballLeagueService LeagueS = FootballLeagueService.getInstance();
            FootballClubService ClubS = FootballClubService.getInstance();
            PersonsService PersonS = PersonsService.getInstance();
            SponsorsService SponsorS = SponsorsService.getInstance();
            StadiumService StadiumS = StadiumService.getInstance();


            logger.info("Printing all clubs available in app");
            System.out.println("Available clubs in Premiere League:");
            for (FootballClub footballClub: ClubS.getListOfFootballClubs())
                System.out.println(footballClub.getName());
            System.out.println();

            logger.info("Printing all players available in app");
            System.out.println("All players from Premiere League:");
            for (Player player: PersonS.getListOfPlayers())
                System.out.println(player.getLastName() + " " + player.getFirstName());
            System.out.println();

            logger.info("Printing all played matches in Premiere League");
            System.out.println("Played Matches in Premiere League");
            for (Match match: FootballLeagueService.getListOfMatches())
                match.printMatch();
            System.out.println();

            logger.info("Calling display league table method");
            System.out.println("Premiere League Table:");
            LeagueS.displayLeagueTeable();
            System.out.println();

            logger.info("Calling League leader method");
            System.out.println("Display Premiere League leader:");
            System.out.println(LeagueS.getLeagueLeader());
            System.out.println();



        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getCause() + "\n" + e.getLocalizedMessage());
        }

//        PlayerDatabase playerDB = new PlayerDatabase();
//        playerDB.createPlayerTable();
//        playerDB.insertAllPlayers(PersonsService.getListOfPlayers());
////        playerDB.selectAllPlayers().stream().map(p->p.getFirstName() + " " + p.getLastName()).forEach(p->System.out.println(p));
////        System.out.println(playerDB.selectByLastName("Ronaldo").getFootballClub());
////
//        ManagerDatabase managerDB = new ManagerDatabase();
//        managerDB.createManagerTable();
//        managerDB.insertAllManagers(PersonsService.getListOfManagers());
////        managerDB.selectAllManagers().stream().map(p->p.getFirstName() + " " + p.getLastName()).forEach(p->System.out.println(p));
////        System.out.println(managerDB.selectByLastName("Zidane").getFootballClub());
////
//        RefereeDatabase refereeDB = new RefereeDatabase();
//        refereeDB.createRefereeTable();
//        refereeDB.insertAllReferees(PersonsService.getListOfReferees());
////        refereeDB.selectAllReferees().stream().map(p->p.getFirstName() + " " + p.getLastName()).forEach(System.out::println);
////        if(refereeDB.selectByLastName("Webb") != null) {
////            System.out.println(refereeDB.selectByLastName("Webb").getLastName());
////        }
////
//        SponsorDatabase sponsorDB = new SponsorDatabase();
//        sponsorDB.createSponsorTable();
//        sponsorDB.insertAllSponsors(SponsorsService.getListOfSponsors());
////        sponsorDB.selectAllSponsors().stream().map(p->p.getName() + " " + p.getEstablished()).forEach(System.out::println);
////        if(sponsorDB.selectByName("Nike") != null)
////            System.out.println(sponsorDB.selectByName("Nike").getName());
////
//        StadiumDatabase stadiumDB = new StadiumDatabase();
//        stadiumDB.createStadiumTable();
//        stadiumDB.insertAllStadiums(StadiumService.getListOfStadiums());
////        stadiumDB.selectAllStadiums().stream().map(p->p.getName()).forEach(System.out::println);
////        if(stadiumDB.selectByName("Santiago Bernabeu") != null)
////            System.out.println(stadiumDB.selectByName("Santiago Bernabeu").getHomeTeam());
//
//        FootballClubDatabase footballClubDB = new FootballClubDatabase();
//        footballClubDB.createFootballClubTable();
//        footballClubDB.insertAllFootballClubs(FootballClubService.getListOfFootballClubs());
////        footballClubDB.selectAllFootballClubs().stream().map(p->p.getName()).forEach(System.out::println);
////        if(footballClubDB.selectByClubName("Real Madrid") != null)
////            System.out.println(footballClubDB.selectByClubName("Real Madrid").getName());
//
//        FootballMatchDatabase footballMatchDB = new FootballMatchDatabase();
//        footballMatchDB.createFootballMatchTable();
//        footballMatchDB.insertAllFootballMatches(FootballLeagueService.getListOfMatches());
    }
}
