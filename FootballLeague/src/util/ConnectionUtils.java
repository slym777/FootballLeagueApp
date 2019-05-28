package util;

import java.sql.*;

public class ConnectionUtils {
    private static ConnectionUtils instance = new ConnectionUtils();

    private ConnectionUtils(){

    }

    public static ConnectionUtils getInstance(){
        return instance;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballeague", "root", "covrig98");
            if (connection != null){
                System.out.println("Connection established succesfully");
            }
            else System.out.println("Connection not established");
        } catch (SQLException sql) {
            System.out.println("Connection not Established properly: " + sql);
        }
        return connection;
    }

    public static void main(String[] args){
        getConnection();
    }

}

