package dao;

import java.util.List;
import java.util.Map;

import entity.Goods;

public interface GoodsDao extends BaseDao<Goods>{
	public List<Goods> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	
	public List<Goods> queryAll();
	public int getTotals();
	public List<Goods> queryByCondition(String goodsName,int price,int sp,int pageSize);
	public List<Goods> queryByType(int type);
	
	public int queryTotals(String goodsName,int price);
}
