package database;

import model.FootballClub;
import model.SportsClub;
import persons.Manager;
import persons.Player;
import persons.Referee;
import services.FootballClubService;
import services.PersonsService;
import services.SponsorsService;
import services.StadiumService;
import sponsors.Sponsor;
import sportComplexes.Stadium;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FootballClubDatabase {
    public void createFootballClubTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists footballclub ("
                        + "id int primary key unique auto_increment,"
                        + "club_name varchar(30),"
                        + "stadium varchar(30),"
                        + "established date,"
                        + "manager varchar(30),"
                        + "sponsor varchar(20),"
                        + "league varchar(20))";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Football Club Table");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void insertFootballClub(FootballClub footballClub){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into footballclub(club_name, stadium, established, manager, sponsor, league)"
                + "values (?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1, footballClub.getName());
            statement.setString(2, footballClub.getStadium().getName());
            statement.setDate(3, Date.valueOf(footballClub.getEstablished()));
            statement.setString(4, footballClub.getManager().getLastName());
            statement.setString(5, footballClub.getSponsor().getName());
            statement.setString(6, footballClub.getLeague());
            statement.executeUpdate();

            System.out.println("Executed Insert Football Club");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void insertAllFootballClubs(List<FootballClub> footballClubs){
        for (FootballClub footballClub: footballClubs)
            insertFootballClub(footballClub);
        System.out.println("Executed Insert All Football Clubs");
    }

    public static List<FootballClub> selectAllFootballClubs(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<FootballClub> footballClubs = new ArrayList<>();

        String request = "select * from footballclub";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                String clubName = result.getString("club_name");
                String clubStadium = result.getString("stadium");
                LocalDate established = result.getDate("established").toLocalDate();
                String clubManager = result.getString("manager");
                String clubSponsor = result.getString("sponsor");
                String league = result.getString("league");

                Optional<Stadium> stadiumTemp = StadiumService.getListOfStadiums().stream().filter(p->p.getName().equals(clubStadium)).findFirst();
                Stadium stadium = stadiumTemp.get();
                Optional<Manager> managerTemp = PersonsService.getListOfManagers().stream().filter(p->p.getLastName().equals(clubManager)).findFirst();
                Manager manager = managerTemp.get();
                Optional<Sponsor> sponsorTemp = SponsorsService.getListOfSponsors().stream().filter(p->p.getName().equals(clubSponsor)).findFirst();
                Sponsor sponsor = sponsorTemp.get();

                List<Player> players = new ArrayList<>();
                players = PersonsService.getListOfPlayers().stream().filter(p->p.getFootballClub().equals(clubName)).collect(Collectors.toList());

                footballClubs.add(new FootballClub(clubName, stadium, established, manager, players, sponsor, league));
            }
            System.out.println("Executed Select All Football Club");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return footballClubs;
    }

    public void updateFootballClub(String clubName, FootballClub footballClub){
        String request = "update footballclub"
                + "set club_name = ?, stadium = ?, established = ?,"
                + "manager = ?, sponsor = ?, league = ? where club_name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1, footballClub.getName());
            statement.setString(2, footballClub.getStadium().getName());
            statement.setDate(3, Date.valueOf(footballClub.getEstablished()));
            statement.setString(4, footballClub.getManager().getLastName());
            statement.setString(5, footballClub.getSponsor().getName());
            statement.setString(6, footballClub.getLeague());
            statement.setString(7, clubName);
            statement.executeUpdate();

            System.out.println("Executed Update Football Club");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteFootballClub(String clubName){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from footballclub where club_name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1, clubName);
            statement.executeUpdate();

            System.out.println("Executed Delete Football Club");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FootballClub selectByClubName(String clubName){
        Connection connection = null;
        PreparedStatement statement = null;
        FootballClub footballClub = null;
        String request = "select * from footballclub where club_name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,clubName);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String name = result.getString("club_name");
                String clubStadium = result.getString("stadium");
                LocalDate established = result.getDate("established").toLocalDate();
                String clubManager = result.getString("manager");
                String clubSponsor = result.getString("sponsor");
                String league = result.getString("league");

                Optional<Stadium> stadiumTemp = StadiumService.getListOfStadiums().stream().filter(p->p.getName().equals(clubStadium)).findFirst();
                Stadium stadium = stadiumTemp.get();
                Optional<Manager> managerTemp = PersonsService.getListOfManagers().stream().filter(p->p.getLastName().equals(clubManager)).findFirst();
                Manager manager = managerTemp.get();
                Optional<Sponsor> sponsorTemp = SponsorsService.getListOfSponsors().stream().filter(p->p.getName().equals(clubSponsor)).findFirst();
                Sponsor sponsor = sponsorTemp.get();

                List<Player> players = new ArrayList<>();
                players = PersonsService.getListOfPlayers().stream().filter(p->p.getFootballClub().equals(name)).collect(Collectors.toList());

                footballClub = new FootballClub(name, stadium, established, manager, players, sponsor, league);
            }
            System.out.println("Executed Select Football Club By Name");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally {
            if (statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return footballClub;
    }
}
