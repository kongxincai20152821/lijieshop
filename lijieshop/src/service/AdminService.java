package service;

import java.util.List;

import entity.Admin;

public interface AdminService extends BaseService<Admin>{
	public List<Admin> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	public Admin queryAdmin(String username,String password);
}
