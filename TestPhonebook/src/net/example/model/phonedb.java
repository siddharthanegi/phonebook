package net.example.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class phonedb{
 
 public Connection getConnection() {
  Connection con = null;
  try {
   //load the HSQLDB Database Driver. 
   //This gets loaded from the hsqldb-xxx.jar
   Class.forName("org.hsqldb.jdbcDriver");
  } catch (ClassNotFoundException cnfe) {
   System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
   cnfe.printStackTrace();
  }
   
  try {
   //connect to the database. 
   con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", ""); 
  }
  catch (SQLException e) {
   System.out.println("ERROR: failed to connect to the databse");
   e.printStackTrace();
  }
   
  return con;
 }
  
  
 public void executeInsertQuery(Connection con, List<String> params) {
  PreparedStatement ps = null;
 
  try {
   ps = con.prepareStatement("INSERT INTO PHONEBOOK VALUES('"+params.get(0)+"','"+params.get(1)+"','"+params.get(2)+"')");
   
//    System.out.print(params.get(1));
   ps.executeUpdate(); // executes the insert query
    
  }
  catch (Exception e) {
   System.out.println("ERROR executing query: ");
   e.printStackTrace();
  }
  finally {
   try {
    //close the statement
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
 }
  
  
 public List<String> executeSelectQuery(Connection con, List<String> params) {
  PreparedStatement ps = null;
   List<String> result= new ArrayList<String>();
  try {
   ps = con.prepareStatement("SELECT * FROM PHONEBOOK WHERE NAME='"+params.get(0)+"'");
   ResultSet rs = ps.executeQuery(); // read from database
   while(rs.next()){
    
    result.add(rs.getString("NAME"));
    result.add(rs.getString("ADDRESS"));
    result.add(rs.getString("PHONE"));
    
    
   }
    
  }
  catch (Exception e) {
   System.out.println("ERROR executing query: ");
   e.printStackTrace();
  }
  finally{
   try {
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
 return result;
 }
 
 
 
 
}