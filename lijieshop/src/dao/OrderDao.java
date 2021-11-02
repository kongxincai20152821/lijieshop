package dao;

import java.util.List;
import java.util.Map;

import entity.Order;

public interface OrderDao extends BaseDao<Order>{
	public List<Order> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	
	public List<Order> queryAll(int user_id);
}
