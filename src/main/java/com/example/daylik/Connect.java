package com.example.daylik;

import java.sql.*;
import java.util.ArrayList;

import static com.example.daylik.HelloController.oldPush;
import static com.example.daylik.HelloController.oldSqr;

public class Connect {
    String url = "jdbc:postgresql://localhost:5432/daylik";
    String user = "postgres";
    String password = "root";

    public static String push;
    static String sqr;


    public void changeDB(int pushWrite, int sqrWrite) {
        String sql = "UPDATE daylik SET push = ?, sqr = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int a = pushWrite + oldPush;
            int b = sqrWrite + oldSqr;


            pstmt.setString(2, String.valueOf(b));
            pstmt.setString(1, String.valueOf(a));

            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectPUSHfromDB() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  daylik");
            while (resultSet.next()) {
                push = resultSet.getString("push");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних: " + e.getMessage());
        }
        return push;
    }

    public String selectSQRfromDB() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  daylik");
            while (resultSet.next()) {
                sqr = resultSet.getString("sqr");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних: " + e.getMessage());
        }
        return sqr;
    }

    public void checkpointP() {
        String sql = "UPDATE daylik SET push100 = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "1");
            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void checkpointSQR() {
        String sql = "UPDATE daylik SET sqr100 = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "1");
            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void reloadDB() {
        String sql = "UPDATE daylik SET push = ?, sqr = ? WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(2, String.valueOf(0));
            pstmt.setString(1, String.valueOf(0));

            pstmt.executeUpdate();
            System.out.println("Базу данних змінено");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
