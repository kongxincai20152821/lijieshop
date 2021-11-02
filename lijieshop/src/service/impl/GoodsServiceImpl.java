package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.GoodsDao;
import entity.Goods;
import service.GoodsService;
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

	@Resource
	private GoodsDao goodsDao;
	@Override
	public List<Goods> queryByPage(int currentPage, int pageSize, String qGoodsId, String qGoodsName) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qGoodsId", qGoodsId);
        map.put("qGoodsName", qGoodsName);
		return goodsDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return goodsDao.getTotals(map);
	}
	@Override
	public List<Goods> queryAll() {
		return goodsDao.queryAll();
	}
	@Override
	public int getTotals() {
		return goodsDao.getTotals();
	}
	@Override
	public List<Goods> queryByCondition(String goodsName,int price,int sp,int pageSize) {
		return goodsDao.queryByCondition(goodsName,price,sp,pageSize);
	}
	@Override
	public List<Goods> queryByType(int type) {
		return goodsDao.queryByType(type);
	}
	@Override
	public int queryTotals(String goodsName, int price) {
		return goodsDao.queryTotals(goodsName,price);
	}

}
