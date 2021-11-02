package service;

import java.util.List;

import entity.Type;

public interface TypeService extends BaseService<Type>{
	public List<Type> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	public List<Type> queryAll();
}
