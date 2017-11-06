package hangrong.pojo;

import javax.persistence.*;

@Entity
@Table(name = "mathang")
public class MatHang {
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
	@Column(name = "loaihang")
	private String loaihang;
	@Column(name = "tinhtrang")
	private String tingtrang;
	@Column(name = "mota")
	private String mota;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "nguoiban")
	private ThanhVien nguoiban;

	public MatHang() {
	}
	
	public MatHang(String tenhang, String anh, String ngaydang, double gia, String loaihang,
			String tingtrang, String mota, ThanhVien nguoiban) {
		this.tenhang = tenhang;
		this.anh = anh;
		this.ngaydang = ngaydang;
		this.gia = gia;
		this.loaihang = loaihang;
		this.tingtrang = tingtrang;
		this.mota = mota;
		this.nguoiban = nguoiban;
	}
	public String getMahang() {
		return "MH"+mahang;
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

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getLoaihang() {
		return loaihang;
	}

	public void setLoaihang(String loaihang) {
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

	public ThanhVien getNguoiban() {
		return nguoiban;
	}

	public void setNguoiban(ThanhVien nguoiban) {
		this.nguoiban = nguoiban;
	}
	
}
