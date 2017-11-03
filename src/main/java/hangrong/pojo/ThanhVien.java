package hangrong.pojo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ThanhVien")
public class ThanhVien {
	@Id
	@Column(name="user_id")
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
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nguoiban")
	private List<MatHang> dsMathang;

	public ThanhVien() {}
	

}
