package database;

import util.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FootballClubDatabase {
    public void createFootballClubTable(){
        Connection connection = null;
        PreparedStatement statement = null;
        String request = "create table if not exists footballclub ("
                        + "id int primary key unique auto_increment"
                        + "";

        try{
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(request);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
