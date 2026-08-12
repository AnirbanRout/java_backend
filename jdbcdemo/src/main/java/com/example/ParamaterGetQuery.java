package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParamaterGetQuery {

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

      String sqlQuery = "select * from anime where name=?";
      PreparedStatement preparedStatement = connection.prepareStatement(
        sqlQuery
      );

      preparedStatement.setString(1, "yuru camp");
      ResultSet resultSet = preparedStatement.executeQuery();

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
