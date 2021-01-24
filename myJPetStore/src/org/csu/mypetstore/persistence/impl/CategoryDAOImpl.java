package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static final String Get_categoryList = "select catId as categoryId,name,descn as description from category";
    private static final String Get_category = "select catId as categoryId,name,descn as description from category where catId = ?";
    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<Category>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(Get_categoryList);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Category category = new Category();
                category.setCategoryId(rs.getString(1));
                category.setName(rs.getString(3));
                category.setDescription(rs.getString(3));
                categoryList.add(category);
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category getCategory(String categoryId) {
        Category category = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(Get_category);
            ps.setString(1,categoryId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                category = new Category();
                category.setCategoryId(rs.getString(1));
                category.setName(rs.getString(3));
                category.setDescription(rs.getString(3));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }


}
