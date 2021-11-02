package dao;

import java.util.List;
import java.util.Map;

import entity.Discount;

public interface DiscountDao extends BaseDao<Discount>{
	public List<Discount> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
}
