package org.csu.mypetstore.persistence;

import java.sql.*;

public class DBUtil {
    private static String driverString = "com.mysql.jdbc.Driver";
    private static String connectionStirng = "jdbc:mysql://localhost:3306/jpetstore";
    private static String username = "root";
    private static String password = "WZR20000910";
    public static Connection getConnection() throws Exception{
        Connection conn = null;
        try {
            Class.forName(driverString);
            conn = DriverManager.getConnection(connectionStirng,username,password);
        }catch (Exception e){
            throw e;
        }
        return conn;
    }
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
