package hangrong.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderID;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private Account account;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="order_address")
	private String orderAddress;
	@Column(name="order_status")
	private String orderStatus;
	@Column(name="order_totalPrice")
	private int totalPrice;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
  private List<OrderDetail> listOrderDetail;


	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order( Account account, Date orderDate, String orderAddress, String orderStatus,
			int totalPrice) {
		this.account = account;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
	}

	public String getOrderID() {
		return "DH"+orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<OrderDetail> getListOrderDetail() {
		return new ArrayList<OrderDetail>(listOrderDetail);
	}

	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}









}
