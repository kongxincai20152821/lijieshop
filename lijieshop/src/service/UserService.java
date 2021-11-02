package service;

import java.util.List;

import entity.User;

public interface UserService extends BaseService<User>{
	public List<User> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	public User queryUser(String username,String password);
}
