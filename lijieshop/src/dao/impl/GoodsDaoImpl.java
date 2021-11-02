package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.GoodsDao;
import entity.Goods;
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao{

	@Override
	public List<Goods> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Goods.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Goods.getTotals",map);
	}

	@Override
	public List<Goods> queryAll() {
		return getSqlSession().selectList("Goods.queryAll");
	}

	@Override
	public int getTotals() {
		return getSqlSession().selectOne("Goods.getTotals");
	}

	@Override
	public List<Goods> queryByCondition(String goodsName, int price,int sp,int pageSize) {
		Map<String,Object> map=new HashMap<>();
		map.put("goodsName",goodsName);
		map.put("price",price);
		map.put("sp",sp);
		map.put("pageSize",pageSize);
		return getSqlSession().selectList("Goods.queryByCondition",map);
	}

	@Override
	public List<Goods> queryByType(int type) {
		return getSqlSession().selectList("Goods.queryByType",type);
	}

	@Override
	public int queryTotals(String goodsName, int price) {
		Map<String,Object> map=new HashMap<>();
		map.put("goodsName",goodsName);
		map.put("price",price);
		return getSqlSession().selectOne("Goods.queryTotals",map);
	}
}
