package hangrong.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import hangrong.pojo.Product;

@Repository
public class ProductDAO {

	private SessionFactory factory;
	private Session session;

	public ProductDAO() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	

	public Product getProduct(String username) {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Product Product = session.get(Product.class, username);
			session.getTransaction().commit();
			return Product;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean updateProduct(Product Product) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.update(Product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public  boolean addProduct(Product Product) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(Product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public  boolean deleteProduct(String username) {
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Product Product = session.get(Product.class, username);
			session.delete(Product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
