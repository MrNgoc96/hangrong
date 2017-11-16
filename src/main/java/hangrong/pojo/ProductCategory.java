package hangrong.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "danhmuc")
public class ProductCategory {
	
	@Id
	@Column(name="madanhmuc")
	private String maDanhMuc;
	@Column(name="tendanhmuc")
	private String tenDanhMuc;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="madanhmuc")
	private List<Product> dsSanPham;
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}
	public ProductCategory(String maDanhMuc, String tenDanhMuc) {
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public ArrayList<Product> getDsSanPham() {
		return new ArrayList<Product>(dsSanPham);
	}
	public void setDsSanPham(List<Product> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}
	
	
	
}
