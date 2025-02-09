package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quiz extends JFrame implements ActionListener {

    // Other class members...

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://your_database_url:port/quiz";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        new Quiz("User");
    }

    Quiz(String name) {
        // Other constructor code...

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            loadDataFromDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Other constructor code...
    }

    private void loadDataFromDatabase(Connection connection) {
        String query = "SELECT question, option1, option2, option3, option4, correct_answer FROM qw";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            int i = 0;
            while (resultSet.next()) {
                questions[i][0] = resultSet.getString("question");
                questions[i][1] = resultSet.getString("option1");
                questions[i][2] = resultSet.getString("option2");
                questions[i][3] = resultSet.getString("option3");
                questions[i][4] = resultSet.getString("option4");
                answers[i][1] = resultSet.getString("correct_answer");
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods and actionPerformed remain unchanged...

}