package dao.impl;

import dao.DAOhelper;
import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public class UserDAOImpl implements UserDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private User getFromSingleRs(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setType(rs.getString("type"));
        user.setMaxNum(rs.getInt("MaxNum"));
        user.setMaxPeriod(rs.getInt("MaxPeriod"));
        user.setMoney(rs.getDouble("money"));
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = conn.prepareStatement("SELECT * FROM user WHERE name=?");
            stat.setString(1, username);
            rs = stat.executeQuery();
            if (rs.next()){
                user = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return user;
    }

    @Override
    public String addUser(User user) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "INSERT INTO user(id,name,password,type,MaxNum,MaxPeriod,money)VALUES (?,?,?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,user.getId());
            stat.setString(2,user.getName());
            stat.setString(3,user.getPassword());
            stat.setString(4,user.getType());
            stat.setInt(5,user.getMaxNum());
            stat.setInt(6,user.getMaxPeriod());
            stat.setDouble(7,user.getMoney());
            stat.executeUpdate();
            return "成功新增新用户"+user.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "新增新用户失败";
    }

    @Override
    public String deleteUser(User user) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "DELETE FROM user WHERE id = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,user.getId());
            stat.executeUpdate();
            return "成功删除用户"+user.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "删除用户失败";
    }

    @Override
    public String updateUser(User user) {
        try{
        deleteUser(user);
        addUser(user);
        return "更新用户信息成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "更新用户信息失败";
    }

    @Override
    public ArrayList<User> findAllUser() {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<User>();
        try{
            String sql = "SELECT * FROM user";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                User user = getFromSingleRs(rs);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return users;
    }
}
