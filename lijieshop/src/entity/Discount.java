package entity;

public class Discount {
	private int discount_id;
	private int new_price;
	private int discount_number;

	public int getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}

	public int getNew_price() {
		return new_price;
	}

	public void setNew_price(int new_price) {
		this.new_price = new_price;
	}

	public int getDiscount_number() {
		return discount_number;
	}

	public void setDiscount_number(int discount_number) {
		this.discount_number = discount_number;
	}

	public Discount(int discount_id, int new_price, int discount_number) {
		super();
		this.discount_id = discount_id;
		this.new_price = new_price;
		this.discount_number = discount_number;
	}

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Discount [discount_id=" + discount_id + ", new_price=" + new_price + ", discount_number="
				+ discount_number + "]";
	}

}
