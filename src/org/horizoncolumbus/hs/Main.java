package org.horizoncolumbus.hs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Connection connection = null;
        String url = "jdbc:sqlite:Resources/student.db";

        try{
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Success!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        String sqlCreateCmd = "create table students (id INTEGER, student_name TEXT," +
                " grade_level INTEGER, favorite_subject TEXT);";
        try {
            Statement statement = connection.createStatement();
            //statement.execute(sqlCreateCmd);
            System.out.println("Table Created Successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        String sqlInsertCmd = "insert into students values (1, \"Kwabena\", 10, \"Social Studies\");";
        try {
            Statement statement = connection.createStatement();
            //statement.execute(sqlInsertCmd);
            System.out.println("Data Inserted Successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }



        String sqlQueryCommand = "select * from students where grade_level = 10";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueryCommand);
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" +
                        resultSet.getString("student_name") + "\t" +
                        resultSet.getInt("grade_level") + "\t" +
                        resultSet.getString("favorite_subject"));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
