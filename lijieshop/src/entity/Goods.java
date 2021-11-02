package entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Goods {
	private int goods_id;
	private int ltype_id;
	private String goodsName;
	private String introduce;
	private int price;
	private int newPrice;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date lnTime;
	private int newGoods;
	private int sale;
	private int goods_total;
	private int state;
	private int type;
	private String name;
	private String logo_path;
	private String ltype_name;

	private LittleType littleType;
	private Type goods_type;

	
	
	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLtype_name() {
		return ltype_name;
	}

	public void setLtype_name(String ltype_name) {
		this.ltype_name = ltype_name;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getLtype_id() {
		return ltype_id;
	}

	public void setLtype_id(int ltype_id) {
		this.ltype_id = ltype_id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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

	public Date getLnTime() {
		return lnTime;
	}

	public void setLnTime(Date lnTime) {
		this.lnTime = lnTime;
	}

	public int getNewGoods() {
		return newGoods;
	}

	public void setNewGoods(int newGoods) {
		this.newGoods = newGoods;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getGoods_total() {
		return goods_total;
	}

	public void setGoods_total(int goods_total) {
		this.goods_total = goods_total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

	public Goods(int goods_id, int ltype_id, String ltype_name, String goodsName, String introduce, int price,
			int newPrice, Date lnTime, int newGoods, int sale, int goods_total, int state, int type, String name,
			String logo_path) {
		super();
		this.goods_id = goods_id;
		this.ltype_id = ltype_id;
		this.ltype_name = ltype_name;
		this.goodsName = goodsName;
		this.introduce = introduce;
		this.price = price;
		this.newPrice = newPrice;
		this.lnTime = lnTime;
		this.newGoods = newGoods;
		this.sale = sale;
		this.goods_total = goods_total;
		this.state = state;
		this.type = type;
		this.name = name;
		this.logo_path = logo_path;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", ltype_id=" + ltype_id + ", ltype_name=" + ltype_name + ", goodsName="
				+ goodsName + ", introduce=" + introduce + ", price=" + price + ", newPrice=" + newPrice + ", lnTime="
				+ lnTime + ", newGoods=" + newGoods + ", sale=" + sale + ", goods_total=" + goods_total + ", state="
				+ state + ", type=" + type + ", name=" + name + ", logo_path=" + logo_path + "]";
	}

}
