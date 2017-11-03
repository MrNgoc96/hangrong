package hangrong.pojo;

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
@Table(name = "giaodich")
public class GiaoDich {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "magiaodich")
	private int maGiaoDich;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mamathang")
	private MatHang matHang;
	@Column(name = "tgdathang")
	private String tgDatHang;
	@Column(name = "tgnhanhang")
	private String tgNhanHang;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nguoiban")
	private ThanhVien nguoiBan;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nguoimua")
	private ThanhVien nguoiMua;

	public GiaoDich() {
		// TODO Auto-generated constructor stub
	}

	public GiaoDich(int maGiaoDich, MatHang matHang, String tgDatHang, String tgNhanHang, ThanhVien nguoiBan,
			ThanhVien nguoiMua) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.matHang = matHang;
		this.tgDatHang = tgDatHang;
		this.tgNhanHang = tgNhanHang;
		this.nguoiBan = nguoiBan;
		this.nguoiMua = nguoiMua;
	}

	public int getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(int maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public MatHang getMatHang() {
		return matHang;
	}

	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}

	public String getTgDatHang() {
		return tgDatHang;
	}

	public void setTgDatHang(String tgDatHang) {
		this.tgDatHang = tgDatHang;
	}

	public String getTgNhanHang() {
		return tgNhanHang;
	}

	public void setTgNhanHang(String tgNhanHang) {
		this.tgNhanHang = tgNhanHang;
	}

	public ThanhVien getNguoiBan() {
		return nguoiBan;
	}

	public void setNguoiBan(ThanhVien nguoiBan) {
		this.nguoiBan = nguoiBan;
	}

	public ThanhVien getNguoiMua() {
		return nguoiMua;
	}

	public void setNguoiMua(ThanhVien nguoiMua) {
		this.nguoiMua = nguoiMua;
	}

}
