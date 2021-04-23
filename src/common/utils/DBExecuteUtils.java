package common.utils;

import common.configration.DBConfig;

import java.sql.*;

public class DBExecuteUtils {

    /**
     *  ADD DELETE UPDATE
     * @param sql the sql executed
     * @return  Rows affected by update Operation
     */
    public static int update(String sql){

        int result = -1;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(sql);
            result = ps.executeUpdate(sql);
            conn.close();
            ps.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * QUERY
     * @param sql the sql executed
     * @return the ResultSet of query Operation
     */
    public static ResultSet query(String sql){

        ResultSet result = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            conn.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
