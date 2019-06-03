package database;

import persons.Player;
import util.ConnectionUtils;

import java.security.cert.CertificateParsingException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PlayerDatabase {
    public void createPlayerTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists player ("
                + "id int primary key unique auto_increment,"
                + "first_name varchar(30),"
                + "last_name varchar(30) not null,"
                + "birth_date date,"
                + "height double,"
                + "weight double,"
                + "position varchar(20),"
                + "number int,"
                + "footballclub varchar(30),"
                + "foot varchar(10))";
        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
            statement.execute();

            System.out.println("Executed Create Player Table");
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

    public static void insertPlayer(Player player){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "insert into player(first_name, last_name, birth_date, height, weight, position, number, footballclub, foot)"
                         + "values (?,?,?,?,?,?,?,?,?);";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,player.getFirstName());
            statement.setString(2,player.getLastName());
            statement.setDate(3, Date.valueOf(player.getDateofBirth()));
            statement.setDouble(4,player.getHeight());
            statement.setDouble(5,player.getWeight());
            statement.setString(6,player.getPosition());
            statement.setInt(7,player.getNumber());
            statement.setString(8,player.getFootballClub());
            statement.setString(9,player.getFoot());
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

    public void insertAllPlayers(List<Player> players){
        for (Player player : players)
            insertPlayer(player);
    }

    public static List<Player> selectAllPlayers(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Player> players = new ArrayList<>();

        String request = "select * from player";

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
                String position = result.getString("position");
                int number = result.getInt("number");
                String footballClub = result.getString("footballclub");
                String foot = result.getString("foot");
                players.add(new Player(first, last, date,height,weight,position,number,footballClub,foot));
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
        return players;
    }

    public void updatePlayer(String lastName, Player player){
        String request = "update player"
                + "set first_name = ?, last_name = ?, birth_date = ?,"
                + "height = ?, weight = ?, position = ?, number = ?,"
                + "footballclub = ?, foot = ? where last_name like ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);

            statement.setString(1,player.getFirstName());
            statement.setString(2,player.getLastName());
            statement.setDate(3,Date.valueOf(player.getDateofBirth()));
            statement.setDouble(4,player.getHeight());
            statement.setDouble(5,player.getWeight());
            statement.setString(6,player.getPosition());
            statement.setInt(7,player.getNumber());
            statement.setString(8,player.getFootballClub());
            statement.setString(9,player.getFoot());
            statement.setString(10,lastName);
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

    public static void deletePlayer(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;

        String request = "delete from player where last_name like ?";

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

    public Player selectByLastName(String lastName){
        Connection connection = null;
        PreparedStatement statement = null;
        Player player = null;
        String request = "select * from player where last_name like ?";

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
                ;
                String position = result.getString("position");
                int number = result.getInt("number");
                String footballClub = result.getString("footballclub");
                String foot = result.getString("foot");
                player = new Player(first, last, date, height, weight, position, number, footballClub, foot);
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
        return player;
    }

}
