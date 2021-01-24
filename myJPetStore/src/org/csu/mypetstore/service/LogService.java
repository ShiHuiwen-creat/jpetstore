package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.persistence.LogDAO;
import org.csu.mypetstore.persistence.impl.LogDAOImpl;

import java.util.List;

public class LogService {
    LogDAO logDAO;
    public LogService(){
        logDAO = new LogDAOImpl();
    }

    public void insertBrowseLog(Account account,String itemId){
        logDAO.insertBrowseLog(account,itemId);
    }

    public void insertAddLog(Account account,String itemId){
        logDAO.insertAddLog(account,itemId);
    }

    public List<Log> getBrowseLogListByUsername(String username){
        return logDAO.getBrowseLogListByUsername(username);
    }

    public List<Log> getAddLogListByUsername(String username){
        return logDAO.getAddListByUsername(username);
    }
}
