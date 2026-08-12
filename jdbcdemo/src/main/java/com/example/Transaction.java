package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/demodb";
    String username = "root";
    String password = "root";

    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url, username, password);
      connection.setAutoCommit(false);

      Statement statement1 = connection.createStatement();
      ResultSet resultSet1 = statement1.executeQuery("select * from accounts");

      System.out.println("before transaction:");
      while (resultSet1.next()) {
        System.out.println(
          resultSet1.getInt("id") +
            ":" +
            resultSet1.getString("name") +
            ":" +
            resultSet1.getBigDecimal("balance")
        );
      }

      System.out.println();

      PreparedStatement preparedStatement1 = connection.prepareStatement(
        "update accounts set balance=balance-500 where id=1"
      );
      preparedStatement1.executeUpdate();

      PreparedStatement preparedStatement2 = connection.prepareStatement(
        "update accounts set balance=balance+500 where id=2"
      );
      preparedStatement2.executeUpdate();

      connection.commit();

      Statement statement2 = connection.createStatement();
      ResultSet resultSet2 = statement2.executeQuery("select * from accounts");

      System.out.println("after transaction:");
      while (resultSet2.next()) {
        System.out.println(
          resultSet2.getInt("id") +
            ":" +
            resultSet2.getString("name") +
            ":" +
            resultSet2.getBigDecimal("balance")
        );
      }

      connection.close();
    } catch (SQLException err) {
      try {
        if (connection != null) {
          connection.rollback();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

      err.printStackTrace();
    }
  }
}
