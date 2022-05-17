package be.intecbrussel;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        /* 3 delen:
            - DB URL: jdbc:mysql://addressVanDatabase:port/database
            - Username: jouw database username
            - Password: jouw database password

         */

        String url = "moktok.intecbrussel.org";
        String port = "33062";
        String database = "JAVAJANAviva";

        String databaseURL = String.format("jdbc:mysql://%s:%s/%s", url, port, database);

        try {
            Connection connection = DriverManager.getConnection(databaseURL, "JAVAJANAviva", kbd.nextLine());
            System.out.println(connection.isValid(5));

            String query = "SELECT * FROM Brewers WHERE Turnover > 5000;";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                //ID turnover
                //int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                int turnover = resultSet.getInt("turnover");

                System.out.println("Name: " + name + " - Turnover: " + turnover);

            }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}