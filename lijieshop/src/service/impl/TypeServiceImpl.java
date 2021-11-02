package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.TypeDao;
import entity.Type;
import service.TypeService;
@Service("typeService")
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {
	@Resource
	private TypeDao typeDao;
	@Override
	public List<Type> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		map.put("qusername",qusername);
		map.put("qpassword",qpassword);
		return typeDao.queryByPage(Type.class,map);
	}

	@Override
	public int getTotals(String qusername, String password) {
		return typeDao.getTotals(Type.class);
	}

	@Override
	public List<Type> queryAll() {
		return typeDao.queryAll();
	}
}
