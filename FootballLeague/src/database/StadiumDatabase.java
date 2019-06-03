package database;

import persons.Manager;
import persons.Player;
import sportComplexes.Stadium;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StadiumDatabase {
    public void createStadiumTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists stadium ("
                + "id int primary key unique auto_increment,"
                + "name varchar(30) not null,"
                + "address varchar(30),"
                + "city varchar(20),"
                + "country varchar(30),"
                + "capacity int,"
                + "hometeam varchar(30),"
                + "open_date date)";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Stadium Table");
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
    public void insertStadium(Stadium stadium){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into stadium(name, address, city, country, capacity, hometeam, open_date)"
                + "values (?,?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,stadium.getName());
            statement.setString(2,stadium.getAddress());
            statement.setString(3,stadium.getCity());
            statement.setString(4,stadium.getCountry());
            statement.setInt(5,stadium.getCapacity());
            statement.setString(6, stadium.getHomeTeam());
            statement.setDate(7, Date.valueOf(stadium.getOpened()));
            statement.executeUpdate();

            System.out.println("Executed Insert Stadium");
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

    public void insertAllStadiums(List<Stadium> stadiums){
        for (Stadium stadium: stadiums)
            insertStadium(stadium);
        System.out.println("Executed Insert All Stadiums");
    }

    public static List<Stadium> selectAllStadiums(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Stadium> stadiums = new ArrayList<>();
        String request = "select * from stadium";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                String name = result.getString("name");
                String address = result.getString("address");
                String city = result.getString("city");
                String country = result.getString("country");
                int capacity = result.getInt("capacity");
                String homeTeam = result.getString("hometeam");
                LocalDate date = result.getDate("open_date").toLocalDate();

                stadiums.add(new Stadium(name,address,city,country,capacity,homeTeam,date));
            }
            System.out.println("Executed Select All Stadiums");
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
        return stadiums;
    }

    public void updateStadium(String name, Stadium stadium){
        String request = "update stadium"
                + "set name = ?, address = ?, city = ?,"
                + "country = ?, capacity = ?, homeTeam = ?, open_date = ? "
                + "where name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,stadium.getName());
            statement.setString(2,stadium.getAddress());
            statement.setString(3,stadium.getCity());
            statement.setString(5,stadium.getCountry());
            statement.setInt(5,stadium.getCapacity());
            statement.setString(6,stadium.getHomeTeam());
            statement.setDate(7,Date.valueOf(stadium.getOpened()));
            statement.setString(8,name);
            statement.executeUpdate();

            System.out.println("Executed Update Stadium");
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

    public void deleteStadium(String name){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from stadium where name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,name);
            statement.executeUpdate();
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

    public Stadium selectByName(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        Stadium stadium = null;
        String request = "select * from stadium where name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,name);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String stadiumName = result.getString("name");
                String address = result.getString("address");
                String city = result.getString("city");
                String country = result.getString("country");
                int capacity = result.getInt("capacity");
                String homeTeam = result.getString("hometeam");
                LocalDate date = result.getDate("open_date").toLocalDate();
                stadium = new Stadium(stadiumName, address, city, country, capacity, homeTeam, date);
            }
            System.out.println("Executed Select Stadium By Name");
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
        return stadium;
    }
}
