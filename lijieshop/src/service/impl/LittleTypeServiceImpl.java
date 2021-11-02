package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.LittleTypeDao;
import entity.LittleType;
import service.LittleTypeService;
@Service("littleTypeService")
public class LittleTypeServiceImpl extends BaseServiceImpl<LittleType> implements LittleTypeService {

	@Resource
	private LittleTypeDao littleTypeDao;
	@Override
	public List<LittleType> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return littleTypeDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return littleTypeDao.getTotals(map);
	}
	@Override
	public List<LittleType> queryAll() {
		return littleTypeDao.queryAll();
	}

}
