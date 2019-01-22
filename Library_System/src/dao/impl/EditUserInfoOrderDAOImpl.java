package dao.impl;

import dao.DAOhelper;
import dao.EditUserInfoOrderDAO;
import model.EditUserInfoOrder;
import model.ElectronicBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditUserInfoOrderDAOImpl implements EditUserInfoOrderDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private EditUserInfoOrder getFromSingleRs(ResultSet rs) throws SQLException {
        EditUserInfoOrder e = new EditUserInfoOrder();
        e.setId(rs.getString("id"));
        e.setUserId(rs.getString("userId"));
        e.setChangeTime(rs.getDate("changeTime"));
        e.setPrePass(rs.getString("prePass"));
        e.setLaterPass(rs.getString("laterPass"));

        return e;
    }
    @Override
    public String addEditUserInfoOrder(EditUserInfoOrder editUserInfoOrder) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "INSERT INTO edituserinfoorder(id,userId,changeTime,prePass,laterPass)VALUES (?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,editUserInfoOrder.getId());
            stat.setString(2,editUserInfoOrder.getUserId());
            stat.setDate(3,editUserInfoOrder.getChangeTime());
            stat.setString(4,editUserInfoOrder.getPrePass());
            stat.setString(5,editUserInfoOrder.getLaterPass());

            stat.executeUpdate();
            return "成功增加修改用户信息记录"+editUserInfoOrder.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "修改用户信息失败";
    }

    @Override
    public ArrayList<EditUserInfoOrder> getAllEditUserInfoOrder() {
        ArrayList<EditUserInfoOrder> list = new ArrayList<EditUserInfoOrder>();
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM edituserinfoorder";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                EditUserInfoOrder editUserInfoOrder = getFromSingleRs(rs);

                list.add(editUserInfoOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return list;
    }
}
