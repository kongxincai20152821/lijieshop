package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.SuperTypeDao;
import entity.SuperType;
@Repository("superTypeDao")
public class SuperTypeDaoImpl extends BaseDaoImpl<SuperType> implements SuperTypeDao{

	@Override
	public List<SuperType> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("SuperType.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("SuperType.getTotals",map);
	}

}
