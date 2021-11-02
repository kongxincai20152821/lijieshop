package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.OrderDao;
import entity.Order;
import service.OrderService;
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

	@Resource
	private OrderDao orderDao;
	@Override
	public List<Order> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return orderDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return orderDao.getTotals(map);
	}
	@Override
	public List<Order> queryAll(int user_id) {
		return orderDao.queryAll(user_id);
	}

}
