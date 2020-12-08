package net.springmvc.dao;

import java.util.List;

import net.springmvc.entity.Account;



public interface AccountDAO {
	public List < Account > getAccounts();

    public void saveAccount(Account theAccount);
    
}
