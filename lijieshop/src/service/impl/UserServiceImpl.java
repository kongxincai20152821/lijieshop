package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource
	private UserDao userDao;
	@Override
	public List<User> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return userDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return userDao.getTotals(map);
	}
	@Override
	public User queryUser(String username, String password) {
		return userDao.queryUser(username,password);
	}

}
