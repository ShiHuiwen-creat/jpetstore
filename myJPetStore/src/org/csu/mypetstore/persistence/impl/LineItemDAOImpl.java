package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.LineItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {
    private static final String GetLineItemsByOrderId = "SELECT ORDERID,LINENUM AS lineNumber,ITEMID,QUANTITY,UNITPRICE FROM LINEITEM WHERE ORDERID = ?";
    private static final String InsertLineItem = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?, ?)";
    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        List<LineItem> lineItemList = new ArrayList<LineItem>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetLineItemsByOrderId);
            ps.setInt(1,orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(rs.getInt(1));
                lineItem.setLineNumber(rs.getInt(2));
                lineItem.setItemId(rs.getString(3));
                lineItem.setQuantity(rs.getInt(4));
                lineItem.setUnitPrice(rs.getBigDecimal(5));
                lineItemList.add(lineItem);
            }
            DBUtil.closeAll(conn,ps,rs);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertLineItem);
            ps.setInt(1,lineItem.getOrderId());
            ps.setInt(2,lineItem.getLineNumber());
            ps.setString(3,lineItem.getItemId());
            ps.setInt(4,lineItem.getQuantity());
            ps.setBigDecimal(5,lineItem.getUnitPrice());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
