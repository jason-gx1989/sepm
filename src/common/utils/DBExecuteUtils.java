package common.utils;

import common.configration.DBConfig;
import entity.ShiftManager;
import entity.Staff;

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


/**
 * QUERY
 * @param sql the sql executed
 * @return the ResultSet of query Operation
 */
public static Staff queryStaff(String sql){

    Staff result = new Staff();
    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            result.setId(resultSet.getInt("id"));
            result.setFullName(resultSet.getString("fullName"));
            result.setPassword(resultSet.getString("password"));
            result.setMobileNumber(resultSet.getString("mobileNumber"));
            result.setIsPasswordUpdated(resultSet.getInt("isPasswordUpdated"));
            result.setEmail(resultSet.getString("email"));
            result.setCreateTIme(resultSet.getDate("createTime"));
            result.setWorkHourLimit(resultSet.getDouble("workHourLimit"));
            result.setPreferredName(resultSet.getString("preferredName"));
            result.setHomeAddress(resultSet.getString("homeAddress"));
        }
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
public static ShiftManager queryShiftManager(String sql){

    ShiftManager result = new ShiftManager();
    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            result.setId(resultSet.getInt("id"));
            result.setFullName(resultSet.getString("fullName"));
            result.setPassword(resultSet.getString("password"));
            result.setIsPasswordUpdated(resultSet.getInt("isPasswordUpdated"));
            result.setMobileNumber(resultSet.getString("mobileNumber"));
            result.setEmail(resultSet.getString("email"));
            result.setCreateTIme(resultSet.getDate("createTime"));
        }
        conn.close();
        ps.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return result;
}

/**
 * DELETE
 * @param sql the sql executed
 * @return the ResultSet of query Operation
 */
public static void delete(String sql){

    
    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate(sql);
     
        conn.close();
        ps.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
