package service;

import java.util.List;

import entity.Collection;

public interface CollectionService extends BaseService<Collection>{
	public List<Collection> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	public List<Collection> queryAll(int user_id);
	public void delete(int cid);
}
