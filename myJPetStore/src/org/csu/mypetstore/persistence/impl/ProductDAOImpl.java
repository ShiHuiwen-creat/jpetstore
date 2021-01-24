package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final String getProductListByCategoryString = "select productid,name,descn as description,category as categoryid from product where category = ?";
    private static final String getProductString = "select productid,name,descn as description,category as categoryid from product where productId = ?";
    private static final String searchProductListString = "select productId,name,descn as description,category as categoryId from product where name like ?";
    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> products = new ArrayList<Product>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(getProductListByCategoryString);
            ps.setString(1,categoryId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategoryId(rs.getString(4));
                products.add(product);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = null;
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(getProductString);
            ps.setString(1,productId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                product = new Product();
                product.setProductId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategoryId(rs.getString(4));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> productList = new ArrayList<Product>();
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(searchProductListString);
            ps.setString(1,keywords);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategoryId(rs.getString(4));
                productList.add(product);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
