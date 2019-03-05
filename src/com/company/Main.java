package com.company;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        String instanceName = "sql.samorodov.su/SALADIN";
        String databaseName = "Northwind";
        String userName = "Хомяков Тимур Вячеславович";
        String pass = "Dptikalamer1";
        String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
        String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
        try {
            // Подключение к базе данных
            Connection con = DriverManager.getConnection(connectionString);
            // Отправка запроса на выборку и получение результатов
            Statement stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM [Categories]");
            // Обход результатов выборки
            while (executeQuery.next()) {
                System.out.println(executeQuery.getString("Category"));
            }
            // Закрываем соединение
            executeQuery.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            // Обработка исключений
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
