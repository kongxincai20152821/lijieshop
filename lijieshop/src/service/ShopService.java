package service;

import java.util.List;

import entity.Shop;

public interface ShopService extends BaseService<Shop>{
	public List<Shop> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	public List<Shop> queryAllShop();
	public void delete(int shop_id);
	public List<Shop> queryAllPrice(int user_id);
	public void deleteShop(int user_id);
}
