package service;

import java.util.List;

import entity.Order;

public interface OrderService extends BaseService<Order>{
	public List<Order> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	
	public List<Order> queryAll(int user_id);
}
