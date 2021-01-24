package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SequenceDAOImpl implements SequenceDAO {
    private static final String GetSequence = "SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
    private static final String UpdateSequence = "UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";
    @Override
    public Sequence getSequence(Sequence sequence) {
        Sequence sequence1 = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetSequence);
            ps.setString(1,sequence.getName());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                sequence1 = new Sequence();
                sequence1.setName(rs.getString(1));
                sequence1.setNextId(rs.getInt(2));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sequence1;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UpdateSequence);
            ps.setInt(1,sequence.getNextId());
            ps.setString(2,sequence.getName());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
