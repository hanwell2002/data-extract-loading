package com.newhopebootcamps.jdbc.meta;

import java.sql.*;

public class ResultSetMetaDataExampleOracle {
/*
 static {
        //Registering The Driver Class, can be ignored for higher version JVM.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable To Load The Driver class");
        }
    }
*/

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Database Credentials
            String URL = "jdbc:oracle:thin:@localhost:1521:orclpdb";
            String username = "sparkmso";
            String password = "MY_DB_PASSWD";

            //Creating The Connection Object
            con = DriverManager.getConnection(URL, username, password);
            System.out.println(">> Connected to Oracle pluggable Database!");
            //Creating The Statement Object
            stmt = con.createStatement();
            //Constructing The SQL Query
            String sql = "SELECT * FROM Country";
            //Executing The Query
            rs = stmt.executeQuery(sql);
            //getting ResultSetMetaData object
            ResultSetMetaData rsmd = rs.getMetaData();
            //getting number of columns in 'rs'
            int colCount = rsmd.getColumnCount();
            System.out.println("Number Of Columns : " + colCount);
            System.out.println("column Details :");
            for (int i = 1; i <= colCount; i++) {
                //getting column name of index 'i'
                String colName = rsmd.getColumnName(i);
                //getting column's data type of index 'i'
                int colType = rsmd.getColumnType(i);
                //getting column's data TypeName of index 'i'
                String colTypeName = rsmd.getColumnTypeName(i);
                System.out.println( "#" + i + " -> " + colName + " -> TypeID: " + colType+ ": " + colTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Closing The DB Resources
            //Closing the ResultSet object
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Closing the Statement object
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Closing the Connection object
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 >> Connected to Oracle pluggable Database!
 Number Of Columns : 15
 column Details :
 #1 -> CODE -> TypeID: 1: CHAR
 #2 -> NAME -> TypeID: 12: VARCHAR2
 #3 -> CONTINENT -> TypeID: 12: VARCHAR2
 #4 -> REGION -> TypeID: 12: VARCHAR2
 #5 -> SURFACEAREA -> TypeID: 2: NUMBER
 #6 -> INDEPYEAR -> TypeID: 2: NUMBER
 #7 -> POPULATION -> TypeID: 2: NUMBER
 #8 -> LIFEEXPECTANCY -> TypeID: 2: NUMBER
 #9 -> GNP -> TypeID: 2: NUMBER
 #10 -> GNPOLD -> TypeID: 2: NUMBER
 #11 -> LOCALNAME -> TypeID: 12: VARCHAR2
 #12 -> GOVERNMENTFORM -> TypeID: 12: VARCHAR2
 #13 -> HEADOFSTATE -> TypeID: 12: VARCHAR2
 #14 -> CAPITAL -> TypeID: 2: NUMBER
 #15 -> CODE2 -> TypeID: 1: CHAR
 */