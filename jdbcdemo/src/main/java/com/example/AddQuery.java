package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddQuery {

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

      preparedStatement.setString(1, "solo leveling");
      preparedStatement.setString(2, "dungeon");

      int rows = preparedStatement.executeUpdate();
      System.out.println(rows);

      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
