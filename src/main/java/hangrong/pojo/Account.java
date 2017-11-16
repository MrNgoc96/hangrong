package hangrong.pojo;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ThanhVien")
public class Account {
	@Id
	@Column(name="tendangnhap")
	private String username;
	@Column(name="matkhau")
	private String matkhau;
	@Column(name="ten")
	private String ten;
	@Column(name="sodienthoai")
	private String sodienthoai;
	@Column(name="diachi")
	private String diachi;
	@Column(name="anh")
	private String anh;
	@Column(name="chucnang")
	private String chucnang;
	@Column(name="ngaythamgia")
	private String ngaythamgia;
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nguoiban")
	private List<Product> dsMathang;

	public Account() {}

	public Account(String username, String matkhau, String ten, String sodienthoai, String diachi, String anh,
			String chucnang, String ngaythamgia) {
		this.username = username;
		this.matkhau = matkhau;
		this.ten = ten;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.anh = anh;
		this.chucnang = chucnang;
		this.ngaythamgia = ngaythamgia;
	}
	public String getNgaythamgia() {
		return ngaythamgia;
	}

	public void setNgaythamgia(String ngaythamgia) {
		this.ngaythamgia = ngaythamgia;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getChucnang() {
		return chucnang;
	}

	public void setChucnang(String chucnang) {
		this.chucnang = chucnang;
	}

	public ArrayList<Product> getDsMathang() {
		return new ArrayList<Product>(dsMathang);
	}

	public void setDsMathang(List<Product> dsMathang) {
		this.dsMathang = dsMathang;
	}
	
	
	

	

}
