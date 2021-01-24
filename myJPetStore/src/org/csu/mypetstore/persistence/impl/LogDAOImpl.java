package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.LogDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LogDAOImpl implements LogDAO {

    private static final String InsertBrowseLog = "insert into browseLog (userId,browseItemId,browseTime) values (?,?,?)";

    private static final String InsertAddLog = "insert into addLog (userId,addItemId,addTime) values (?,?,?)";

    private static final String GetBrowseList = "select browseItemId,browseTime from browseLog where userId = ?";

    private static final String GetAddList = "select addItemId,addTime from addLog where userId = ?";


    @Override
    public void insertBrowseLog(Account account, String itemid) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertBrowseLog);
            ps.setString(1,account.getUsername());
            ps.setString(2,itemid);
            Date date = new Date(System.currentTimeMillis());
            ps.setDate(3,date);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertAddLog(Account account, String itemid) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertAddLog);
            ps.setString(1,account.getUsername());
            ps.setString(2,itemid);
            Date date = new Date(System.currentTimeMillis());
            ps.setDate(3,date);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Log> getBrowseLogListByUsername(String username) {
        List<Log> browseLogList = new ArrayList<Log>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetBrowseList);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Log log = new Log();
                log.setItemId(rs.getString(1));
                log.setLogDate(rs.getDate(2));
                browseLogList.add(log);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return browseLogList;
    }

    @Override
    public List<Log> getAddListByUsername(String username) {
        List<Log> addList = new ArrayList<Log>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetAddList);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Log log = new Log();
                log.setItemId(rs.getString(1));
                log.setLogDate(rs.getDate(2));
                addList.add(log);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return addList;
    }
}
