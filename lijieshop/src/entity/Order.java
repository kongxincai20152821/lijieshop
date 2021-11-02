package entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Order {
	private int order_id;
	private int user_id;
	private String username;
	private String trueName;
	private int IDcardNo;
	private String order_username;
	private String recevieName;
	private String address;
	private int phone;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date orderDate;
	private String message;
	private int price;

	private User user;

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getIDcardNo() {
		return IDcardNo;
	}

	public void setIDcardNo(int iDcardNo) {
		IDcardNo = iDcardNo;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getOrder_username() {
		return order_username;
	}

	public void setOrder_username(String order_username) {
		this.order_username = order_username;
	}

	public String getRecevieName() {
		return recevieName;
	}

	public void setRecevieName(String recevieName) {
		this.recevieName = recevieName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order(int order_id, int user_id, String username, String trueName, int iDcardNo, String order_username,
			String recevieName, String address, int phone, Date orderDate, String message, User user) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.username = username;
		this.trueName = trueName;
		IDcardNo = iDcardNo;
		this.order_username = order_username;
		this.recevieName = recevieName;
		this.address = address;
		this.phone = phone;
		this.orderDate = orderDate;
		this.message = message;
		this.user = user;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", username=" + username + ", trueName="
				+ trueName + ", IDcardNo=" + IDcardNo + ", order_username=" + order_username + ", recevieName="
				+ recevieName + ", address=" + address + ", phone=" + phone + ", orderDate=" + orderDate + ", message="
				+ message + ", user=" + user + "]";
	}

}
