package dao.impl;

import dao.DAOhelper;

import java.sql.*;

public class DAOhelperImpl implements DAOhelper {
    private static DAOhelperImpl impl = new DAOhelperImpl();
    private Connection conn = null;

    public static DAOhelperImpl getInstance(){
        return impl;
    }
    @Override
    public Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/j2ee";
        String username = "root";
        String password = "";
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public void closeConnection(Connection con) {
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement(PreparedStatement stmt) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeResult(ResultSet result) {
        if (result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
