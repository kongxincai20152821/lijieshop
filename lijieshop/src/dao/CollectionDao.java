package dao;

import java.util.List;
import java.util.Map;

import entity.Collection;

public interface CollectionDao extends BaseDao<Collection>{
	public List<Collection> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	public List<Collection> queryAll(int user_id);
	public void delete(int cid);
}
