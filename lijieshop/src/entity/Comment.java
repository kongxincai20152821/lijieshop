package entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Comment {
	private int comment_id;
	
	private int user_id;
	private String username;
	private String trueName;
	private int IDcardNo;
	
	private int goods_id;
	private String goodsName;
	
	private String title;
	private String content;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date publish_time;
	
	private User user;
	private Goods goods;

	
	
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public Comment(int comment_id, int user_id, int goods_id, String title, String content, Date publish_time) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.title = title;
		this.content = content;
		this.publish_time = publish_time;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", user_id=" + user_id + ", goods_id=" + goods_id + ", title="
				+ title + ", content=" + content + ", publish_time=" + publish_time + "]";
	}

}
