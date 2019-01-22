package dao.impl;

import dao.BookDAO;
import dao.DAOhelper;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private Book getFromSingleRs(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getString("id"));
        book.setName(rs.getString("name"));
        book.setType(rs.getString("type"));
        book.setAuthor(rs.getString("author"));
        book.setPublishCompany(rs.getString("publishCompany"));
        book.setState(rs.getString("state"));
        book.setFineMoneyPerDay(rs.getDouble("fineMoneyPerDay"));
        return book;
    }

    @Override
    public Book findBookByBookId(String id) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        Book book = new Book();
        try {
            stat = conn.prepareStatement("SELECT * FROM book WHERE id=?");
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

    @Override
    public String addBook(Book book) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "INSERT INTO book(id,name,publishCompany,type,author,state,fineMoneyPerDay)VALUES (?,?,?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,book.getId());
            stat.setString(2,book.getName());
            stat.setString(3,book.getPublishCompany());
            stat.setString(4,book.getType());
            stat.setString(5,book.getAuthor());
            stat.setString(6,book.getState());
            stat.setDouble(7,book.getFineMoneyPerDay());
            stat.executeUpdate();
            return "成功新增新书籍"+book.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "新增书籍失败";
    }

    @Override
    public String deleteBook(Book book) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;

        try{
            String sql = "DELETE FROM book WHERE id = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,book.getId());
            stat.executeUpdate();
            return "成功删除书籍"+book.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);

        }
        return "删除书籍失败";
    }

    @Override
    public String updateBook(Book book) {
        try{
            deleteBook(book);
            addBook(book);
            return "更新书籍信息成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "更新书籍失败";
    }

    @Override
    public ArrayList<Book> findAllBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM book";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                Book book = getFromSingleRs(rs);

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
}
