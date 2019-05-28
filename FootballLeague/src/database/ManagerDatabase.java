package database;

import persons.Manager;
import persons.Player;
import util.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerDatabase {
    public void createManagerTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists manager ("
                        + "id int primary key unique auto_increment,"
                        + "first_name varchar(30),"
                        + "last_name varchar(30) not null,"
                        + "birth_date date,"
                        + "height double,"
                        + "weight double,"
                        + "footballclub varchar(30))";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Manager Table");
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
public void insertManager(Manager manager){
    Connection connection = null;
    PreparedStatement statement = null;
        String request = "insert into manager(first_name, last_name, birth_date, height, weight, footballclub)"
                + "values (?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,manager.getFirstName());
            statement.setString(2,manager.getLastName());
            statement.setDate(3, Date.valueOf(manager.getDateofBirth()));
            statement.setDouble(4,manager.getHeight());
            statement.setDouble(5,manager.getWeight());
            statement.setString(6,manager.getFootballClub());
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

    public void insertAllManagers(List<Manager> managers){
        for (Manager manager: managers)
            insertManager(manager);
    }

    public List<Manager> selectAllManagers(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Manager> managers = new ArrayList<>();

        String request = "select * from manager";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                String first = result.getString("first_name");
                String last = result.getString("last_name");
                LocalDate date = result.getDate("birth_date").toLocalDate();
                double height = result.getDouble("height");
                double weight = result.getDouble("weight");;
                String footballClub = result.getString("footballclub");

                managers.add(new Manager(first, last, date,height,weight,footballClub));
            }
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
        return managers;
    }

    public void updateManager(String lastName, Manager manager){
        String request = "update manager"
                + "set first_name = ?, last_name = ?, birth_date = ?,"
                + "height = ?, weight = ?, footballclub = ? where last_name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,manager.getFirstName());
            statement.setString(2,manager.getLastName());
            statement.setDate(3,Date.valueOf(manager.getDateofBirth()));
            statement.setDouble(4,manager.getHeight());
            statement.setDouble(5,manager.getWeight());
            statement.setString(6,manager.getFootballClub());
            statement.setString(7,lastName);
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

    public void delete(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from manager where last_name like ?";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.setString(1,lastName);
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

    public Manager selectByLastName(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;
        Manager manager = null;
        String request = "select * from manager where last_name like ?";

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
                String footballClub = result.getString("footballclub");
                manager = new Manager(first, last, date, height, weight, footballClub);
            }
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
        return manager;
    }
}

