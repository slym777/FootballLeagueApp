package database;

import persons.Manager;
import persons.Player;
import sponsors.Sponsor;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SponsorDatabase {
    public void createSponsorTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists sponsor ("
                + "id int primary key unique auto_increment,"
                + "name varchar(30) not null,"
                + "established_date date)";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Sponsor Table");
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
    public void insertSponsor(Sponsor sponsor){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into sponsor(name, established_date)"
                + "values (?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,sponsor.getName());
            statement.setDate(2, Date.valueOf(sponsor.getEstablished()));

            statement.executeUpdate();
            System.out.println("Executed Insert Sponsor");
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

    public void insertAllSponsors(List<Sponsor> sponsors){
        for (Sponsor sponsor: sponsors)
            insertSponsor(sponsor);
    }

    public List<Sponsor> selectAllSponsors(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Sponsor> sponsors = new ArrayList<>();

        String request = "select * from sponsor";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                String name = result.getString("name");
                LocalDate established = result.getDate("established_date").toLocalDate();
                sponsors.add(new Sponsor(name, established));
            }
            System.out.println("Executed Select All Sponsors");
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
        return sponsors;
    }

    public void updateSponsor(String name, Sponsor sponsor){
        String request = "update sponsor"
                + "set name = ?, established_date ? where name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,sponsor.getName());
            statement.setDate(2,Date.valueOf(sponsor.getEstablished()));
            statement.setString(3,name);
            statement.executeUpdate();
            System.out.println("Executed Update Sponsor");
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

    public void deleteSponsor(String name){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from sponsor where name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Executed Delete Table");
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

    public Sponsor selectByName(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        Sponsor sponsor = null;
        String request = "select * from sponsor where name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,name);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String sponsorName = result.getString("name");
                LocalDate established = result.getDate("established_date").toLocalDate();

                sponsor = new Sponsor(sponsorName,established);
            }
            System.out.println("Executed Select Sponsor By Name");
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
        return sponsor;
    }
}
