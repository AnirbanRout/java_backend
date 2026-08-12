package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class BatchQuery {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/demodb";
    String username = "root";
    String password = "root";

    try {
      Connection connection = DriverManager.getConnection(
        url,
        username,
        password
      );

      String sqlQuery = "insert into anime(name,genre) values(?,?)";

      PreparedStatement preparedStatement = connection.prepareStatement(
        sqlQuery
      );

      preparedStatement.setString(1, "overlord");
      preparedStatement.setString(2, "magic");
      preparedStatement.addBatch();

      preparedStatement.setString(1, "pokemon");
      preparedStatement.setString(2, "adventure");
      preparedStatement.addBatch();

      preparedStatement.setString(1, "demon slayer");
      preparedStatement.setString(2, "shounen");
      preparedStatement.addBatch();

      preparedStatement.setString(1, "martial master");
      preparedStatement.setString(2, "martial arts");
      preparedStatement.addBatch();

      preparedStatement.setString(1, "real world");
      preparedStatement.setString(2, "martial arts/cultivation");
      preparedStatement.addBatch();

      int rows[] = preparedStatement.executeBatch();
      System.out.println(Arrays.toString(rows));

      preparedStatement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
