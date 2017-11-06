package hangrong.model;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hangrong.pojo.MatHang;

public class MatHangDAO {

	private static Session session;

	@SuppressWarnings("unchecked")
	public static ArrayList<MatHang> getListMatHang(String loaiMatHang) {
		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			String hql = "";
			Query<MatHang> query;
			if (loaiMatHang.equals("")) {
				hql = "FROM MatHang";
				query = session.createQuery(hql);
			} else {
				hql = "FROM MatHang Where loaihang = :loaihang";
				query = session.createQuery(hql);
				query.setParameter("loaihang", loaiMatHang);
			}
			ArrayList<MatHang> list = (ArrayList<MatHang>) query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public static MatHang getMatHang(String maMH) {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		int ma = Integer.parseInt(maMH.replaceAll("[Mh,MH,mH,Mh]", ""));
		MatHang matHang = session.get(MatHang.class, ma);
		session.getTransaction().commit();
		return matHang;
	}
	

	public static ArrayList<MatHang> divisionPage(ArrayList<MatHang> listMathang, int page) {
		if (listMathang != null) {
			ArrayList<MatHang> list = new ArrayList<MatHang>();
			int firstResult = (page - 1) * 6;
			int maxResult = 6;
			for (int i = firstResult; i < listMathang.size(); i++) {
				list.add(listMathang.get(i));
				if (list.size() >= maxResult) {
					break;
				}
			}
			return list;
		}
		return null;
	}
	
	public static int totalPage(int total) {
		int page = total/6;
		if(total % 6 > 0) {
			page++;
		}
		return page;
	}

	public static void main(String[] args) {
		System.out.println(getListMatHang("").get(0).getAnh());
	}
}
