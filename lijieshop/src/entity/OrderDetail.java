package entity;

public class OrderDetail {
	private int id;
	private int orderID;
	private int goods_id;
	private int price;
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OrderDetail(int id, int orderID, int goods_id, int price, int number) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.goods_id = goods_id;
		this.price = price;
		this.number = number;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order_Detail [id=" + id + ", orderID=" + orderID + ", goods_id=" + goods_id + ", price=" + price
				+ ", number=" + number + "]";
	}

}
