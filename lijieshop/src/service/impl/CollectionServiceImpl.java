package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CollectionDao;
import entity.Collection;
import service.CollectionService;
@Service("collectionService")
public class CollectionServiceImpl extends BaseServiceImpl<Collection> implements CollectionService {

	@Resource
	private CollectionDao CollectionDao;
	@Override
	public List<Collection> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return CollectionDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return CollectionDao.getTotals(map);
	}
	@Override
	public List<Collection> queryAll(int user_id) {
		return CollectionDao.queryAll(user_id);
	}
	@Override
	public void delete(int cid) {
		CollectionDao.delete(cid);
	}

}
