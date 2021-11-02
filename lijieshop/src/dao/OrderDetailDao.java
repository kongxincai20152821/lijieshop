package dao;

import java.util.List;
import java.util.Map;

import entity.OrderDetail;

public interface OrderDetailDao extends BaseDao<OrderDetail>{
	public List<OrderDetail> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
}
