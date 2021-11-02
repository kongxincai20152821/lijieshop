package service;

import java.util.List;

import entity.OrderDetail;

public interface OrderDetailService extends BaseService<OrderDetail>{
	public List<OrderDetail> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
}
