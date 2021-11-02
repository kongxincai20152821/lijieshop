package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.LittleTypeDao;
import entity.LittleType;
@Repository("littleTypeDao")
public class LittleTypeDaoImpl extends BaseDaoImpl<LittleType> implements LittleTypeDao{

	@Override
	public List<LittleType> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("LittleType.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("LittleType.getTotals",map);
	}

	@Override
	public List<LittleType> queryAll() {
		return getSqlSession().selectList("LittleType.queryAll");
	}

}
