package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public List<User> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("User.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("User.getTotals",map);
	}

	@Override
	public User queryUser(String username, String password) {
		Map<String,Object> map=new HashMap<>();
		map.put("username",username);
		map.put("password",password);
		return getSqlSession().selectOne("User.queryUser",map);
	}

}
