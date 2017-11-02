package hangrong.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account implements Serializable {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="gender")
	private String gender;
	@Column(name="age")
	private int age;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private String phone;
	@Column(name="addrees")
	private String address;
	@Column(name="email")
	private String email;
	@Column(name="type_user")
	private String typeUser;
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private List<Order> listOrder;

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String username, String password, String gender, int age, String name, String phone, String address,
			String email, String typeUser) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.typeUser = typeUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Order> getListOrder() {
		return new ArrayList<Order>(listOrder);
	}
	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}


}
