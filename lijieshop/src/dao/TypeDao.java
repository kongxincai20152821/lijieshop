package dao;

import java.util.List;

import entity.Type;

public interface TypeDao extends BaseDao<Type>{
	public List<Type> queryAll();
}
