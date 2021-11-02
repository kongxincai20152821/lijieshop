package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.OrderDao;
import entity.Order;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

	@Override
	public List<Order> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Order.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Order.getTotals",map);
	}

	@Override
	public List<Order> queryAll(int user_id) {
		return getSqlSession().selectList("Order.queryAll",user_id);
	}

}
