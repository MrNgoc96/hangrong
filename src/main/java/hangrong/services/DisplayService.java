package hangrong.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hangrong.dao.DisplayDAO;
import hangrong.pojo.Account;
import hangrong.pojo.Product;

@Service
public class DisplayService {

	@Autowired
	private DisplayDAO displayDAO;
	
	public ArrayList<Account> getAllAccount(){
		return displayDAO.getListAccount();
	}
	
	public ArrayList<Product> getAllProduct(){
		return displayDAO.getListProduct();
	}
	
	public ArrayList<Product> getProductFromType(String categoryId){
		if(categoryId.equals("hang-rong-nha")) {
			categoryId = "HRNHA";
		}else if(categoryId.equals("hang-rong-xe")) {
			categoryId = "HRXE";
		}else if(categoryId.equals("do-gia-dung")) {
			categoryId = "DGD";
		}else if(categoryId.equals("dien-tu-cong-nghe")) {
			categoryId = "DTCN";
		}else if(categoryId.equals("giai-tri-the-thao")) {
			categoryId = "GTTT";
		}else if(categoryId.equals("san-pham-khac")) {
			categoryId = "SPK";
		}
		return displayDAO.getProductFromType(categoryId);
	}
	
	public Product getProduct(String productId) {
		int id = Integer.parseInt(productId.replaceAll("[Mh,MH,mH,Mh]", ""));
		return displayDAO.getProduct(id);
	}
	
	public String getCapGanhHang(String userId) {
		int total = displayDAO.getAccount(userId).getDsMathang().size();
		if (total < 2) {
			return "Hàng Rong Sơ Cấp";
		} else if (total >= 2 && total < 5) {
			return "Hàng Rong Trung Cấp";
		} else if (total >= 5 && total < 10) {
			return "Hàng Rong Cao Cấp";
		} else {
			return "Hàng Rong VIP";
		}
	}
	
	public ArrayList<Product> divisionPage(ArrayList<Product> listMathang, int page) {
		if (listMathang != null) {
			ArrayList<Product> list = new ArrayList<Product>();
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
	
	public int totalPage(int total) {
		int page = total/6;
		if(total % 6 > 0) {
			page++;
		}
		return page;
	}

}
