package hangrong.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import hangrong.pojo.Account;
import hangrong.pojo.Product;
import hangrong.pojo.ProductCategory;

@Repository
public class DisplayDAO {

	private SessionFactory factory;
	private Session session;

	public DisplayDAO() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Account> getListAccount() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "FROM Account";
			Query<Account> query = session.createQuery(hql);
			ArrayList<Account> list = (ArrayList<Account>) query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Product> getListProduct() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "FROM Product";
			Query<Product> query = session.createQuery(hql);
			ArrayList<Product> list = (ArrayList<Product>) query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public ArrayList<Product> getProductFromType(String categoryId) {
		session = factory.getCurrentSession();
		try {
			if (!session.getTransaction().isActive()) {
				session.beginTransaction();
				ProductCategory productCategory = session.get(ProductCategory.class, categoryId);
				ArrayList<Product> list = productCategory.getDsSanPham();
				session.getTransaction().commit();
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public Product getProduct(int id) {
		session = factory.getCurrentSession();
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
			Product product = session.get(Product.class, id);
			session.getTransaction().commit();
			return product;
		} else {
			return null;
		}
	}

	public Account getAccount(String userId) {
		if (!session.getTransaction().isActive()) {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Account account = session.get(Account.class, userId);
			session.getTransaction().commit();
			return account;
		} else {
			return null;
		}
	}

}
