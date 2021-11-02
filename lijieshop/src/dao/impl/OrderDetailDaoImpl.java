package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.OrderDetailDao;
import entity.OrderDetail;
@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail> implements OrderDetailDao{

	@Override
	public List<OrderDetail> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("OrderDetail.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("OrderDetail.getTotals",map);
	}

}
