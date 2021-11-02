package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.SuperTypeDao;
import entity.SuperType;
import service.SuperTypeService;
@Service("superTypeService")
public class SuperTypeServiceImpl extends BaseServiceImpl<SuperType> implements SuperTypeService {

	@Resource
	private SuperTypeDao superTypeDao;
	@Override
	public List<SuperType> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return superTypeDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return superTypeDao.getTotals(map);
	}

}
