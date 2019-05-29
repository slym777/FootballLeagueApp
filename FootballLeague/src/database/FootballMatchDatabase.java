package database;

import model.FootballClub;
import model.Match;
import persons.Manager;
import persons.Person;
import persons.Player;
import persons.Referee;
import services.*;
import sponsors.Sponsor;
import sportComplexes.Stadium;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FootballMatchDatabase {
    public void createFootballMatchTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists footballmatch ("
                + "id int primary key unique auto_increment,"
                + "stage int not null,"
                + "home_team varchar(30),"
                + "guest_team varchar(30),"
                + "homeTeam_score int,"
                + "guestTeam_score int,"
                + "date date,"
                + "referee varchar(30))";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Football Match Table");
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
    public void insertFootballMatch(Match match){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into footballmatch(stage, home_team, guest_team, homeTeam_score, guestTeam_score, date, referee)"
                + "values (?,?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setInt(1, match.getStage());
            statement.setString(2, match.getHomeTeam().getName());
            statement.setString(3, match.getGuestTeam().getName());
            statement.setInt(4, match.getHomeTeamScore());
            statement.setInt(5, match.getGuestTeamScore());
            statement.setDate(6, Date.valueOf(match.getDate()));
            statement.setString(7, match.getReferee().getLastName());
            statement.executeUpdate();

            System.out.println("Executed Insert Football Match");
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

    public void insertAllFootballMatches(List<Match> footballMatches){
        for (Match match: footballMatches)
            insertFootballMatch(match);
        System.out.println("Executed Insert All Football Matches");
    }

    public List<Match> selectAllFootballMatches(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Match> footballMatches = new ArrayList<>();

        String request = "select * from footballmatch";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int stage = result.getInt("stage");
                String home = result.getString("home_team");
                String guest = result.getString("guest_team");
                int homeScore = result.getInt("homeTeam_score");
                int guestScore = result.getInt("guestTeam_score");
                LocalDate matchDate = result.getDate("date").toLocalDate();
                String matchReferee = result.getString("referee");

                Optional<FootballClub> homeTemp = FootballClubService.getListOfFootballClubs().stream().filter(p->p.getName().equals(home)).findFirst();
                FootballClub homeTeam = homeTemp.get();
                Optional<FootballClub> guestTemp = FootballClubService.getListOfFootballClubs().stream().filter(p->p.getName().equals(guest)).findFirst();
                FootballClub guestTeam = guestTemp.get();
                Optional<Referee> refereeTemp = PersonsService.getListOfReferees().stream().filter(p->p.getLastName().equals(matchReferee)).findFirst();
                Referee referee = refereeTemp.get();

                footballMatches.add(new Match(stage, homeTeam, guestTeam, homeScore, guestScore, matchDate, referee));
            }
            System.out.println("Executed Select All Football Matches");
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
        return footballMatches;
    }

    public void updateFootballMatch(int stage, String homeTeam, String guestTeam, Match match){
        String request = "update footballmatch"
                + "set stage = ?, home_team = ?, guest_team = ?,"
                + "homeTeam_score = ?, guestTeam_score = ?, date = ?,"
                + "referee = ? where stage = ? and home_team like ? and guest_team like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setInt(1, match.getStage());
            statement.setString(2, match.getHomeTeam().getName());
            statement.setString(3, match.getGuestTeam().getName());
            statement.setInt(4, match.getHomeTeamScore());
            statement.setInt(5, match.getGuestTeamScore());
            statement.setDate(6, Date.valueOf(match.getDate()));
            statement.setString(7, match.getReferee().getLastName());
            statement.setInt(8, stage);
            statement.setString(9, homeTeam);
            statement.setString(10,guestTeam);
            statement.executeUpdate();

            System.out.println("Executed Update Football Match");
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

    public void deleteFootballMatch(int stage, String homeTeam, String guestTeam){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from footballmatch where stage = ? and home_team like ? and guest_team like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setInt(1, stage);
            statement.setString(2, homeTeam);
            statement.setString(3, guestTeam);
            statement.executeUpdate();

            System.out.println("Executed Delete Football Match");
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

    public Match selectMatch(int matchStage, String homeTeamName, String guestTeamName){
        Connection connection = null;
        PreparedStatement statement = null;
        Match match = null;
        String request = "select * from footballmatch where stage = ? and home_team like ? and guest_team like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setInt(1, matchStage);
            statement.setString(2, homeTeamName);
            statement.setString(3, guestTeamName);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                int stage = result.getInt("stage");
                String home = result.getString("home_team");
                String guest = result.getString("guest_team");
                int homeScore = result.getInt("homeTeam_score");
                int guestScore = result.getInt("guestTeam_score");
                LocalDate matchDate = result.getDate("date").toLocalDate();
                String matchReferee = result.getString("referee");

                Optional<FootballClub> homeTemp = FootballClubService.getListOfFootballClubs().stream().filter(p->p.getName().equals(home)).findFirst();
                FootballClub homeTeam = homeTemp.get();
                Optional<FootballClub> guestTemp = FootballClubService.getListOfFootballClubs().stream().filter(p->p.getName().equals(guest)).findFirst();
                FootballClub guestTeam = guestTemp.get();
                Optional<Referee> refereeTemp = PersonsService.getListOfReferees().stream().filter(p->p.getLastName().equals(matchReferee)).findFirst();
                Referee referee = refereeTemp.get();

                match = new Match(stage, homeTeam, guestTeam, homeScore, guestScore, matchDate, referee);
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
        return match;
    }
}
