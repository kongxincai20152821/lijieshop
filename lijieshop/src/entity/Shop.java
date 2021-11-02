package entity;

public class Shop {
	private int shop_id;
	private int user_id;
	private int goods_id;
	private String goodsName;
	private int price;
	private int number;
	private String logo_path;

	
	
	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public Shop(int shop_id, int user_id, int goods_id) {
		super();
		this.shop_id = shop_id;
		this.user_id = user_id;
		this.goods_id = goods_id;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Shop [shop_id=" + shop_id + ", user_id=" + user_id + ", goods_id=" + goods_id + "]";
	}

}
