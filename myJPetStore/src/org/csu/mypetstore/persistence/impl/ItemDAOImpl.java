package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.ItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDAOImpl implements ItemDAO {
    private static final String getItemListByProductString = "SELECT I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId,\n" +
            "      I.PRODUCTID ,NAME ,DESCN ,CATEGORY,\n" +
            "      STATUS, ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5\n" +
            "    FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
    private static final String getItemString = "select I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID,\n" +
            "      name , DESCN, CATEGORY, STATUS, \n" +
            "      ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5,\n" +
            "      v.qty AS quantity from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.ITEMID = V.ITEMID and I.ITEMID = ?";
    private static final String getInventoryQuantityString = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";
    private static final String updateInventoryQuantityString = "UPDATE INVENTORY SET QTY = QTY - ? WHERE ITEMID = ?";

    @Override
    public void updateInventoryQuantity(Map<String, String> param) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(updateInventoryQuantityString);
            String ItemId = param.keySet().iterator().next();
            Integer increment = Integer.parseInt(param.get(ItemId));
            ps.setInt(1,increment.intValue());
            ps.setString(2,ItemId);
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getInventoryQuantity(String itemId) {
        int result = -1;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(getInventoryQuantityString);
            ps.setString(1,itemId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                result = rs.getInt(1);
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> itemList = new ArrayList<Item>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(getItemListByProductString);
            ps.setString(1,productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Item item = new Item();
                item.setItemId(rs.getString(1));
                item.setListPrice(rs.getBigDecimal(2));
                item.setUnitCost(rs.getBigDecimal(3));
                item.setSupplierId(rs.getInt(4));
                Product product = new Product();
                product.setProductId(rs.getString(5));
                product.setName(rs.getString(6));
                product.setDescription(rs.getString(7));
                product.setCategoryId(rs.getString(8));
                item.setProduct(product);
                item.setStatus(rs.getString(9));
                item.setAttribute1(rs.getString(10));
                item.setAttribute2(rs.getString(11));
                item.setAttribute3(rs.getString(12));
                item.setAttribute4(rs.getString(13));
                item.setAttribute5(rs.getString(14));
                itemList.add(item);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Item item = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(getItemString);
            ps.setString(1,itemId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                item = new Item();
                item.setItemId(rs.getString(1));
                item.setListPrice(rs.getBigDecimal(2));
                item.setUnitCost(rs.getBigDecimal(3));
                item.setSupplierId(rs.getInt(4));
                Product product = new Product();
                product.setProductId(rs.getString(5));
                product.setName(rs.getString(6));
                product.setDescription(rs.getString(7));
                product.setCategoryId(rs.getString(8));
                item.setProduct(product);
                item.setStatus(rs.getString(9));
                item.setAttribute1(rs.getString(10));
                item.setAttribute2(rs.getString(11));
                item.setAttribute3(rs.getString(12));
                item.setAttribute4(rs.getString(13));
                item.setAttribute5(rs.getString(14));
                item.setQuantity(rs.getInt(15));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
