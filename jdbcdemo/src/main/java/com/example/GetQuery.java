package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetQuery {

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
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from animes");

      while (resultSet.next()) {
        System.out.println(
          resultSet.getInt("id") + ":" + resultSet.getString("name")
        );
      }

      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
