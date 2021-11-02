package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.ShopDao;
import entity.Shop;
@Repository("shopDao")
public class ShopDaoImpl extends BaseDaoImpl<Shop> implements ShopDao{

	@Override
	public List<Shop> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Shop.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Shop.getTotals",map);
	}

	@Override
	public List<Shop> queryAllShop() {
		return getSqlSession().selectList("Shop.queryAllShop");
	}

	@Override
	public void delete(int shop_id) {
		getSqlSession().delete("Shop.delete",shop_id);
	}

	@Override
	public List<Shop> queryAllPrice(int user_id) {
		return getSqlSession().selectList("Shop.queryAllPrice",user_id);
	}

	@Override
	public void deleteShop(int user_id) {
		getSqlSession().delete("Shop.deleteShop",user_id);
	}

}
