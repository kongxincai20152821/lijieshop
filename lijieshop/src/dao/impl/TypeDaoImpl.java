package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.TypeDao;
import entity.Type;
@Repository("typeDao")
public class TypeDaoImpl extends BaseDaoImpl<Type> implements TypeDao{

	@Override
	public List<Type> queryAll() {
		return getSqlSession().selectList("Type.queryAll");
	}
}
