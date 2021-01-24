package org.csu.mypetstore.service;

import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.impl.AccoutDAOImpl;

public class AccountService {

    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccoutDAOImpl();
    }

    public Account getAccount(String username) {
        return accountDAO.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDAO.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) {
        accountDAO.insertAccount(account);
        accountDAO.insertSignon(account);
        accountDAO.insertProfile(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        accountDAO.updateProfile(account);
        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountDAO.updateSignon(account);
        }
    }

    public boolean usernameIsExist(String username) {
        Account account = accountDAO.getAccountByUsername(username);
        if (account == null)
            return false;
        else
            return true;
    }
}
