package hangrong.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import hangrong.pojo.Account;

@Repository
public class AccountDAO {

	private SessionFactory factory;
	private Session session;

	public AccountDAO() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public  Account getAccount(String username) {
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

	public  boolean updateAccount(Account Account) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.update(Account);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
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

	public  boolean deleteAccount(String username) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Account Account = session.get(Account.class, username);
			session.delete(Account);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
