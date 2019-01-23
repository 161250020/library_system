package dao.impl;

import dao.DAOhelper;
import dao.ElectronicBooksDAO;
import model.ElectronicBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ElectronicBooksDAOImpl implements ElectronicBooksDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private ElectronicBooks getFromSingleRs(ResultSet rs) throws SQLException {
        ElectronicBooks e = new ElectronicBooks();
        e.setId(rs.getString("id"));
        e.setName(rs.getString("name"));
        e.setType(rs.getString("type"));
        e.setAuthor(rs.getString("author"));
        e.setPublishCompany(rs.getString("publishCompany"));
        e.setDocumentFormat(rs.getString("documentFormat"));
        e.setFilepath(rs.getString("filepath"));
        return e;
    }
    @Override
    public ArrayList<ElectronicBooks> getAllElectronicBooks() {
        ArrayList<ElectronicBooks> books = new ArrayList<ElectronicBooks>();
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM electronicbooks";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                ElectronicBooks book = getFromSingleRs(rs);

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return books;
    }

    @Override
    public String updateElectronicBooks(ElectronicBooks e) {
        try{
            deleteElectronicBooks(e);
            addElectronicBooks(e);
            return "更新电子书信息成功";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "更新电子书失败";
    }

    @Override
    public String addElectronicBooks(ElectronicBooks e) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "INSERT INTO electronicbooks(id,name,publishCompany,type,author,documentFormat,filepath)VALUES (?,?,?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,e.getId());
            stat.setString(2,e.getName());
            stat.setString(3,e.getPublishCompany());
            stat.setString(4,e.getType());
            stat.setString(5,e.getAuthor());
            stat.setString(6,e.getDocumentFormat());
            stat.setString(7,e.getFilepath());
            stat.executeUpdate();
            return "成功新增电子书"+e.getId();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "新增电子书失败";
    }

    @Override
    public String deleteElectronicBooks(ElectronicBooks e) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "DELETE FROM electronicbooks WHERE id = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,e.getId());
            stat.executeUpdate();
            return "成功删除电子书"+e.getId();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "删除电子书失败";
    }

    @Override
    public ElectronicBooks findElectronicBooks(String id) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ElectronicBooks book = new ElectronicBooks();
        try {
            stat = conn.prepareStatement("SELECT * FROM electronicbooks WHERE id=?");
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                book = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return book;
    }
}
