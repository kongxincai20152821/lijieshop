package dao;

import java.util.List;
import java.util.Map;

import entity.Shop;

public interface ShopDao extends BaseDao<Shop>{
	public List<Shop> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	public List<Shop> queryAllShop();
	public void delete(int shop_id);
	public List<Shop> queryAllPrice(int user_id);
	public void deleteShop(int user_id);
}
