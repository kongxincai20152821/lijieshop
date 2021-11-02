package service;

import java.util.List;

import entity.Discount;

public interface DiscountService extends BaseService<Discount>{
	public List<Discount> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
}
