package com.example.daylik;

import java.sql.*;
import java.util.ArrayList;

import static com.example.daylik.HelloController.oldPush;
import static com.example.daylik.HelloController.oldSqr;

public class Connect {
    String url = "jdbc:postgresql://localhost:5432/daylik";
    String user = "postgres";
    String password = "root";

    public static int push;
    public static int sqr;


    public void changeDB(int pushWrite, int sqrWrite) {
        String sql = "UPDATE daylik SET push = ?, sqr = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int a = pushWrite + oldPush;
            int b = sqrWrite + oldSqr;


            pstmt.setInt(2, b);
            pstmt.setInt(1, a);

            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
            System.out.println("записано a= " + a);
            System.out.println("записано b= " + b);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int selectPUSHfromDB() {////////////////////////
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  daylik");
            while (resultSet.next()) {
                push = resultSet.getInt("push");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних: " + e.getMessage());
        }
        return push;
    }

    public int selectSQRfromDB() {//////////////////////////
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  daylik");
            while (resultSet.next()) {
                sqr = resultSet.getInt("sqr");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних: " + e.getMessage());
        }
        return sqr;
    }

    public void reloadDB() {
        String sql = "UPDATE daylik SET push = ?, sqr = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(2, 0);
            pstmt.setInt(1, 0);

            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
            System.out.println("записано a= " + 0);
            System.out.println("записано b= " + 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
