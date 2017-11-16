package hangrong.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import hangrong.pojo.Account;



@Repository
public class LoginDAO {
	private SessionFactory factory;
	private Session session;

	public LoginDAO() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public boolean checkLogin(String username, String password) {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "SELECT username From Account Where username=:username and matkhau = :password";
			Query<Account> query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Account> list = query.list();
			session.getTransaction().commit();
			return list.size() >= 1;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Account getAccount(String username) {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Account Account = session.get(Account.class, username);
			session.getTransaction().commit();
			return Account;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public  boolean addAccount(Account Account) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(Account);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
