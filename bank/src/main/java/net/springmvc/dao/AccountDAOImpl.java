package net.springmvc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.springmvc.entity.Account;


@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO 
{	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Account> getAccounts() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Account > cq = cb.createQuery(Account.class);
        Root < Account > root = cq.from(Account.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public void saveAccount(Account theAccount) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theAccount);
	}


}
