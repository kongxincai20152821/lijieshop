package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.OrderDetailDao;
import entity.OrderDetail;
import service.OrderDetailService;
@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {

	@Resource
	private OrderDetailDao OrderDetailDao;
	@Override
	public List<OrderDetail> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return OrderDetailDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return OrderDetailDao.getTotals(map);
	}

}
