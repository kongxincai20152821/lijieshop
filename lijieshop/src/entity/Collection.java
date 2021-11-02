package entity;

public class Collection {
	private int cid;
	private int user_id;
	private int goods_id;
	private String goodsName;
	private int price;
	private int newPrice;
	private String introduce;
	private String logo_path;

	
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

	public int getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public Collection(int cid, int user_id, int goods_id) {
		super();
		this.cid = cid;
		this.user_id = user_id;
		this.goods_id = goods_id;
	}

	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Collection [cid=" + cid + ", user_id=" + user_id + ", goods_id=" + goods_id + "]";
	}

}
