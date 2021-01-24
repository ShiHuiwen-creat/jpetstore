package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccoutDAOImpl implements AccountDAO {
    private static final String GetAccountByUsername = "SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,\n" +
            "          ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,\n" +
        "    PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME\n" +
        "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID\n" +
        "    AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private static final String GetAccountByUsernameAndPassword = "SELECT SIGNON.USERNAME as username,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,\n" +
            "      ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,\n" +
            "      ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,\n" +
            "      PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ?\n" +
            "      AND SIGNON.PASSWORD = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

     private static final String UpdateAccount = "UPDATE ACCOUNT SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, STATUS = ?,\n" +
             "      ADDR1 = ?, ADDR2 = ?, CITY = ?,STATE = ?, ZIP = ?,COUNTRY = ?,PHONE = ? WHERE USERID = ?";

     private static final String InsertAccount = "INSERT INTO ACCOUNT (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES\n" +
             "      (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?)";

     private static final String UpdateSignOn = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";

     private static final String InsertSignOn = "INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";

     private static final String UpdateProfile = "UPDATE PROFILE SET LANGPREF = ?,FAVCATEGORY = ? WHERE USERID = ?";

     private static final String InsertProfile = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";

    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetAccountByUsername);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                account = new Account();
                account.setUsername(rs.getString(1));
                account.setEmail(rs.getString(2));
                account.setFirstName(rs.getString(3));
                account.setLastName(rs.getString(4));
                account.setStatus(rs.getString(5));
                account.setAddress1(rs.getString(6));
                account.setAddress2(rs.getString(7));
                account.setCity(rs.getString(8));
                account.setState(rs.getString(9));
                account.setZip(rs.getString(10));
                account.setCountry(rs.getString(11));
                account.setPhone(rs.getString(12));
                account.setLanguagePreference(rs.getString(13));
                account.setFavouriteCategoryId(rs.getString(14));
                account.setListOption(rs.getBoolean(15));
                account.setBannerOption(rs.getBoolean(16));
                account.setBannerName(rs.getString(17));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account retAccount = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(GetAccountByUsernameAndPassword);
            ps.setString(1,account.getUsername());
            ps.setString(2,account.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                retAccount = new Account();
                retAccount.setUsername(account.getUsername());
                retAccount.setEmail(rs.getString(2));
                retAccount.setFirstName(rs.getString(3));
                retAccount.setLastName(rs.getString(4));
                retAccount.setStatus(rs.getString(5));
                retAccount.setAddress1(rs.getString(6));
                retAccount.setAddress2(rs.getString(7));
                retAccount.setCity(rs.getString(8));
                retAccount.setState(rs.getString(9));
                retAccount.setZip(rs.getString(10));
                retAccount.setCountry(rs.getString(11));
                retAccount.setPhone(rs.getString(12));
                account.setLanguagePreference(rs.getString(13));
                account.setFavouriteCategoryId(rs.getString(14));
                account.setListOption(rs.getBoolean(15));
                account.setBannerOption(rs.getBoolean(16));
                account.setBannerName(rs.getString(17));
            }
            DBUtil.closeAll(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return retAccount;
    }

    @Override
    public void insertAccount(Account account) {
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertAccount);
            ps.setString(1,account.getEmail());
            ps.setString(2,account.getFirstName());
            ps.setString(3,account.getLastName());
            ps.setString(4,account.getStatus());
            ps.setString(5,account.getAddress1());
            ps.setString(6,account.getAddress2());
            ps.setString(7,account.getCity());
            ps.setString(8,account.getState());
            ps.setString(9,account.getZip());
            ps.setString(10,account.getCountry());
            ps.setString(11,account.getPhone());
            ps.setString(12,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UpdateAccount);
            ps.setString(1,account.getEmail());
            ps.setString(2,account.getFirstName());
            ps.setString(3,account.getLastName());
            ps.setString(4,account.getStatus());
            ps.setString(5,account.getAddress1());
            ps.setString(6,account.getAddress2());
            ps.setString(7,account.getCity());
            ps.setString(8,account.getState());
            ps.setString(9,account.getZip());
            ps.setString(10,account.getCountry());
            ps.setString(11,account.getPhone());
            ps.setString(12,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UpdateSignOn);
            ps.setString(1,account.getPassword());
            ps.setString(2,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertSignOn);
            ps.setString(1,account.getPassword());
            ps.setString(2,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(InsertProfile);
            ps.setString(1,account.getLanguagePreference());
            ps.setString(2,account.getFavouriteCategoryId());
            ps.setString(3,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UpdateProfile);
            ps.setString(1,account.getLanguagePreference());
            ps.setString(2,account.getFavouriteCategoryId());
            ps.setString(3,account.getUsername());
            ps.executeUpdate();
            DBUtil.closeAll(conn,ps,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
