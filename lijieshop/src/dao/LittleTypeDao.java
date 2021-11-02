package dao;

import java.util.List;
import java.util.Map;

import entity.LittleType;

public interface LittleTypeDao extends BaseDao<LittleType>{
	public List<LittleType> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	
	public List<LittleType> queryAll();
}
