package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AdminDao;
import entity.Admin;
import service.AdminService;
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

	@Resource
	private AdminDao adminDao;
	@Override
	public List<Admin> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return adminDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return adminDao.getTotals(map);
	}
	@Override
	public Admin queryAdmin(String username, String password) {
		return adminDao.queryAdmin(username,password);
	}

}
