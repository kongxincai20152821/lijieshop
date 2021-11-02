package service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BaseDao;
import service.BaseService;
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{
    @Resource
    private BaseDao<T> baseDao;
	@Override
	public void add(T t) {
		baseDao.add(t);
	}

	@Override
	public void addMore(List<T> t) {
		baseDao.addMore(t);
	}

	@Override
	public void delete(Class<?> cls, Serializable id) {
		baseDao.delete(cls, id);
	}

	@Override
	public void deleteMore(Class<?> cls, String ids) {
		baseDao.deleteMore(cls, ids);
	}

	@Override
	public void update(Class<?> cls, T id) {
		baseDao.update(cls, id);
	}

	@Override
	public T queryById(Class<?> cls, Serializable id) {
		return baseDao.queryById(cls, id);
	}

	@Override
	public int getTotals(Class<?> cls) {
		return baseDao.getTotals(cls);
	}

	/*@Override
	public List<T> queryUserAll(Class<?> cls,String rids) {
		return baseDao1.queryUserAll(cls,rids);
	}*/

	@Override
	public List<T> queryByPage(Class<?> cls, int currentPage, int pageSize) {
		Map<String,Object> map=new HashMap<>(); 
		map.put("currentPage", (currentPage-1)*pageSize);
		map.put("pageSize",pageSize);
		return baseDao.queryByPage(cls, map);
	}

	
}
