package hangrong.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hangrong.pojo.MatHang;
import hangrong.pojo.ThanhVien;

public class ThanhVienDAO {

	private static Session session;

	@SuppressWarnings("unchecked")
	public static ArrayList<ThanhVien> getListThanhVien() {
		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			String hql = "FROM ThanhVien";
			Query<ThanhVien> query = session.createQuery(hql);
			ArrayList<ThanhVien> list = (ArrayList<ThanhVien>) query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean checkLogin(String username, String password) {
		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			String hql = "SELECT username From ThanhVien Where username=:username and matkhau = :password";
			Query<ThanhVien> query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<ThanhVien> list = query.list();
			session.getTransaction().commit();
			return list.size() >= 1;
		} catch (Exception e) {
			return false;
		}
	}

	public static ThanhVien getThanhVien(String username) {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		ThanhVien thanhVien = session.get(ThanhVien.class, username);
		session.getTransaction().commit();
		return thanhVien;
	}

	public static boolean updateThanhVien(ThanhVien thanhVien) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(thanhVien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean addThanhVien(ThanhVien thanhVien) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(thanhVien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteThanhVien(String username) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			ThanhVien thanhVien =  session.get(ThanhVien.class, username);
			session.delete(thanhVien);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getCapGanhHang(String userId) {
		int total = getThanhVien(userId).getDsMathang().size();
		if(total<5) {
			return "Hàng Rong Sơ Cấp";
		}else if(total>=5 && total < 10) {
			return "Hàng Rong Trung Cấp";
		}else if(total>=10 && total < 15) {
			return "Hàng Rong Cao Cấp";
		}else {
			return "Hàng Rong VIP";
		}
	}

	public static void main(String[] args) {
		System.out.println(checkLogin("ngoc96", "123"));
	}
}
