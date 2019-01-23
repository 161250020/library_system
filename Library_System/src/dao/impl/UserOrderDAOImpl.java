package dao.impl;

import dao.DAOhelper;
import dao.UserOrderDAO;
import model.User;
import model.UserOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserOrderDAOImpl implements UserOrderDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private UserOrder getFromSingleRs(ResultSet rs) throws SQLException {
        UserOrder u = new UserOrder();
        u.setId(rs.getString("id"));
        u.setUserId(rs.getString("userId"));
        u.setBookId(rs.getString("bookId"));
        u.setBorrowTime(rs.getDate("borrowTime"));
        u.setReturnTime(rs.getDate("returnTime"));
        u.setFineDay(rs.getInt("fineDay"));
        u.setAlreadyPay(rs.getInt("alreadyPay"));
        return u;
    }
    @Override
    public String addUserOrder(UserOrder userOrder) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "INSERT INTO userorder(id,userId,bookId,borrowTime,returnTime,fineDay,alreadyPay)VALUES (?,?,?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,userOrder.getId());
            stat.setString(2,userOrder.getUserId());
            stat.setString(3,userOrder.getBookId());
            stat.setDate(4,userOrder.getBorrowTime());
            stat.setDate(5,userOrder.getReturnTime());
            stat.setInt(6,userOrder.getFineDay());
            stat.setInt(7,userOrder.getAlreadyPay());
            stat.executeUpdate();
            return "成功新增用户借阅记录"+userOrder.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "新增新用户借阅记录失败";
    }

    @Override
    public ArrayList<UserOrder> getAllUserOrder() {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<UserOrder> records = new ArrayList<UserOrder>();
        try{
            String sql = "SELECT * FROM userorder";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                UserOrder order = getFromSingleRs(rs);

                records.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return records;
    }

    @Override
    public ArrayList<UserOrder> getAllUserOrder(User user) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<UserOrder> records = new ArrayList<UserOrder>();
        try{
            String sql = "SELECT * FROM userorder WHERE userId=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,user.getId());
            rs = stat.executeQuery();
            while (rs.next()){
                UserOrder order = getFromSingleRs(rs);

                records.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return records;
    }

    @Override
    public UserOrder getUserOrder(String id) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        UserOrder userOrder = new UserOrder();
        try{
            String sql = "SELECT * FROM userorder WHERE id=?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,id);
            rs = stat.executeQuery();
            if (rs.next()){
                userOrder = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return userOrder;
    }

    @Override
    public String updateUserOrder(UserOrder u) {
        try{
            deleteUserOrder(u);
            addUserOrder(u);
            return "更新借阅记录成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "更新借阅记录失败";
    }

    @Override
    public String deleteUserOrder(UserOrder u) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "DELETE FROM userorder WHERE id = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,u.getId());
            stat.executeUpdate();
            return "成功删除借阅记录"+u.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "删除借阅记录失败";
    }
}
