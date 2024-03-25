package org.example;

import java.sql.*;

public class SQL_Connection2 {

    public static void main(String[] args) {

        try{

            //STAP 01: de paketten importeren
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("STEP 1 -> SUCCESS: " + "Driver is configured.");

            //STAP 02: een verbinding openen
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "elmaz", "54321");
            System.out.println("STEP 2 -> : " + " Connection is made between MYSQL and JAVA");

            //STAP 03:Een/Meerdere queries uitvoeren /Statement uitvoeren

            //STAP 03.01 : SELECT STATEMENT
            Statement selectStatement = connection.createStatement();


            ResultSet selectResult = selectStatement.executeQuery("SELECT Id,Name,BrewerId,CategoryId,Price,Stock,Alcohol FROM beers");
            while (selectResult.next()) {
                System.out.println(
                        selectResult.getRow()+ "|"
                        +selectResult.getString("Name")+ "|"+
                        selectResult.getInt("BrewerId")+ "|"+
                        selectResult.getInt("CategoryId")+ "|"+
                        selectResult.getFloat("Price")+ "|"+
                        selectResult.getInt("Stock")+ "|"+
                        selectResult.getFloat("Alcohol")
                );
            }


            // STAP 03: Een insert query uitvoeren
            Statement insertStatement = connection.createStatement();

            String insertQuery = "INSERT INTO beers (Name, BrewerId, CategoryId, Price, Stock, Alcohol) " +
                    "VALUES ('Stella Artois', 1, 1, 2.50, 100, 5.0)";

            int rowsAffected = insertStatement.executeUpdate(insertQuery);

            if (rowsAffected > 0) {
                System.out.println("INSERT SUCCESSFUL: " + rowsAffected + " row(s) inserted.");
            } else {
                System.out.println("INSERT FAILED: No rows inserted.");
            }

            // Sluit de verbinding
            connection.close();

// STAP 04: Een update query uitvoeren
            Statement updateStatement = connection.createStatement();

            String updateQuery = "UPDATE beers SET Stock = 150 WHERE Name = 'Stella Artois'";

            int rowsAffectedUpdate = updateStatement.executeUpdate(updateQuery);

            if (rowsAffectedUpdate > 0) {
                System.out.println("UPDATE SUCCESSFUL: " + rowsAffectedUpdate + " row(s) updated.");
            } else {
                System.out.println("UPDATE FAILED: No rows updated.");
            }

            // STAP 05: Een delete query uitvoeren
            Statement deleteStatement = connection.createStatement();

            String deleteQuery = "DELETE FROM beers WHERE Name = 'Heineken'";

            int rowsAffectedDelete = deleteStatement.executeUpdate(deleteQuery);

            if (rowsAffectedDelete > 0) {
                System.out.println("DELETE SUCCESSFUL: " + rowsAffectedDelete + " row(s) deleted.");
            } else {
                System.out.println("DELETE FAILED: No rows deleted.");
            }

            // Sluit de verbinding
            connection.close();








        }//catch (ClassFoundException) {
         //System.out.println("STEP 1 -> CLASS NOT FOUND EXCEPTION :3 notFoundException.getMessage());

        //}

        catch (SQLException sqlException){
            System.out.println("STEP 2 -> SQL EXCEPTION :" +sqlException.getMessage());
        }
    }
}
