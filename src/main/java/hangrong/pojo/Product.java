package hangrong.pojo;

import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mathang")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mamathang")
	private int mahang;
	@Column(name = "tenmathang")
	private String tenhang;
	@Column(name = "anh")
	private String anh;
	@Column(name = "ngaydang")
	private String ngaydang;
	@Column(name = "gia")
	private double gia;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "madanhmuc")
	private ProductCategory loaihang;
	@Column(name = "tinhtrang")
	private String tingtrang;
	@Column(name = "mota")
	private String mota;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "nguoiban")
	private Account nguoiban;

	public Product() {
	}
	
	public Product(String tenhang, String anh, String ngaydang, double gia, ProductCategory loaihang,
			String tingtrang, String mota, Account nguoiban) {
		this.tenhang = tenhang;
		this.anh = anh;
		this.ngaydang = ngaydang;
		this.gia = gia;
		this.loaihang = loaihang;
		this.tingtrang = tingtrang;
		this.mota = mota;
		this.nguoiban = nguoiban;
	}

	public int getMahang() {
		return mahang;
	}

	public void setMahang(int mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public String[] getAnh() {
		return anh.split(";");
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getNgaydang() {
		return ngaydang;
	}

	public void setNgaydang(String ngaydang) {
		this.ngaydang = ngaydang;
	}

	public String getGia() {
		DecimalFormat format = new DecimalFormat("###,###,###");
		return format.format(gia);
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public ProductCategory getLoaihang() {
		return loaihang;
	}

	public void setLoaihang(ProductCategory loaihang) {
		this.loaihang = loaihang;
	}

	public String getTingtrang() {
		return tingtrang;
	}

	public void setTingtrang(String tingtrang) {
		this.tingtrang = tingtrang;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Account getNguoiban() {
		return nguoiban;
	}

	public void setNguoiban(Account nguoiban) {
		this.nguoiban = nguoiban;
	}
	
}