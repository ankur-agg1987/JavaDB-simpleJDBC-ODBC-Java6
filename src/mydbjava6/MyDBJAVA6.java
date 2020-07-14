package mydatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDBJAVA6 {
static Statement st = null;
static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            String database = "mydb.mdb";
            
            // using Java 1.6 and later version
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=" + database + ";READONLY=true";
            
            // step 1: Register the Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            
            // setp 2: connect to database
            Connection con = DriverManager.getConnection(url);
            
            // step 3: create a statement object over connection con object
            // we can create a simple Statement, PreparedStatement, CallableStatement
            st = con.createStatement();
            
            // step 4: execute the Query over statement object using either execute, executeQuery, executeUpdate, executeBatch
            rs = st.executeQuery("select * from login");
            
            // step 5: iterate over the Resultset object and access the data from row wise using getxxx() funcation
            
            while (rs.next()) {
                String a = rs.getString(1);
                System.out.println(a);
                
            }

        } catch (Exception ee) {
            System.out.println(ee);
        }
        //step 6: close all the objects
        
    }
}
