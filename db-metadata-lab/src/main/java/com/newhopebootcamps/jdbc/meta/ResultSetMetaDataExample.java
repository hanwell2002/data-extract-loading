package com.newhopebootcamps.jdbc.meta;

import java.sql.*;

public class ResultSetMetaDataExample {
    static {
        //Registering The Driver Class
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // Class.forName("com.mysql.jdbc.Driver"); // Loading class `com.mysql.jdbc.Driver'. This is deprecated.
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable To Load The Driver class");
        }
    }

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Database Credentials
            // String URL = "jdbc:oracle:thin:@localhost:1521:orclpdb";
            // String URL = "jdbc:mysql://localhost/world";
            String URL = "jdbc:postgresql://localhost:5432/postgres";
            //String URL2 = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Admin@777";
            String username = "postgres";
            String password = "Admin@777";
            //Creating The Connection Object
            con = DriverManager.getConnection(URL, username, password);
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
                System.out.println("#" + i + " -> " + colName + " -> TypeID: " + colType + ": " + colTypeName);
            }
        } catch (SQLException e) {
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

