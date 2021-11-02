package service;

import java.util.List;

import entity.LittleType;

public interface LittleTypeService extends BaseService<LittleType>{
	public List<LittleType> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	
	public List<LittleType> queryAll();
}
