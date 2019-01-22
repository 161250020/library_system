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
        return "新增书籍失败";
    }

    @Override
    public String deleteBook(Book book) {
        return "删除书籍失败";
    }

    @Override
    public String updateBook(Book book) {

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
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setAuthor(rs.getString("author"));
                book.setPublishCompany(rs.getString("publishCompany"));
                book.setState(rs.getString("state"));

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
