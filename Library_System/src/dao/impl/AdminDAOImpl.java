package dao.impl;

import dao.AdminDAO;
import dao.DAOhelper;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();
    private Admin getFromSingleRs(ResultSet rs) throws SQLException {
        Admin adminer = new Admin();
        adminer.setId(rs.getString("id"));
        adminer.setName(rs.getString("name"));
        adminer.setPassword(rs.getString("password"));

        return adminer;
    }
    @Override
    public Admin findAdminByName(String name) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        Admin adminer = null;
        try {
            stat = conn.prepareStatement("SELECT * FROM admin WHERE name=?");
            stat.setString(1, name);
            rs = stat.executeQuery();
            if (rs.next()){
                adminer = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return adminer;
    }
}
