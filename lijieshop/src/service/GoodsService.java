package service;

import java.util.List;

import entity.Goods;

public interface GoodsService extends BaseService<Goods>{
	public List<Goods> queryByPage(int currentPage,int pageSize,String qGoodsId,String qGoodsName);
	public int getTotals(String qGoodsId,String qGoodsName);
	
	public List<Goods> queryAll();
	public int getTotals();
	
	public List<Goods> queryByCondition(String goodsName,int price,int sp,int pageSize);
	public List<Goods> queryByType(int type);
	public int queryTotals(String goodsName,int price);
}
