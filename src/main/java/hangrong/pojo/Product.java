package hangrong.pojo;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int code;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_image")
	private String image;
	@Column(name = "product_detail")
	private String detail;
	@Column(name = "product_price")
	private double price;
	@Column(name = "category_id")
	private String category;

	public Product() {

	}

	public Product( String name, double price, String image, String detail, String category) {
		this.name = name;
		this.price = price;
		this.image = image;
		this.detail = detail;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return "SP"+code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
