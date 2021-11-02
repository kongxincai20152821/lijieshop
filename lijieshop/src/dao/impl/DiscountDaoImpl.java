package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.DiscountDao;
import entity.Discount;
@Repository("discountDao")
public class DiscountDaoImpl extends BaseDaoImpl<Discount> implements DiscountDao{

	@Override
	public List<Discount> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Discount.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Discount.getTotals",map);
	}

}
