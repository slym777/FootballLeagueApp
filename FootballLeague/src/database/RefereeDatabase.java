package database;

import persons.Referee;
import persons.Player;
import persons.Referee;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RefereeDatabase {
    public void createRefereeTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists referee ("
                + "id int primary key unique auto_increment,"
                + "first_name varchar(30),"
                + "last_name varchar(30) not null,"
                + "birth_date date,"
                + "height double,"
                + "weight double,"
                + "category varchar(30))";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Referee Table");
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
    public void insertReferee(Referee referee){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into referee(first_name, last_name, birth_date, height, weight, category)"
                + "values (?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,referee.getFirstName());
            statement.setString(2,referee.getLastName());
            statement.setDate(3, Date.valueOf(referee.getDateofBirth()));
            statement.setDouble(4,referee.getHeight());
            statement.setDouble(5,referee.getWeight());
            statement.setString(6,referee.getCategory());
            statement.executeUpdate();

            System.out.println("Executed Insert Referee");
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

    public void insertAllReferees(List<Referee> referees){
        for (Referee referee: referees)
            insertReferee(referee);
        System.out.println("Executed Insert All Referees");
    }

    public List<Referee> selectAllReferees(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Referee> referees= new ArrayList<>();

        String request = "select * from referee";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                String first = result.getString("first_name");
                String last = result.getString("last_name");
                LocalDate date = result.getDate("birth_date").toLocalDate();
                double height = result.getDouble("height");
                double weight = result.getDouble("weight");
                String category = result.getString("category");

                referees.add(new Referee(first, last, date,height,weight,category));
            }
            System.out.println("Executed Select All Referees");
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
        return referees;
    }

    public void updateReferee(String lastName, Referee referee){
        String request = "update referee"
                + "set first_name = ?, last_name = ?, birth_date = ?,"
                + "height = ?, weight = ?, category = ? where last_name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,referee.getFirstName());
            statement.setString(2,referee.getLastName());
            statement.setDate(3,Date.valueOf(referee.getDateofBirth()));
            statement.setDouble(4,referee.getHeight());
            statement.setDouble(5,referee.getWeight());
            statement.setString(6,referee.getCategory());
            statement.setString(9,lastName);
            statement.executeUpdate();

            System.out.println("Executed Update Referee");
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

    public void deleteReferee(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from referee where last_name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,lastName);
            statement.executeUpdate();

            System.out.println("Executed Delete Referee");
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

    public Referee selectByLastName(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;
        Referee referee = null;
        String request = "select * from referee where last_name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,lastName);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String first = result.getString("first_name");
                String last = result.getString("last_name");
                LocalDate date = result.getDate("birth_date").toLocalDate();
                double height = result.getDouble("height");
                double weight = result.getDouble("weight");
                String category = result.getString("category");
                referee = new Referee(first, last, date, height, weight, category);
            }
            System.out.println("Executed Select Referee By Name");
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
        return referee;
    }
}
