package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.CollectionDao;
import entity.Collection;
@Repository("collectionDao")
public class CollectionDaoImpl extends BaseDaoImpl<Collection> implements CollectionDao{

	@Override
	public List<Collection> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Collection.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Collection.getTotals",map);
	}

	@Override
	public List<Collection> queryAll(int user_id) {
		return getSqlSession().selectList("Collection.queryAll", user_id);
	}

	@Override
	public void delete(int cid) {
		getSqlSession().delete("Collection.delete",cid);
	}

}
