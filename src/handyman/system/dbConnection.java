/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handyman.system;

/**
 *
 * @author JUDITH
 */
import java.sql.*;
import java.io.*; 


public class dbConnection {
    
    Connection con;
    
public void getConnection(){
    
    try{
    //Step 1: Load the mysql driver found in the .jar file    
    Class.forName("com.mysql.jdbc.Driver");
    
    //Step 2: Establish connection
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/HandyMan System", "root", "");
            
    //Check if the connection is successful
    if (con != null) {
        System.out.println("Connection Successful");
    }else  {
            System.out.println("An unknown error has occured");
            System.out.println("An error has occured");
            }       
    
    //Step 3: Create a statement for executing sql statements
    //Here HandyMan System is  database name, root is username and no password
    
    Statement stmt = con.createStatement();
    
    //Step 4: Execute the statement logins is the table name
    ResultSet rs = stmt.executeQuery("Select * from logins");
    
    //Step 5: Process resulltset
    while (rs.next()) {
        System.out.println("Username is " + rs.getString("Username"));
    }
   
    //Step 6: Insert a new row to logins table and process the result
    int result = stmt.executeUpdate("insert into logins(userName,Password,Role) values('jn1982','pass1234','Manager')");
    
    if (result > 0)
				System.out.println("successfully inserted");

			else
				System.out.println(
					"unsucessful insertion ");
    // Output 
    /*Connection Successful
    Username is jn1982
    successfully inserted
    BUILD SUCCESSFUL (total time: 0 seconds)*/
    
    //Step 7: Delete a row from the table
     String sql = "DELETE FROM logins " + "WHERE uSerName = jn1982";
        int executeUpdate = stmt.executeUpdate(sql);
         while(rs.next())
    
    
    //Step 8: Close the connection
    con.close();    
    }   

    catch(Exception e) {
    System.out.println("An error has occured2");
    System.out.println(e);
    }
}
}

