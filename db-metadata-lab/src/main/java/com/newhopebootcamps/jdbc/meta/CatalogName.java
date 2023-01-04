package com.newhopebootcamps.jdbc.meta;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.ResultSetMetaData;
        import java.sql.SQLException;
        import java.sql.Statement;

  // val driver = "org.postgresql.Driver"
  // val con_str = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=MY_DB_PASSWD"

public class CatalogName {
    public static void main(String args[]) throws SQLException {
        //Registering the Driver
       //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/world";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "MY_DB_PASSWD");
        System.out.println("Connection established......");
        //Creating the Statement
        Statement stmt = con.createStatement();
        //Query to retrieve records
        String query = "Select * from MyPlayers";
        //Executing the query
        ResultSet rs = stmt.executeQuery(query);
        //retrieving the ResultSetMetaData object
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        //Retrieving the catalog name
        String catalogName = resultSetMetaData.getCatalogName(4);
        resultSetMetaData.getCatalogName(3);
        System.out.println("Name of the catalog of the table contaning the specified column: "+
                catalogName);
    }
}