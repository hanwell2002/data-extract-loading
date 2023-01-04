package com.newhopebootcamps.jdbc.meta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import com.newhopebootcamps.jdbc.util.DatabaseUtil;

public class DatabaseTableColumnDataTypePOC {
    public static void main(String args[]){
        Connection conn = null;
        Statement statement = null;

        String query0 = "select code,name from COUNTRY";
        String query = "select * from COUNTRY";

        try{
            //get connection
            conn = DatabaseUtil.getConnection();

            //create statement
            statement = conn.createStatement();

            //execute query
            ResultSet rs = statement.executeQuery(query);

            //get ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            //Result set meta data
            System.out.println("Total cols: "
                    + rsmd.getColumnCount());
            System.out.println("Column name: "
                    + rsmd.getColumnName(1));
            System.out.println("Column type: "
                    + rsmd.getColumnTypeName(1));

            System.out.println("--------------------------");
            int colCount = rsmd.getColumnCount();
            System.out.println("# Number Of Columns : " + colCount);
            System.out.println(">> column Details :");
            for (int i = 1; i <= colCount; i++) {
                //getting column name of index 'i'
                String colName = rsmd.getColumnName(i);
                //getting column's data type of index 'i'
                int colType = rsmd.getColumnType(i);
                //getting column's data TypeName of index 'i'
                String colTypeName = rsmd.getColumnTypeName(i);
                System.out.println( "#" + i + " -> " + colName + " -> TypeID: " + colType+ ": " + colTypeName);
            }

            //close connection
            statement.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

