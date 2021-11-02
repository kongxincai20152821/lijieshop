package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.AdminDao;
import entity.Admin;
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	@Override
	public List<Admin> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Admin.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Admin.getTotals",map);
	}

	@Override
	public Admin queryAdmin(String username, String password) {
		Map<String,Object> map=new HashMap<>();
		map.put("username",username);
		map.put("password",password);
		return getSqlSession().selectOne("Admin.queryAdmin",map);
	}

}
