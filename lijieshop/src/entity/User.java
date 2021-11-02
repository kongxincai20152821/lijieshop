package entity;

public class User {
	private int user_id;
	private String username;
	private String trueName;
	private String password;
	private String city;
	private String address;
	private int postCode;
	private int IDcardNo;
	private int IDcardType;
	private int discount_id;
	private int balance;
	private int phone;
	private String email;
	private int user_state;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public int getIDcardNo() {
		return IDcardNo;
	}

	public void setIDcardNo(int iDcardNo) {
		IDcardNo = iDcardNo;
	}



	public int getIDcardType() {
		return IDcardType;
	}

	public void setIDcardType(int iDcardType) {
		IDcardType = iDcardType;
	}

	public int getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
