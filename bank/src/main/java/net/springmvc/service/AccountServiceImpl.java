package net.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.springmvc.dao.AccountDAO;
import net.springmvc.entity.Account;


@Service
public class AccountServiceImpl implements AccountService {
	
	
	@Autowired
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	public void saveAccount(Account theAccount) {
		accountDAO.saveAccount(theAccount);
		
	}

}
