package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ShopDao;
import entity.Shop;
import service.ShopService;
@Service("ShopService")
public class ShopServiceImpl extends BaseServiceImpl<Shop> implements ShopService {

	@Resource
	private ShopDao shopDao;
	@Override
	public List<Shop> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return shopDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return shopDao.getTotals(map);
	}
	@Override
	public List<Shop> queryAllShop() {
		return shopDao.queryAllShop();
	}
	@Override
	public void delete(int shop_id) {
		shopDao.delete(shop_id);
	}
	@Override
	public List<Shop> queryAllPrice(int user_id) {
		return shopDao.queryAllPrice(user_id);
	}
	@Override
	public void deleteShop(int user_id) {
		shopDao.deleteShop(user_id);
	}

}
