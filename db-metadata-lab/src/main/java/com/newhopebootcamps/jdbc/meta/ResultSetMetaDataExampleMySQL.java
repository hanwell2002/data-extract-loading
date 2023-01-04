package com.newhopebootcamps.jdbc.meta;

import java.sql.*;

public class ResultSetMetaDataExampleMySQL {
/*    static {
        //Registering The Driver Class
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // Class.forName("com.mysql.jdbc.Driver"); // Loading class `com.mysql.jdbc.Driver'. This is deprecated.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.postgresql.Driver");
            //val con_str = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Admin@777"
        } catch (ClassNotFoundException e) {
            System.out.println("Unable To Load The Driver class");
        }
    }*/

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Database Credentials
            // String URL = "jdbc:oracle:thin:@localhost:1521:XE";
            String URL = "jdbc:mysql://localhost/world";
            // String URL = "jdbc:postgresql://localhost:5432/postgres";
            String username = "root";
            String password = "Admin$777";

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
 * [info] running com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 * Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of GNPOld is of type FLOAT
 * column Details :
 * Code is of type CHAR
 * Name is of type CHAR
 * Continent is of type CHAR
 * Region is of type CHAR
 * SurfaceArea is of type FLOAT
 * GNP is of type FLOAT
 * GNPOld is of type FLOAT
 * LocalName is of type CHAR
 * GovernmentForm is of type CHAR
 * HeadOfState is of type CHAR
 * Capital is of type INT
 * Code2 is of type CHAR
 * <p>
 * PS G:\bootcamps\data-extract-loading\db-metadata-lab> sbt run
 * [info] welcome to sbt 1.8.0 (Oracle Corporation Java 11.0.14)
 * [info] loading global plugins from C:\Users\Administrator\.sbt\1.0\plugins
 * [info] loading project definition from G:\bootcamps\data-extract-loading\db-metadata-lab\project
 * [info] loading settings for project root from build.sbt ...
 * [info] set current project to  (in build file:/G:/bootcamps/data-extract-loading/db-metadata-lab/)
 * [info] compiling 3 Java sources to G:\bootcamps\data-extract-loading\db-metadata-lab\target\scala-2.12\classes ...
 * <p>
 * Multiple main classes detected. Select one to run:
 * [1] Main
 * [2] com.newhopebootcamps.jdbc.meta.CatalogName
 * [3] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 * [4] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 * [5] com.newhopebootcamps.jdbc.meta.ResultSetMetaData_getColumnType
 * <p>
 * Enter number: 4
 * [info] running com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 * Number Of Columns : 15
 * column Details :
 * LifeExpectancy is of type FLOAT
 * GNP is of type FLOAT
 * GNPOld is of type FLOAT
 * LocalName is of type CHAR
 * GovernmentForm is of type CHAR
 * HeadOfState is of type CHAR
 * Capital is of type INT
 * Code2 is of type CHAR

 * PS G:\bootcamps\data-extract-loading\db-metadata-lab> sbt run
 * [info] welcome to sbt 1.8.0 (Oracle Corporation Java 11.0.14)
 * [info] loading global plugins from C:\Users\Administrator\.sbt\1.0\plugins
 * [info] loading project definition from G:\bootcamps\data-extract-loading\db-metadata-lab\project
 * [info] loading settings for project root from build.sbt ...
 * [info] set current project to  (in build file:/G:/bootcamps/data-extract-loading/db-metadata-lab/)
 * [info] compiling 1 Java source to G:\bootcamps\data-extract-loading\db-metadata-lab\target\scala-2.12\classes ...
 * <p>
 * Multiple main classes detected. Select one to run:
 * [1] Main
 * [2] com.newhopebootcamps.jdbc.meta.CatalogName
 * [3] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 * [4] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 * [5] com.newhopebootcamps.jdbc.meta.ResultSetMetaData_getColumnType
 * <p>
 * Enter number:
 * Invalid number: '
 * <p>
 * Multiple main classes detected. Select one to run:
 * [1] Main
 * [2] com.newhopebootcamps.jdbc.meta.CatalogName
 * [3] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 * [4] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 * [5] com.newhopebootcamps.jdbc.meta.ResultSetMetaData_getColumnType
 * <p>
 * Enter number: O
 * Invalid number: 'O'
 * <p>
 [info] loading global plugins from C:\Users\Administrator\.sbt\1.0\plugins
 [info] loading project definition from G:\bootcamps\data-extract-loading\db-metadata-lab\project
 [info] loading settings for project root from build.sbt ...
 [info] set current project to  (in build file:/G:/bootcamps/data-extract-loading/db-metadata-lab/)
 [info] compiling 5 Java sources to G:\bootcamps\data-extract-loading\db-metadata-lab\target\scala-2.12\classes ...

 Multiple main classes detected. Select one to run:
 [1] Main
 [2] com.newhopebootcamps.jdbc.meta.CatalogName
 [3] com.newhopebootcamps.jdbc.meta.DatabaseTableColumnDataTypePOC
 [4] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 [5] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 [6] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleOracle

 Enter number: 6
 [info] running com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleOracle
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

 PS G:\bootcamps\data-extract-loading\db-metadata-lab> sbt run
 [info] welcome to sbt 1.8.0 (Oracle Corporation Java 11.0.14)
 [3] com.newhopebootcamps.jdbc.meta.DatabaseTableColumnDataTypePOC
 [4] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExample
 [5] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 [6] com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleOracle

 Enter number:

 Enter number: 5
 [info] running com.newhopebootcamps.jdbc.meta.ResultSetMetaDataExampleMySQL
 Number Of Columns : 15
 column Details :
 #1 -> Code -> TypeID: 1: CHAR
 #2 -> Name -> TypeID: 1: CHAR
 #3 -> Continent -> TypeID: 1: CHAR
 #4 -> Region -> TypeID: 1: CHAR
 #5 -> SurfaceArea -> TypeID: 7: FLOAT
 #6 -> IndepYear -> TypeID: 5: SMALLINT
 #7 -> Population -> TypeID: 4: INT
 #8 -> LifeExpectancy -> TypeID: 7: FLOAT
 #9 -> GNP -> TypeID: 7: FLOAT
 #10 -> GNPOld -> TypeID: 7: FLOAT
 #11 -> LocalName -> TypeID: 1: CHAR
 #12 -> GovernmentForm -> TypeID: 1: CHAR
 #13 -> HeadOfState -> TypeID: 1: CHAR
 #14 -> Capital -> TypeID: 4: INT
 #15 -> Code2 -> TypeID: 1: CHAR


 Postgres:

 Number Of Columns : 15
 column Details :
 #1 -> code -> TypeID: 1: bpchar
 #2 -> name -> TypeID: 12: varchar
 #3 -> continent -> TypeID: 12: varchar
 #4 -> region -> TypeID: 12: varchar
 #5 -> surfacearea -> TypeID: 7: float4
 #6 -> indepyear -> TypeID: 5: int2
 #7 -> population -> TypeID: 4: int4
 #8 -> lifeexpectancy -> TypeID: 7: float4
 #9 -> gnp -> TypeID: 2: numeric
 #10 -> gnpold -> TypeID: 2: numeric
 #11 -> localname -> TypeID: 12: varchar
 #12 -> governmentform -> TypeID: 12: varchar
 #13 -> headofstate -> TypeID: 12: varchar
 #14 -> capital -> TypeID: 4: int4
 #15 -> code2 -> TypeID: 1: bpchar
 --------------
*/