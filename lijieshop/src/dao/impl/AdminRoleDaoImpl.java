package dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.AdminRoleDao;
import entity.AdminRole;
@Repository("adminRoleDao")
public class AdminRoleDaoImpl extends BaseDaoImpl<AdminRole> implements AdminRoleDao{

	@Override
	public AdminRole query(int adminId, int userrole) {
		Map<String,Object> map=new HashMap<>();
		map.put("adminId", adminId);
		map.put("userrole", userrole);
		return getSqlSession().selectOne("AdminRole.query",map);
	}
}
