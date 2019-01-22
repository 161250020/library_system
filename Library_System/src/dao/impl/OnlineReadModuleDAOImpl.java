package dao.impl;

import dao.DAOhelper;
import dao.OnlineReadModuleDAO;
import model.OnlineReadModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OnlineReadModuleDAOImpl implements OnlineReadModuleDAO {
    private static DAOhelper helper = DAOhelperImpl.getInstance();

    private OnlineReadModule getFromSingleRs(ResultSet rs) throws SQLException {
        OnlineReadModule onlineReadModule = new OnlineReadModule();
        onlineReadModule.setId(rs.getString("id"));
        onlineReadModule.setDocumentFormat(rs.getString("documentFormat"));
        onlineReadModule.setDocumentReader(rs.getString("documentReader"));

        return onlineReadModule;
    }
    @Override
    public OnlineReadModule findModule(String documentFormat) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        OnlineReadModule onlineReadModule = new OnlineReadModule();
        try {
            stat = conn.prepareStatement("SELECT * FROM onlinereadmodule WHERE documentFormat=?");
            stat.setString(1, documentFormat);
            rs = stat.executeQuery();
            if (rs.next()){
                onlineReadModule = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return onlineReadModule;
    }
}
