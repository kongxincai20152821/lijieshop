package service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	   public void add(T t);
	   public void addMore(List<T> t);
	   public void delete(Class<?> cls,Serializable id);
	   public void deleteMore(Class<?> cls,String ids);
	   public void update(Class<?> cls,T id);
	   public T queryById(Class<?> cls,Serializable id);
	   public List<T> queryByPage(Class<?> cls,int currentPage,int pageSize);
	   public int getTotals(Class<?> cls);
}
