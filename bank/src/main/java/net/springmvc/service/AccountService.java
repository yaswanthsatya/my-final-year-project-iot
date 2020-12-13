package net.springmvc.service;

import java.util.List;

import net.springmvc.entity.Account;

public interface AccountService {
	
	public List < Account > getAccounts();

    public void saveAccount(Account theAccount);
    
    //public void getBlns(Account theAccount);
}
