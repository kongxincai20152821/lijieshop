package dao;

import java.util.List;
import java.util.Map;

import entity.SuperType;

public interface SuperTypeDao extends BaseDao<SuperType>{
	public List<SuperType> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
}
