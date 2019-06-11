package com.jdbc001;

public interface AccountDao {

    public int addAccount(Account account);
    public int updateAccount(Account account);
    public int deleteAccount(int id);

}
