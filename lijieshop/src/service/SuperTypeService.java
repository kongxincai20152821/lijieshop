package service;

import java.util.List;

import entity.SuperType;

public interface SuperTypeService extends BaseService<SuperType>{
	public List<SuperType> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
}
